import { createRouter, createWebHashHistory } from "vue-router";
import Film from "../views/Film.vue";
import Center from "../views/Center.vue";
import Cinema from "../views/Cinema.vue";

const routes = [
  {
    path: "/film",
    component: Film
  },
  {
    path: "/cinema",
    component: Cinema
  },
  {
    path: "/center",
    component: Center
  },
  {
    path: "/",
    component: Center
  }
];

const router = createRouter({
  history: createWebHashHistory(), //默认
  routes
});
// router.beforeEach((to,from,next)=>{
//   console.log('拦截')
// })



export default router;
