import React from "react";
import Grid from "../Grid";
import { FormControl,InputLabel,FormHelperText,Input } from '@material-ui/core';

class Controller extends React.Component {

    constructor(props) {
        super(props);
        this.state = {name: props.name};
    }
    render() {
        return (<Grid>
            <p>
                 <code>Hello {this.state.name} .</code>
            </p>
        </Grid>);
    }
}
export default Controller