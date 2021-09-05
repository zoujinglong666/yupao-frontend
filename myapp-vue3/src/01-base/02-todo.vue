<template>
  <div>
    <input type="text" v-model="state.mytext"  ref="aaa"/>
    {{ state.mytext }}
    <button type="button" @click="handleAdd">add</button>

    <ul>
      <li v-for="item in state.dataList" :key="item.index">
        {{ item }}--
        <button @click="handleDel(index)">shanchu</button>
      </li>
    </ul>
  </div>
</template>

<script>
import { reactive } from "@vue/reactivity"
export default {

  setup() {
    const state = reactive({
      mytext: '',
      dataList: ["1111", "22222", "3333"]
    })

    const handleAdd = () => {

      if (state.mytext.trim() === '') {
        alert("请输入内容")
        return false
      }
      console.log(123)
      state.dataList.push(state.mytext)
      state.mytext = ''

    }
    const handleDel = (index) => {
        console.log(index);
      state.dataList.splice(index, 1)
    
    }



    return {
      state,
      handleAdd,
      handleDel


    }


  }
}
</script>

<style>
</style>
