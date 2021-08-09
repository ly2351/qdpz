<!-- 证件识别 -->
<template>
	<view>
		<cu-custom class="navBox" bgColor="bg-gradual-blue" :isBack="true">
			<block slot="backText">返回</block>
			<block slot="content">课程表</block>
		</cu-custom>
		
		<scroll-view scroll-x class="bg-white nav" scroll-with-animation :scroll-left="scrollLeft">
			<view class="flex text-center">
				<view class="cu-item flex-sub" :class="index == TabCur?'text-blue cur':''" v-for="(item,index) in navTop" :key="index" @tap="tabSelect"
				 :data-id="index">
					{{item.title}}
				</view>
			</view>
		</scroll-view>

		<view class="container">
			<!-- 中小学课程 UI样式 -->
			<view>
				<view class="flex p-xs mb-sm padding-left-xxl">
					<view class="flex-sub bg-grey padding-sm margin-xs radius">1</view>
					<view class="flex-sub bg-grey padding-sm margin-xs radius">2</view>
					<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
					<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
					<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
				</view>
				
				<view class="bg-white">
					<view class="flex solid-bottom align-start">
						<view class="" style="width: 80rpx;line-height: 90rpx;text-align: center;">1</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
					</view>
					<view class="flex solid-bottom align-start">
						<view class="" style="width: 80rpx;line-height: 45px;text-align: center;">2</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
					</view>
					<view class="flex solid-bottom align-start">
						<view class="" style="width: 80rpx;line-height: 45px;text-align: center;">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
						<view class="flex-sub bg-grey padding-sm margin-xs radius">3</view>
					</view>
				</view>
			</view>
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
