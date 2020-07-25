import React from 'react';
import { Link } from "react-router-dom";
import clsx from 'clsx';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import Button from '@material-ui/core/Button';
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import Grid from '../Grid';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import MailIcon from '@material-ui/icons/Mail';
import InputIcon from '@material-ui/icons/Input';
import AccessTimeIcon from '@material-ui/icons/AccessTime';

const useStyles = makeStyles({
    list: {
        width: 250,
    },
    fullList: {
        width: 'auto',
    },
});

export default function Menu(props) {
    const classes = useStyles();
    const page= props.page;
    const [state, setState] = React.useState({
        top: false,
        left: false,
        right: false,
        page:props.page
    });
    const sousMenu=['Input', 'Output'];
    switch (page) {
        case 'Utilisateur':
            console.log('Oranges are $0.59 a pound.');
            sousMenu=['InputUser', 'outputUser']
            break;
        case 'Menu':
            //configuration du plateau
            sousMenu=['InputMenu', 'outputMenu'];
            break;
        case 'Administrateur':
            sousMenu=['InputMenu', 'outputMenu']
            break;
        default:
            console.log(`Welcome to the Platform`);
    }

    const toggleDrawer = (anchor, open) => (event) => {
        if (event.type === 'keydown' && (event.key === 'Tab' || event.key === 'Shift')) {
            return;
        }

        setState({ ...state, [anchor]: open });
    };

    const list = (anchor,page) => (
        <div
            className={clsx(classes.list, {
                [classes.fullList]: anchor === 'top',
            })}
            role="presentation"
            onClick={toggleDrawer(anchor, false)}
            onKeyDown={toggleDrawer(anchor, false)}
        >
            <List>
                {sousMenu.map((text, index) => (
                    <ListItem button key={text} component={Link} to={"/"+page}>
                        <ListItemIcon>{index % 2 === 0 ? <InputIcon /> : <AccessTimeIcon />}</ListItemIcon>
                        <ListItemText primary={text} />
                    </ListItem>
                ))}
            </List>
        </div>
    );

    return (
        <Grid >
            {[{x:'left',y:'Utilisateur'}, {x:'Top',y:"Menu"}, {x:'right',y:'Administrateur'}].map((anchor) => (
                <React.Fragment key={anchor.x}>
                    <Button onClick={toggleDrawer(anchor.x, true)} >{anchor.y}</Button>
                    <Drawer anchor={anchor.x} open={state[anchor.x]} onClose={toggleDrawer(anchor.x, false)}>
                        {list(anchor.x,anchor.y)}
                    </Drawer>
                </React.Fragment>
            ))}
        </Grid>
    );
}