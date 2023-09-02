<template>
  <div>
    <div>
      {{ getTodoItemCount }}
    </div>
    <input type="text" v-model="todoStore.newItem">
    <button @click="todoStore.addItem">add</button>

    <ul v-for="item in todoStore.todoItems " :key="item.id">
      <todo-item :item="item"></todo-item>
    </ul>
  </div>
</template>

<script setup lang="ts">
import {useTodoStore} from "../store";
import TodoItem from './TodoItem.vue'
import {storeToRefs} from "pinia";

const todoStore = useTodoStore();
//为了解决响应式丢失问题
// 与torefs
const {getTodoItemCount} = storeToRefs(todoStore);



</script>

<style scoped>

</style>