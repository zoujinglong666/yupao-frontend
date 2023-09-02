<template>
  <van-header fixed
              placeholder
              title="修改个人信息"
              left-arrow

  >
  </van-header>
  <van-cell title="头像" style="display: flex;align-items: center;" is-link>
    <van-image
        round
        width="32px"
        height="32px"
        :src="userInfo.avatarUrl"
    />
  </van-cell>
  <van-cell @click="doEdit('昵称','userAccount')" title="昵称" :value="userInfo.userAccount" is-link/>
  <van-cell @click="doEdit('性别','gender')" title="性别" :value="userInfo.gender?'男':'女'" is-link/>
  <van-cell @click="doEdit('邮箱','email')" title="邮箱" :value="userInfo.email" is-link/>
  <van-cell @click="doEdit('电话','phone')" title="电话" :value="userInfo.phone" is-link/>
  <van-cell title="注册时间" :value="timeFormatSeconds(userInfo.createTime)" is-link/>
  <div style="position: fixed;bottom: 0;width: 100%">
    <van-button plain type="danger" block @click="logOutOfLogin">退出登录</van-button>
  </div>
</template>

<script setup lang="ts">
import {useRouter} from "vue-router";
import VanHeader from "@/components/vanHeader.vue";

const router = useRouter();
import {getUserInfo} from "@/api/module/user";
import {onMounted, ref} from "vue";
import useDate from "@/hooks/useDate/useDate";
import {logoutApi} from "@/api/module/login";
import {Toast} from "vant";

const userInfo = ref({})
const {timeFormatSeconds} = useDate()
const fetchUserInfo = async () => {
  const {data, code} = await getUserInfo();
  userInfo.value = data as any;
}

onMounted(() => {
  fetchUserInfo();
})
const doEdit = (title: string, key: string) => {
  router.push({
    path: "/user/edit/detail",
    query: {
      title: title,
      key: key,
      userInfo: JSON.stringify(userInfo.value)
    }
  })

}
const logOutOfLogin = async () => {
  const {data, code} = await logoutApi();
  if (data && code === 0) {
    await router.replace('/login');
    Toast.success('已退出登录')
  }

}

const onClickLeft = () => {
  router.back()
}
</script>

<style scoped>

</style>
