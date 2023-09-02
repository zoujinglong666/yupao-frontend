<template>
  <van-nav-bar
      :title="title"
      left-arrow
      @click-left="goBack"

  />
</template>

<script>
import {ref} from 'vue'
import {useRouter} from 'vue-router'

export default {
  props: {
    title: {
      type: String,
      default: '标题'
    },

    back: {
      type: String,
      default: ''
    },

  },
  emits: ['callback'],
  setup(props, context) {


    console.log(
        props, context
    )
    const router = useRouter()
    const goBack = () => {
      if (!props.back) {
        router.go(-1)
      } else {
        router.push({path: props.back})
      }
      context.emit('callback')
    }
    return {
      goBack,
    }
  }
}
</script>


<style scoped>

</style>