import React,{Component} from 'react'
import HeaderContainer from "./HeaderContainer"
import MainContainer from "./MainContainer"
import FooterContainer from "./FooterContainer"

export default class AppRoot extends  Component {
    render(){
        return (
            <div>
                <h1>Hello React</h1>
                <hr/>
                <HeaderContainer />
                <hr/>
                <MainContainer />
                <hr/>
                <FooterContainer />
            </div>
        )
    }
}
