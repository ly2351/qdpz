<template>
	<view class='contents'>
		<!-- 头部盒子 包裹水印 图片和操作框 -->
		<!-- <view style="position: relative;width: 100%;height: 750rpx;" :class="imgRotate==0?'rotate0':(imgRotate==1?'rotate1':(imgRotate==2?'rotate2':'rotate3'))"> -->
		<!-- <view class="textInfo" v-show="dataInfo.syShow">
				<view class="textInfoTile">示例Demo</view>
				<view class="topItem">拍摄时间：{{dataInfo.nowTime}}</view>
				<view class="topItem">天气：{{dataInfo.weather}}℃</view>
				<view class="topItem">拍摄人：{{dataInfo.userName}}</view>
				<view class="topItem">地点：{{dataInfo.address}}</view>
			</view> -->
		<!-- <image style="width: 100%;height: 750rpx;position: absolute;" mode="widthFix" :src="dataInfo.src" ></image> -->
		<!-- <photoEdit></photoEdit> -->
		<web-view :src="webViewUrl" @message="message"></web-view>

		<!-- </view> -->


	</view>
</template>

<script>
	var touchs = [];
	var content = null;
	import Handwriting from "../common/signature.js"
	// import photoEdit from "../../components/photoEdit.vue"
	export default {
		components: {
			// photoEdit
		},
		data() {
			return {
				webViewUrl: '',
				editText: '',
				isShow: 'edit',
				dataInfo: {},
				lineColor: 'black',
				slideValue: 50,
				handwriting: '',
				selectColor: 'black',
				color: '',
				showimg: '',
				share_popup: false,
				editValue: '',
				editId: 4,
				editFlag: false,
				editFlagInd: '',
				editArr: [{
						id: 2,
						type: 'img',
						url: 'http://tmp/wx882474815048b124.o6zAJs6zLBrqHZ6rE0r60_jbIB-I.iJl90E6G2DmW54aff795486e1f09393fe05826536b54.png',
						width: 375,
						height: 250,
						active: false,
						top: 0,
						left: 0,
					},
					{
						id: 3,
						type: 'text',
						text: '这是一段文字',
						color: '#ffffff',
						width: 50,
						height: 50,
						active: false,
						top: 300,
						left: 100,
						radius: 0,
						rotate: 0,
					},
				], //数组
				imgRotate: 0,
				shapeBox: 'tx',
			}
		},
		onShow() {
			this.dataInfo = uni.getStorageSync("userInfo")
			// this.webViewUrl='http://192.168.5.119:8080/?url='+this.dataInfo.src
			this.webViewUrl = 'https://www.zhoukaiwen.com/proj/imageEditor/index.html'
			console.log(this.dataInfo)
		},
		onLoad() {
			this.handwriting = new Handwriting({
				lineColor: this.lineColor,
				slideValue: this.slideValue, // 0, 25, 50, 75, 100
				canvasName: 'handWriting',
			})
		},
		methods: {
			message(e) {
				console.log(e)
				let imgData = e.detail.data[0].imgData
				this.saveImageToPhotosAlbum(imgData)
			},
			saveImageToPhotosAlbum(imgData) {
				// let base64=this.img_.replace(/^data:image\/\w+;base64,/, "");//去掉data:image/png;base64,
				let filePath = wx.env.USER_DATA_PATH + '/hym_pay_qrcode.png';
				uni.getFileSystemManager().writeFile({
					filePath: filePath, //创建一个临时文件名
					data: imgData, //写入的文本或二进制数据
					encoding: 'base64', //写入当前文件的字符编码
					success: res => {
						uni.saveImageToPhotosAlbum({
							filePath: filePath,
							success: function(res2) {
								// 	title: '保存成功',
								uni.showToast({
									title: '图片保存成功',
									icon: 'none'
								})
								console.log('保存成功');
							},
							fail: function(err) {
								console.log(err.errMsg);
								uni.showToast({
									title: '图片保存失败',
									icon: 'none'
								})
							}
						})
					},
					fail: err => {
						console.log(err)
						uni.showToast({
							title: '图片保存失败',
							icon: 'none'
						})
					}
				})
			},



			// handleScaleStart(e) {
			// 	var self = this;
			// 	for (let i = 0; i < this.editArr.length; i++) { // 找到点击的
			// 		this.editArr[i].active = false;
			// 		if (e.currentTarget.dataset.id == this.editArr[i].id) {
			// 			this.index = i // 下标索引
			// 			this.editArr[this.index].active = true; // 当前选中
			// 		}
			// 	}
			// 	// 移动前点击的位置
			// 	this.beforeMove = {
			// 		x: e.touches[0].clientX,
			// 		y: e.touches[0].clientY
			// 	}
			// },
			// //重拍
			// morePhone(){
			// 	uni.navigateBack({})
			// },
			// //图形选择
			// shapeSelect(event){
			// 	this.shapeBox=event
			// },
			// // 旋转
			// rotate(){
			// 	if(this.imgRotate==3){
			// 		this.imgRotate=0
			// 	}else{
			// 		this.imgRotate++
			// 	}
			// },
			// handleScaleMove(e) {
			// 	//移动时
			// 	this.afterMove = {
			// 		x: e.touches[0].clientX,
			// 		y: e.touches[0].clientY
			// 	}
			// 	//改动值赋值给当前原生属性
			// 	this.editArr[this.index].width += this.afterMove.x - this.beforeMove.x; // x方向
			// 	this.editArr[this.index].height += this.afterMove.y - this.beforeMove.y; // y方向

			// 	// 新的位置复制为移动前的位置
			// 	this.beforeMove = {
			// 		x: e.touches[0].clientX,
			// 		y: e.touches[0].clientY
			// 	}
			// },
			// // 删除元素
			// handleDel(i) {
			// 	this.editArr.splice(i, 1)
			// },
			// // 编辑文本
			// handleEdit(item, i) {
			// 	console.log(item, i, 123)
			// 	this.editValue = item.text
			// 	this.editFlag = true
			// 	this.editFlagInd = i
			// 	// this.currentIndex = i
			// 	// this.fontShow = true
			// 	// this.font = item
			// },
			// // 新增一个文本
			// addItem(e) {
			// 	if (this.editFlag) {
			// 		this.editFlag = false
			// 		this.editArr[this.editFlagInd].text = this.editValue
			// 	} else {
			// 		this.editArr.push({
			// 			id: this.editId++,
			// 			type: 'text',
			// 			text: this.editValue,
			// 			color: '#ffffff',
			// 			width: 50,
			// 			height: 50,
			// 			active: false,
			// 			top: 200,
			// 			left: 100,
			// 		})
			// 	}
			// 	this.editValue = ''
			// 	// this.editArr.push(e.target.value)
			// 	console.log(this.editArr, typeof this.editArr)
			// },
			// // 文字框点击
			// handleTouchStart(e) {
			// 	var self = this;
			// 	for (let i = 0; i < this.editArr.length; i++) { // 找到点击的
			// 		this.editArr[i].active = false;
			// 		if (e.currentTarget.dataset.id == this.editArr[i].id) {
			// 			this.index = i // 下标索引
			// 			this.editArr[this.index].active = true; // 当前选中
			// 		}
			// 	}
			// 	// 移动前点击的位置
			// 	this.beforeMove = {
			// 		x: e.touches[0].clientX,
			// 		y: e.touches[0].clientY
			// 	}
			// },
			// handleTouchMove(e) {
			// 	//移动时
			// 	this.afterMove = {
			// 		x: e.touches[0].clientX,
			// 		y: e.touches[0].clientY
			// 	}
			// 	//改动值赋值给当前原生属性
			// 	this.editArr[this.index].left += this.afterMove.x - this.beforeMove.x; // x方向
			// 	this.editArr[this.index].top += this.afterMove.y - this.beforeMove.y; // y方向

			// 	// 新的位置复制为移动前的位置
			// 	this.beforeMove = {
			// 		x: e.touches[0].clientX,
			// 		y: e.touches[0].clientY
			// 	}
			// },

			// // 选择画笔颜色
			// selectColorEvent(event) {
			// 	this.selectColor = event;
			// 	if (event == 'black') {
			// 		this.color = '#1A1A1A'
			// 	} else if (event == 'red') {
			// 		this.color = '#ff4444'
			// 	} else if( event == 'white'){
			// 		this.color = '#ffffff'
			// 	} else if (event == 'yellow') {
			// 		this.color = '#EFA53A'
			// 	} else if( event == 'blue'){
			// 		this.color = '#578EE3'
			// 	} else if( event == 'green'){
			// 		this.color = '#6EE49D'
			// 	}
			// 	this.handwriting.selectColorEvent(this.color)
			// },
			// retDraw() {
			// 	this.handwriting.retDraw()
			// },
			// // 笔迹粗细滑块
			// updateValue(e) {
			// 	console.log(e.detail);
			// 	this.slideValue = e.detail.value;
			// 	this.handwriting.selectSlideValue(this.slideValue);
			// },
			// uploadScaleStart(event) {
			// 	this.handwriting.uploadScaleStart(event)
			// },
			// uploadScaleMove(event) {
			// 	this.handwriting.uploadScaleMove(event)
			// },
			// uploadScaleEnd(event) {
			// 	this.handwriting.uploadScaleEnd(event)
			// },
			// subCanvas() {
			// 	this.handwriting.saveCanvas().then(res => {
			// 		this.showimg = res;
			// 		console.log(res);
			// 		this.editArr.push({
			// 			id: this.editId++,
			// 			type: 'img',
			// 			url: this.showimg,
			// 			width: 375,
			// 			height: 250,
			// 			active: false,
			// 			top: 0,
			// 			left: 0,
			// 		})
			// 		this.isShow = 'text'
			// 	}).catch(err => {
			// 		console.log(err);
			// 	});

			// },
		}
	}
