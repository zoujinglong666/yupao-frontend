<template>
  <li >{{ item.context }}</li>
  <button @click="todoStore.removeItem(item)">remove</button>
</template>
<script lang="ts" setup>
import {defineProps} from "vue";
import {Item, useTodoStore} from "../store";

defineProps<{item:Item}>()
const todoStore = useTodoStore();

</script>

<style scoped>

</style>