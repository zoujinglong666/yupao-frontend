import {createApp} from 'vue'
import App from './App.vue'
import Vant from 'vant';
import 'vant/lib/index.css';
/**
 * 时间格式化过滤器
 */

import dayjs from "dayjs"



import { Toast } from 'vant';
const app = createApp(App)
app.use(Vant)
app.use(Toast);
// @ts-ignore
createApp().config.globalProperties.$dayjs = dayjs; //全局使用dayjs
app.mount('#app')


