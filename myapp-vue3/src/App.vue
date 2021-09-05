<template>
  <div>
   <ul>
     <router-link to="/film">film</router-link> 
   </ul>
  </div>

  <router-view />
</template>

<script>
export default {
  setup() {
    return {};
  }
};
</script>

<style lang="less"></style>
