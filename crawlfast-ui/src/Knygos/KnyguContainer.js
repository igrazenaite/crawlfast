import React, {Component} from 'react';
import DaugKnyguComponent from './DaugKnyguComponent';
import axios from 'axios';

class KnyguContainer extends Component{
    constructor() {
        super();

        this.state = {
            knygos: []
        }
    }

    componentWillMount(){
        axios
            .get("http://localhost:8082/rest/institucija/knyga")
            .then((responce) => {
                console.log(responce);
                this.setState({knygos: responce.data});
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render (){
        return <DaugKnyguComponent visosKnygos={this.state.knygos}/>
    }
}
/* var BackToMainNavigation =(props)=>{
    var goApp = () => props.router.push("/");
    return (
      <div>
          At route: {props.router.getCurrentLocation().pathname}
          <button onClick={goApp}>Back to Main Page</button>
          <pre>
              {JSON.stringify(props, null, 2)}
          </pre>
        </div>
    );
  }; */
export default KnyguContainer;