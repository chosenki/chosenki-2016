import "babel-polyfill"
import React from "react"
import { render } from "react-dom"
import { createStore,applyMiddleware } from "redux"
import { Provider } from "react-redux"
import logger from "redux-logger"
import thunk from "redux-thunk"
import AppRoot from "./containers/AppRoot"


const middleware = process.env.NODE_ENV === "production" ? [thunk] : [thunk,logger()]

render(
    <AppRoot />,
    document.getElementById("appROOT")
)