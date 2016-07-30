import { combineReducers } from "redux"
import todo from "./todo"
import filter from "./filter"

const todoApp = combineReducers({
    todo,filter
})

export default todoApp
