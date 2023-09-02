import Index from "../pages/Index.vue";
import Team from "../pages/Team.vue";
import User from "../pages/User.vue"
import Search from "../pages/Search.vue"
import UserEdit from "../pages/UserEdit.vue"
import SearchUserList from "../pages/SearchUserList.vue"
import Login from "@/pages/Login.vue";
import * as VueRouter from "vue-router"
import UserEditDetail from "@/pages/UserEditDetail.vue";
const routes = [
    {path: '/', component: Index},
    {path: '/team', component: Team},
    {path: '/user', component: User},
    {path: '/search', name: Search, component: Search},
    {path: '/user/edit', name: Search, component: UserEdit},
    {path: '/search/user/list', name: Search, component: SearchUserList},
    {path: '/login', name: Login, component: Login},
    {path: '/user/edit/detail', name: UserEditDetail, component: UserEditDetail},

]

const router = VueRouter.createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: VueRouter.createWebHashHistory(),
// @ts-ignore
    routes, // `routes: routes` 的缩写
})
export default router;