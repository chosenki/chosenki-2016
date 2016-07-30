const demo = (state = [],action) => {
    switch (action.type){
        case 'TODO_FIRST':
            return {

            }
        default:
            return state
    }

}

export default demo
