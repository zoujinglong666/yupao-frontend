<template>
  <van-header fixed
              placeholder
              title="搜索结果"
              left-arrow
  ></van-header>
  <div v-for="item in userList" :key="item.id">
    <van-card
        style="margin-bottom:8px"
        :desc="item.email"
        :title="item.username"
        :thumb="item.avatarUrl"
    >
      <template #tags>
        <van-tag style="margin-right:8px" plain type="primary" size="mini" v-for="(tag,index) in item.tags">{{
            tag
          }}
        </van-tag>
      </template>
    </van-card>
  </div>
  <van-empty v-if="!userList.length" description="暂无数据"></van-empty>
</template>

<script setup>
import {useRoute} from "vue-router";
import {onMounted, ref} from "vue";
import {Toast} from "vant";
import {searchTagList} from "@/api/module/user.ts";
const route = useRoute();
const userList = ref([]);
onMounted(()=>{
  getTagList()
})
const getTagList = async () => {
  const params = {tagList: route.query.tags};
  const {code,data} = await searchTagList(params);
  if(code===0){
   data.forEach(el => {
      el.tags = el.tags && JSON.parse(el.tags);
    })
    userList.value = data;
    if (!userList.value.length) {
      Toast.fail('暂无数据');
    }
  }

}

</script>

<style scoped>

</style>