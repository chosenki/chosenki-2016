import "babel-polyfill"
import React from "react"
import { render } from "react-dom"
import { createStore,applyMiddleware } from "redux"
import { Provider } from "react-redux"
import logger from "redux-logger"
import thunk from "redux-thunk"
import todoApp from "./reducers"
import { getTodoList } from "./actions"
import AppRoot from "./containers/AppRoot"

const middleware = process.env.NODE_ENV === "production" ? [thunk] : [thunk,logger()]

let store = createStore(todoApp,applyMiddleware(...middleware))

store.dispatch(getTodoList())

render(
    <Provider store={store}>
        <AppRoot />
    </Provider>,
    document.getElementById("appROOT")
)