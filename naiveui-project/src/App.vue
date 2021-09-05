<template>
<div>
  <input type="text" v-model="mytext">
  <button>Add</button>
</div>
<router-view></router-view>
</template>

<script >
  import { NButton } from 'naive-ui'
  export default {
    components: {
      NButton
    },
    setup(){
      const state=reactive({
        mytext:''
      })
    }

  }
  </script>
<style>

</style>
