import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, IndexRoute, hashHistory} from 'react-router';
import './index.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import KnyguSarasoComponent from './KnyguSarasas/KnyguSarasas'
import KnyguAdministravimoComponent from './KnyguAdministravimoComponent/KnyguAdministravimoComponent';
import KnyguContainer from './Knygos/KnyguContainer';

var NoMatch = (props) =>{
  return <div>Puslapio nuoroda nerasta</div>;
}

var InitialApp=(props)=>{
  return <div>
  {props.children} </div>
}

ReactDOM.render((
<Router history={hashHistory}>
    <Route path="/" component={InitialApp}>
    <IndexRoute component={KnyguSarasoComponent}/>
    <Route path="/knygos" component={KnyguContainer}/>
    <Route path="/admin/knygos/:id" component={KnyguAdministravimoComponent}/>
    <Route path="/admin/knygos/nauja" component={KnyguAdministravimoComponent}/>
    <Route path="*" component={NoMatch}/>
    </Route>
  </Router>), 
  document.getElementById('root')
);

