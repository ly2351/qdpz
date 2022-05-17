<template>
	<view class="components-home">
		<view class="bgImg">
			
			<view class="bannerBox">
				<swiper style="height: 680rpx;" class="swiper" @change="cardSwiper" circular="true" indicator-dots="true" autoplay="true" interval="4000" duration="600">
					<swiper-item class="swiper-list" v-for="(item, index) in bannerList" :key="index">
						<view class="swiper-item uni-bg-red">
							<image class="swiper-img radius shadow-warp" :src="item.imageUrl" mode="widthFix"></image>
						</view>
					</swiper-item>
				</swiper>
				<view class="indication">
				    <block v-for="(item,index) in bannerList" :key="index">
				        <view class="spot" :class="cardCur == index ? 'active': '' "></view>
				    </block>
				</view>
			</view>
			
			<view class="left_box shadow-warp" style="padding: 20rpx 20rpx 20rpx 10rpx;">
				<view class="cu-avatar lgs round margin-right-sm margin-left-xs fl" style="background-image:url(https://cdn.zhoukaiwen.com/qdpz_hy3.svg);"></view>
				<view class="text-bold fl margin-top-xs text-shadow">VIP会员 ·<text class="text-orange">￥699</text></view>
				<viwe class="text-grey text-sm margin-top-xs fl text-shadow">加入会员群，组件永久免费</viwe>
			</view>
			
			
				<view class="right_box shadow-warp">
					<button class='content cu-btn' open-type="contact" style="display: contents;">
						<view class="text-xxl" style="height: 64rpx; margin-top: 12rpx;">
							<image src="https://cdn.zhoukaiwen.com/qdpz_hz1.svg" mode="widthFix" style="width: 65rpx;"></image>
						</view>
						<view class="text-shadow text-black text-bold" style="font-size: 26rpx; margin-top: 12rpx;">合作联系</view>
					</button>
				</view>
			
		</view>
		<view class="mainBox flex justify-between">
			<view @click="goPoster" class="mainBtn shadow-warp radius bg-white padding-sm margin-xs radius text-center">
				<view style="text-align: center;">
					<image src="https://cdn.zhoukaiwen.com/qdpz_hbbj3.gif" mode="widthFix" style="width: 125rpx;border-radius: 20rpx;"></image>
				</view>
				<view class="text-bold text-black text-lg margin-top-sm text-shadow">海报编辑器</view>
				<view class="margin-top-sm text-gray text-sm text-shadow"><text class="text-orange margin-right-xs text-bold">￥699</text> 享受终身VIP服务</view>
			</view>
			
			<view @click="goPicEditor" class="mainBtn shadow-warp radius bg-white padding-sm margin-xs radius text-center">
				<view style="text-align: center;">
					<image src="https://cdn.zhoukaiwen.com/qdpz_pic1.svg" mode="widthFix" style="width: 125rpx;"></image>
				</view>
				<view class="text-bold text-black text-lg margin-top-sm text-shadow">图片编辑器</view>
				<view class="margin-top-sm text-gray text-sm text-shadow"><text class="text-orange margin-right-xs text-bold">￥199</text> 会员源码免费</view>
			</view>
		</view>
		
		<view class="padding">
			<view class="flex">
				<view @click="goMatting" class="flex-sub bg-white padding-sm margin-sm radius shadow-warp" style="line-height: 80rpx;">
					<image class="fl margin-right-sm" src="https://cdn.zhoukaiwen.com/qdpz_kt1.svg" mode="widthFix" style="width: 68rpx;margin-top: 8rpx;"></image>
					<view class="text-shadow">智能抠图</view>
				</view>
				<view  class="flex-sub bg-white padding-sm margin-sm radius shadow-warp" style="line-height: 80rpx;">
					<image class="fl margin-right-sm" src="https://cdn.zhoukaiwen.com/qdpz_more2.svg" mode="widthFix" style="width: 70rpx;margin-top: 5rpx;"></image>
					<view class="text-shadow">敬请期待</view>
				</view>
			</view>
			
			<view class="padding">
				<view class="text-center text-grey text-sm margin-top-xxl">· 前端铺子 ·</view>
				<view class="text-center text-grey text-sm margin-tb-sm">开源地址：https://gitee.com/kevin_chou/qdpz</view>
			</view>
			
			<!--  @click="goOutSki"  --><!-- 外滑攻略 -->
			<!-- <view class="flex">
				<view @click="goOldEquip" class="flex-sub bg-white padding-sm margin-sm radius shadow-warp" style="line-height: 80rpx;">
					<image class="fl margin-right-sm" src="https://cdn.zhoukaiwen.com/huaxueban.svg" mode="widthFix" style="width: 80rpx;"></image>
					<view class="text-shadow">二手装备</view>
				</view>
				<view @click="goBigPro" class="flex-sub bg-white padding-sm margin-sm radius shadow-warp" style="line-height: 80rpx;">
					<image class="fl margin-right-sm" src="https://cdn.zhoukaiwen.com/dapro.svg" mode="widthFix" style="width: 80rpx;"></image>
					<view class="text-shadow">友情链接</view>
				</view>
			</view> -->
		</view>
		<view style="height: 120rpx;width: 1rpx;"></view>
			
	</view>
</template>

<script>
	import request from '@/common/request.js';
	export default {
		data() {
			return {
				cardCur: 0,
				bannerList:[
					{
						imageUrl: 'https://cdn.zhoukaiwen.com/qh_banner8.jpg'
					},
					{
						imageUrl: 'https://cdn.zhoukaiwen.com/qdpz_banner3.jpg'
					}
				],
				roomAddress: '', //酒店地址
			}
		},
		onShow() {
			
		},
		mounted() {
			
		},
		methods: {
			cardSwiper(e) {
			  this.cardCur = e.detail.current
			},
			goPoster(){
				uni.navigateTo({
					url: '../main/posterList'
				})
			},
			goPicEditor(){
				uni.navigateTo({
					url: '../main/customCamera'
				})
			},
			goMatting(){
				uni.showToast({
					title: '会员页面，暂不开放',
					icon: 'none',
					duration: 3000
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
	.swiper-item {
		height: 100%;
	}
	/* 轮播指示点 start*/
	.indication{
	  z-index: 9999;
	  width: 100%;
	  height: 36rpx;
	  position: absolute;
	  display:flex;
	  flex-direction:row;
	  align-items:center;
	  justify-content:center;
	}
	
	.spot{
	  background-color: #FFFFFF;
	  opacity: 0.6;
	  width: 10rpx;
	  height: 10rpx;
	  border-radius: 20rpx;
	  top: -130rpx;
	  margin: 0 8rpx !important;
	  position: relative;
	}
	
	.spot.active{
	  opacity: 1;
	  width: 30rpx;
	  background-color: #0081ff;
	}
	.bgImg{
		position: relative;
		margin-bottom: 100rpx;
		.left_box{
			position: absolute;
			height: 130rpx;
			width: 60%;
			background: #ffffff;
			bottom: -55rpx;
			left: 5%;
			border-radius: 15rpx;
		}
		.right_box{
			text-align: center;
			position: absolute;
			height: 130rpx;
			width: 25%;
			background: #ffffff;
			bottom: -55rpx;
			right: 5%;
			border-radius: 15rpx;
		}
	}
	.mainBox{
		width: 750rpx;
		height: 300rpx;
		padding: 0 5%;
		margin-bottom: 10rpx;
		.mainBtn{
			width: 45%;
		}
	}
	.radius {
		border-radius: 18rpx !important;
	}
</style>
