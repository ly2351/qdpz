<!-- 证件识别 -->
<template>
	<view>
		<cu-custom class="navBox" bgColor="bg-gradual-blue" :isBack="true">
			<block slot="backText">返回</block>
			<block slot="content">课程表</block>
		</cu-custom>
		
		<scroll-view scroll-x class="bg-white nav" scroll-with-animation :scroll-left="scrollLeft">
			<view class="cu-item" :class="index == TabCur?'text-blue cur':''" v-for="(item,index) in navTop" :key="index" @tap="tabSelect"
			 :data-id="index">
				{{item.title}}
			</view>
		</scroll-view>

		<view class="container">
			
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				TabCur: 0,
				scrollLeft: 0,
				navTop:[
					{
						id: 0,
						title: '大学课程'
					},
					{
						id: 1,
						title: '中小学课程'
					}
				]
			}
		},
		watch: {

		},
		onReady() {
			
		},
		mounted() {

		},
		methods: {
			tabSelect(e) {
				this.TabCur = e.currentTarget.dataset.id;
				this.scrollLeft = (e.currentTarget.dataset.id - 1) * 60
			},
		}
	}
</script>

<style lang="scss" scoped>
	.container {
		height: 100%;
	}
</style>
