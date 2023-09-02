<template>
  <div v-show="bottomTabBarShow">
    <van-nav-bar fixed
                placeholder
                title="标题"
                left-arrow
                right-text="search"
                @click-right="onClickRight"
    />

  </div>


  <router-view></router-view>
  <van-tabbar v-model="active" route v-show="bottomTabBarShow">
    <van-tabbar-item icon="home-o" name="index" to="/" replace>主页</van-tabbar-item>
    <van-tabbar-item icon="search" name="team" to="/team" replace>队伍</van-tabbar-item>
    <van-tabbar-item icon="friends-o" name="user" to="/user" replace>用户</van-tabbar-item>
  </van-tabbar>


</template>

<script setup>
import {computed, onMounted, ref} from 'vue';
import {useRouter} from "vue-router";
import vanHeader from "../components/vanHeader.vue";


const router = useRouter();

const onClickLeft = () => history.back()
const onClickRight = () => {
  router.push("/search")
};
const active = ref("index");
// const onChange = (index) => Toast(`标签 ${index + 1}`);
onMounted(() => {
  console.log('onMounted')
})

const bottomTabBarShow = computed(() => {
  let path = router.currentRoute.value.path;
  let activePath = ['/user', '/team', '/']
  return activePath.includes(path);

})

</script>

<style scoped>

</style>