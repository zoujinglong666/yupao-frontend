<template>
  <div v-for="item in recommendedList" :key="item.id">
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
  <van-empty v-if="!recommendedList.length" description="暂无数据"></van-empty>
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';
import {getRecommendedList} from "@/api/module/user";

const recommendedList = ref([])
const fetchRecommendedList = async () => {
  const {code, data} = await getRecommendedList();
  if (code == 0 && Array.isArray(data)) {
    data && data.forEach((el: any) => {
      el.tags = el.tags && JSON.parse(el.tags);
    })
    recommendedList.value = data as any;

  }

}

onMounted(() => {
  fetchRecommendedList()

})

</script>

<style scoped>

</style>