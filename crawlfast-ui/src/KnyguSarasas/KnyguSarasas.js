import React, {Component} from 'react';
import VienosKnygosComponent from '../KnygosKortele/VienosKnygosComponent';
import picture from '../book.jpg';
import axios from 'axios';

class KnyguSarasoComponent extends Component{
    constructor(props){
        super(props);
        var knyguSarasas= [{
            pavadinimas: 'Ten', 
            autorius: 'Me',
            imageURL: picture, 
            puslapiusk: '10', 
            kaina: '10.0', 
            bukle: 'yra',
            kiekis: '2'
            },
           {
            pavadinimas: 'Twenty', 
            autorius: 'Me',
            imageURL: picture, 
            puslapiusk: '20', 
            kaina: '20.0', 
            bukle: 'suplysusi',
            kiekis: '3'
          },
           {
            pavadinimas: 'Cia', 
            autorius: 'Someone else',
            imageURL: picture, 
            puslapiusk: '11', 
            kaina: '12.0', 
            bukle: 'yra',
            kiekis: '2'
          },
           {
            pavadinimas: 'Kur?', 
            autorius: 'Me',
            imageURL: picture, 
            puslapiusk: '15', 
            kaina: '200.0', 
            bukle: 'neber',
            kiekis: '0'
          }]
        this.state={
            knygos: knyguSarasas
        }
    }
    //goProducts = () => this.props.router.push("knygos");
  
    componentWillMount(){
        axios.get('localhost:3000/#/institucija/knyga')
        .then((responce)=>{
            this.setState({knygos: responce.data})
        })
        .catch((error)=>{
            console.log(error);
        });
    }

    render(){
        console.log(this.props);
        return(
            <div>
                <div className="container">
                    <div className="row1">
                        <div className="col-sm-4 col-md-4">
                            <VienosKnygosComponent knyga={this.state.knygos[0]}/>
                        </div>
                        <div className="col-sm-4 col-md-4">
                            <VienosKnygosComponent knyga={this.state.knygos[1]}/>
                        </div>
                        <div className="col-sm-4 col-md-4">
                            <VienosKnygosComponent knyga={this.state.knygos[2]}/>
                        </div>
                    </div>
                </div>
                <div className="container">
                    <div className="row1">
                        <div className="col-sm-4 col-md-4">
                            <VienosKnygosComponent knyga={this.state.knygos[3]}/>
                        </div>
                    </div>
                </div>
                {/* <p><button onClick={this.goProducts}
                    className="btn btn-primary"
                    role="button">
                    Go to products</button></p> */}
            </div>
        );
    }
};

export default KnyguSarasoComponent;