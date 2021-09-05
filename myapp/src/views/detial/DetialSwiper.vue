<template>
  <div>
    <div class="swiper-container" :class="swiperclass">
      <div class="swiper-wrapper">
        <slot></slot>
      </div>
    </div>

  </div>
</template>
<!-- 演职人员和剧照的轮播图公用组件 -->
<script>
import Swiper from 'swiper/bundle'
import 'swiper/swiper.scss'
export default {

  props: {
    perslide: {
      type: Number,
      default: 1
    },
    swiperclass: {
      type: String,
      default: 'swiper-container'

    }

  },
  data () {
    return {

    }
  },
  mounted () {
    // console.log(this.swiperclass)
    new Swiper('.' + this.swiperclass, {
      slidesPerView: this.perslide,
      spaceBetween: 10,
      freeMode: true

    })
  }
}
</script>

<style lang="scss" scoped="scoped">

</style>
