<template>
  <van-search
      v-model="oid"
      show-action
      placeholder="请输入评论区id"
  >
    <template #action>
      <div @click="onClickButton(oid)">搜索</div>
    </template>
  </van-search>
  <!--    {{dayjs(new Date()).format('YYYY-MM-DD hh:mm:ss')  }}-->
  <van-tabs v-model:active="active">
    <van-tab :title="item.oid" v-for="item in tabList" :key="item">
      <div v-for="data in dataList">

      </div>
      {{ item.oid }}
    </van-tab>

  </van-tabs>

</template>
<script setup>
import {Toast} from 'vant';
import io from 'socket.io-client';
import {ref} from 'vue';
import dayjs from "dayjs"

const active = ref(0)
const oid = ref('')
const tabList = ref([])
const dataList = ref([])


const onClickButton = () => {
  if (!oid.value) return Toast.fail('评论区id不能为空');
  const newTab = {
    content: "",
    oid: oid.value
  }
  if (tabList.value.some(item => item.oid === oid.value)) {
    Toast.fail('请勿重复监听');
    oid.value = '';
  } else {
    tabList.value.push(newTab)
    oid.value = ''
  }
}

const socket = io();
socket.on('sendData', function (data) {
  dataList.value = data.dataList;
  console.log(dataList)
});


</script>
<style>

</style>