</script>

<style lang="scss">
	// .editProp{
	// 	position: absolute;
	// 	top: 0;
	// 	left: 0;
	// 	width: 100%;
	// 	height: 100vh;
	// 	background-color: rgba(0,0,0,.8);
	// 	z-index: 99999;
	// 	.input{
	// 		position: absolute;
	// 		top: 300rpx;
	// 		left: 0;
	// 		width: 650rpx;
	// 		margin: 0 40rpx;
	// 		box-sizing: border-box;
	// 		height: 80rpx;
	// 	}
	// 	.editBtn{
	// 		width: 100%;
	// 		box-sizing: border-box;
	// 		display: flex;
	// 		justify-content: space-between;
	// 		padding: 0 40rpx;
	// 		position: absolute;
	// 		top: 20rpx;
	// 		left: 0;
	// 		.cal{
	// 			height: 70rpx;
	// 			border-radius:40rpx ;
	// 			background-color: #C0C0C0;
	// 			color: #FFFFFF;
	// 			line-height: 70rpx;
	// 			text-align: center;
	// 			font-weight: 500;
	// 			padding: 0 30rpx;
	// 		}
	// 		.sure{
	// 			height: 70rpx;
	// 			border-radius:40rpx ;
	// 			background-color: #1FA9D0;
	// 			color: #FFFFFF;
	// 			line-height: 70rpx;
	// 			text-align: center;
	// 			font-weight: 500;
	// 			padding: 0 30rpx;
	// 		}
	// 	}
	// }
	// .editAll {
	// 	position: relative;
	// 	width: 100%;
	// 	height: 100vh;
	// 	background-color: skyblue;
	// 	z-index: 99999;

	// 	.editItem {
	// 		position: absolute;
	// 		display: block;
	// 		overflow: hidden;
	// 		word-break: break-all;
	// 		line-height: 1;

	// 		&.active {
	// 			border: 7rpx dashed #FFFFFF;
	// 		}
	// 	}

	// 	.scale-icon {
	// 		position: absolute;
	// 		width: 40rpx;
	// 		height: 40rpx;
	// 	}
	// }

	// .footer{
	// 	position: relative;
	// 	z-index: 9;
	// }
	// // 工具选择
	// .checkAll {
	// 	width: 100%;
	// 	box-sizing: border-box;
	// 	position: absolute;
	// 	top: 180rpx;
	// 	left: 0;
	// 	height: 100rpx;
	// 	display: flex;
	// 	justify-content: space-between;
	// 	align-items: center;
	// 	background-color: #000000;
	// 	padding: 0rpx 40rpx;
	// 	// margin-left: 30rpx;
	// 	// margin-top: 50rpx;
	// 	.checkAllItem{
	// 		display: flex;
	// 		align-items: center;
	// 	}
	// 	.checkItem {
	// 		width: 50rpx;
	// 		height: 50rpx;
	// 		margin-right: 30rpx;
	// 		// background-color: skyblue;

	// 		background-size: 100%;
	// 	}
	// 	.handleBtnUndo{
	// 		color: #FFFFFF;
	// 		line-height: 100rpx;
	// 		font-weight: 500;
	// 		image{
	// 			width: 50rpx;
	// 			height: 50rpx;
	// 			vertical-align: middle;
	// 			margin-right: 5rpx;
	// 		}
	// 	}
	// }
	// .btnBox{
	// 	position: absolute;
	// 	top: 280rpx;
	// 	left: 0;
	// 	display: flex;
	// 	justify-content: space-between;
	// 	align-items: center;
	// 	width: 100%;
	// 	height: 120rpx;
	// 	padding: 0 40rpx;
	// 	box-sizing: border-box;
	// 	.left{
	// 		color: #FFFFFF;
	// 		font-weight: 500;
	// 	}
	// 	.right{
	// 		display: flex;
	// 		align-items: center;
	// 		.save{
	// 			height: 70rpx;
	// 			border-radius:40rpx ;
	// 			background-color: #C0C0C0;
	// 			color: #FFFFFF;
	// 			line-height: 70rpx;
	// 			text-align: center;
	// 			font-weight: 500;
	// 			padding: 0 30rpx;
	// 		}
	// 		.saveSend{
	// 			height: 70rpx;
	// 			border-radius:40rpx ;
	// 			background-color: #1FA9D0;
	// 			color: #FFFFFF;
	// 			line-height: 70rpx;
	// 			text-align: center;
	// 			margin-left: 20rpx;
	// 			font-weight: 500;
	// 			padding: 0 30rpx;
	// 		}
	// 	}
	// }
	// .wrapper {
	// 	width: 100%;
	// 	height: 100%;
	// 	margin: 30upx 0;
	// 	overflow: hidden;
	// 	display: flex;
	// 	align-content: center;
	// 	flex-direction: column;
	// 	justify-content: center;
	// 	font-size: 28upx;
	// }

	// .handWriting {
	// 	background: #fff;
	// 	width: 100%;
	// 	height: 350upx;
	// }

	// .handRight {
	// 	align-items: center;
	// }

	// .handCenter {
	// 	border: 4upx dashed #e9e9e9;
	// 	flex: 5;
	// 	overflow: hidden;
	// 	box-sizing: border-box;
	// 	width: 90%;
	// 	margin: 0 auto;
	// }

	// .handTitle {
	// 	flex: 1;
	// 	color: #666;
	// 	justify-content: center;
	// 	font-size: 30upx;
	// }

	// .handBtn {
	// 	flex-direction: column;
	// 	padding: 40upx 20upx;
	// }

	// .buttons {
	// 	width: 100%;
	// 	margin-top: 20upx;
	// 	justify-content: space-between;
	// }

	// .buttons>button {
	// 	font-size: 30upx;
	// 	height: 80upx;
	// 	width: 120upx;
	// }

	// .delBtn {
	// 	color: #666;
	// }
	// .colorMain{
	// 	width: 100%;
	// 	height: 100rpx;
	// 	background-color: #141414;
	// 	overflow-x: auto;
	// 	position: absolute;
	// 	top: 80rpx;
	// 	left: 0;
	// 	display: flex;
	// 	align-items: center;
	// 	padding: 0 40rpx;
	// }
	// .shapeBox{
	// 	display: flex;
	// 	align-items: center;

	// }
	// .shapeBac{
	// 	display: flex;
	// 	align-items: center;
	// }
	// .shapeBac>image{
	// 	width: 60rpx;
	// 	height: 60rpx;
	// 	margin-right: 20rpx;
	// }
	// .shapejiantou{
	// 	transform: rotate(180deg);
	// }
	// .color {
	// 	// width: 100%;
	// 	height: 100rpx;
	// 	// background-color: #141414;
	// 	display: flex;
	// 	align-items: center;
	// 	// padding: 0 40rpx;
	// }

	// .color>text {
	// 	margin-right: 20upx;
	// }

	// .subBtn {
	// 	background: #008ef6;
	// 	color: #fff;
	// 	text-align: center;
	// 	justify-content: center;
	// }

	// .black-select {
	// 	width: 60upx;
	// 	height: 60upx;
	// }

	// .black-select.color_select {
	// 	width: 90upx;
	// 	height: 90upx;
	// }

	// .red-select {
	// 	width: 60upx;
	// 	height: 60upx;
	// }

	// .color_select {
	// 	width: 60upx;
	// 	height: 60upx;
	// 	border-radius: 50%;
	// 	margin: 10upx;
	// 	box-sizing: border-box;
	// 	border: 10upx solid #FFFFFF;

	// }
	// .colorBox{
	// 	width: 50upx;
	// 	height: 50upx;
	// 	padding: 5upx;
	// 	margin: 15upx;
	// 	border-radius: 50%;
	// 	box-sizing: border-box;
	// 	border: 5upx solid #FFFFFF;
	// }
	// .slide-wrapper {
	// 	align-items: center;
	// 	margin-bottom: 20upx;
	// }

	// .slider {
	// 	width: 400upx;
	// 	padding-left: 20upx;
	// }

	// .drop {
	// 	width: 50upx;
	// 	height: 50upx;
	// 	border-radius: 50%;
	// 	background: #FFF;
	// 	position: absolute;
	// 	left: 0upx;
	// 	top: -10upx;
	// 	box-shadow: 0px 1px 5px #888888;
	// }

	// .slide {
	// 	width: 250upx;
	// 	height: 30upx;
	// }

	// .showimg {
	// 	border: 4upx solid #e9e9e9;
	// 	overflow: hidden;
	// 	width: 90%;
	// 	margin: 0 auto;
	// 	background: #eee;
	// 	height: 350upx;
	// 	margin-top: 40upx;
	// 	align-items: center;
	// 	justify-content: center;
	// }

	// .showimg>image {
	// 	width: 100%;
	// 	height: 100%;
	// }

	// .showimg>text {
	// 	font-size: 40upx;
	// 	color: #888;
	// }

	// .firstCanvas {
	// 	z-index: 100;
	// 	background-color: pink;
	// 	width: 100%;
	// 	height: 750rpx;
	// }

	// .contents {
	// 	height: 100vh;
	// 	position: relative;
	// 	background-color: #141414;
	// }

	// // .contents image {
	// // 	width: 100%;
	// // 	height: 200px;
	// // 	background-color: orange;
	// // }

	// // 水印
	// .textInfo {
	// 	position: absolute;
	// 	top: 10rpx;
	// 	left: 10rpx;
	// 	width: 350rpx;
	// 	box-sizing: border-box;
	// 	color: #EEEEEE;
	// 	font-size: 16rpx;
	// 	background-color: #393631;
	// 	opacity: .8;
	// 	border-radius: 10rpx;
	// 	overflow: hidden;
	// 	z-index: 99;

	// 	.textInfoTile {
	// 		height: 30rpx;
	// 		text-align: center;
	// 		line-height: 30rpx;
	// 		background-color: #394668;
	// 		margin-bottom: 15rpx;
	// 	}

	// 	.topItem {
	// 		padding-left: 30rpx;
	// 		width: 100%;
	// 		white-space: pre-wrap;
	// 		margin-bottom: 15rpx;
	// 	}
	// }
	// .rotate0{
	// 	transform: rotate(0deg);
	// }
	// .rotate1{
	// 	transform: rotate(90deg);
	// }
	// .rotate2{
	// 	transform: rotate(180deg);
	// }
	// .rotate3{
	// 	transform: rotate(270deg);
	// }
</style>
