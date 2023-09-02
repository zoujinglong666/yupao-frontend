<template>
  <div>
    <van-cell title="编辑个人资料" is-link icon="coupon-o" @click="handleUserEdit"/>
  </div>
</template>
<script lang="ts" setup>

import {reactive} from "vue";
import {useRouter} from "vue-router";

const router = useRouter()
const user = reactive({})


const handleLogin = () => {

}
const handleUserEdit = () => {
  router.push("/user/edit")

}

</script>

<style scoped>
.personage {
  display: flex;
  width: 100%;
  height: 160px;
  background-color: #ff7f26;
  text-align: center;
  align-items: center;
  color: #fff;
}

img {
  box-sizing: border-box;
  width: 64px;
  height: 64px;
  margin-right: 20px;
  margin-left: 20px;
  border-radius: 64px;
  border: 2px solid #fff;
}


div {
  font-size: 14px;
  color: #999999;
}
</style>
