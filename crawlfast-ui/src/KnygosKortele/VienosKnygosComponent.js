import React, {Component} from 'react';
import picture from '../book.jpg';

class VienosKnygosComponent extends Component{
  /*constructor (props){
    super(props);
  }*/
    render(){
      return(
        <div className="row">
          <div className="col-sm-12 col-md-12">
            <div className="thumbnail">
              <img className="Image" 
                src={picture} 
                alt="Paveiksliuko nėra"/>
              <div className="caption">
                <h3>{this.props.knyga.pavadinimas}</h3>
                  <p>{this.props.knyga.autorius}$</p>
                  <p>Puslapių skaičius: {this.props.knyga.puslapiusk}</p>
                  <p>Kaina: {this.props.knyga.kaina}</p>
                  <p>Būklė: {this.props.knyga.bukle}</p>
                  <p>Kiekis: {this.props.knyga.kiekis}</p>
                  <p><a href="#" className="btn btn-primary" 
                        role="button">Pirkti</a></p>
                  <p><a href="#" className="btn btn-default" 
                        role="button">Grįžti atgal</a></p> 
              </div>
            </div>
          </div>
        </div>
        );
    }
  };

export default VienosKnygosComponent;