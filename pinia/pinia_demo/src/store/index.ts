import {defineStore} from 'pinia'
import {computed, reactive, ref} from "vue";

// useStore 可以是 useUser、useCart 之类的任何东西
// 第一个参数是应用程序中 store 的唯一 id
export type Item = {

    // 类型大小写一样
    // id:number,
    // context:string
    id: Number,
    context: String
}
export const useTodoStore = defineStore('todo', () => {

    let id = 1;
    // 自增id
    const selfIncreasingID = () => id++
    const newItem = ref("");
    //类型Item
    const todoItems = reactive<Item[]>([]);
    //vuex  里面的getter
    const getTodoItemCount = computed(() => {
        return todoItems.length
    })
//如果函数异步调用的话直接在函数添加async
    async function addItem() {
        if (!newItem.value) {
            return
        }
        todoItems.push({
            id: selfIncreasingID(),
            context: newItem.value
        })
        newItem.value = '';
    }

    //这里传参也需要类型支持,需要todoItem文件一致
    const removeItem = (item: Item) => {
        const index = todoItems.indexOf(item)
        todoItems.splice(index, 1)

    }
    return {
        newItem,
        todoItems, addItem,
        removeItem,
        getTodoItemCount
    }
})