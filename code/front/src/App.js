import React from 'react';
//import logo from './logo.svg';

import Controller from "./Component/Controller/Controller";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import Menu from './Component/Menu/Menu'
import './App.css';


function App() {
  return (
    <div className="App">

          <Router>
              <div>
                  {/*<nav>
                    <ul>
                        <li>
                            <Link to="/">Home</Link>
                        </li>
                        <li>
                            <Link to="/about">About</Link>
                        </li>
                        <li>
                            <Link to="/users">Users</Link>
                        </li>
                    </ul>
                </nav>*/}
                  <div className="center">
                      <Menu page="/Menu"/>
                  </div>


                  {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
                  <header className="App-header">
                  <Switch>
                      <Route path="/Utilisateur">
                          <Utilisateur />
                      </Route>
                      <Route path="/Administrateur">
                          <Administrateur />
                      </Route>
                      <Route path="/Menu">
                          <Controller name="ilyass" />
                      </Route>
                      <Route path="/">
                          <Home />
                      </Route>

                  </Switch>
                  </header>
              </div>
          </Router>

    </div>


  );
}

function Home() {
    return <h2>Home</h2>;
}

function Utilisateur() {
    return <h2>Utilisateur</h2>;
}

function Administrateur() {
    return <h2>Administrateur</h2>;
}
function espaceconnecte() {
    return <h2>Administrateur</h2>;
}

export default App;
