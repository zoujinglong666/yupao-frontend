<template>
  <div style="padding-bottom: 46px">
    <form action="/" style="position:sticky;top: 0">
      <van-search
          v-model="searchValue"
          show-action
          placeholder="请输入标签搜索"
          @search="onSearch"
          @cancel="onCancel"
      />
    </form>

    <div v-for="(item,index) in tagList">
      <van-divider>{{ item.text }}</van-divider>
      <div class="tag-box" style="display: flex;justify-content: space-around;align-content: center;flex-wrap: wrap">
        <span v-for="tag in item.children" @click="handleSelectTags(tag.text)" class="tag"
              :class="[selectTagList.some(item=>item===tag.text)?'tag-activa':'']">{{ tag.text }}</span>
      </div>


    </div>
    <div style="position: fixed;bottom: 0;width: 100%">
      <van-button type="primary" block :loading="loading" @click="handleSearch" loading-text="加载中...">搜索</van-button>
    </div>
  </div>


</template>

<script setup>
import {ref, watch} from 'vue';
import {useRouter} from "vue-router";
import {Toast} from "vant";

const router = useRouter();
const searchValue = ref('');
const loading = ref(false);
const selectTagList = ref([]);
let originalArray = [
  {
    text: '技术',
    children: [
      {text: 'python'},
      {text: 'c++'},
      {text: 'java'},

    ],
  },
  {
    text: '性别',
    children: [
      {text: '女'},
      {text: '男'},
    ],
  },{
    text: '学历',
    children: [
      {text: '本科'},
      {text: '高中'},
      {text: '博士'},
    ],
  },

]
let tagList = ref(originalArray)
watch(searchValue, (newValue, oldValue) => {
  if (newValue === '') {
    tagList.value = originalArray;

  }
})
const onSearch = () => {
  tagList.value = originalArray.map(item => {
    const tempChildren = [...item.children];
    const tempParentTag = {...item};
    tempParentTag.children = tempChildren.filter(it => it.text === searchValue.value)
    return tempParentTag;
  }).filter(item => item.children.length > 0)


};
const handleSelectTags = (item) => {
  if (!selectTagList.value.includes(item)) {
    selectTagList.value.push(item)

  } else {
    selectTagList.value = selectTagList.value.filter(el => el !== item)
  }


  console.log(selectTagList.value)

}
const onCancel = () => {
  searchValue.value = '';
  tagList.value = originalArray;
  router.go(-1)
}
const handleSearch = () => {
  if (!selectTagList.value.length) {
    Toast.fail('请选择标签进行搜索');
    return
  }
  router.push({
    path: '/search/user/list',
    query: {
      tags: selectTagList.value
    }
  })

}

const activeIds = ref([]);
const activeIndex = ref(0);

const handleCloseTag = (tag, index) => {
  activeIds.value.splice(index, 1)

}


</script>

<style scoped>


.tag {
  display: inline-block;
  border: 1px solid #e7e7e7;
  width: 64px;
  height: 24px;
  text-align: center;
  line-height: 24px;
  background-color: #fff;
  border-radius: 4px;
  margin: 4px 12px;
}

.tag-box::after {
  content: '';
  display: inline-block;
  width: 64px;
  height: 24px;
  text-align: center;
  line-height: 24px;
  background-color: #fff;
  border-radius: 4px;
  margin: 4px 12px;
}

.tag-activa {
  background-color: var(--van-primary-color);
  color: #fff;
}

</style>