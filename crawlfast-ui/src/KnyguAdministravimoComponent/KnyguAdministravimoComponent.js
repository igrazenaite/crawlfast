import React, {Component} from 'react';
import axios from 'axios';

class KnyguAdministravimoComponent extends Component{
    constructor(props){
        super(props);
        console.log(props);
        this.state={
            pavadinimas : '',
            autorius: '',
            paveiksliukas: '',
            puslapiusk: '',
            kaina: '',
            bukle:'',
            kiekis: ''};

    }

    componentWillMount(){
        axios.get('localhost:3000/#/admin/knygos/nauja')
        .then((responce)=>{
            this.setState({knygos: responce.data})
        })
        .catch((error)=>{
            console.log(error);
        });
    }

    handleSubmit = (event)=> {
        console.log(this.state);
        event.preventDefault();
    }
    
    updatePavadinimas = (event) => {
        this.setState({pavadinimas: event.target.value});
    }

    updateAutorius = (event) => {
        this.setState({autorius: event.target.value});
    }

    updatePuslapiuSk = (event) => {
        this.setState({puslapiusk: event.target.value});
    }

    updatePaveiksliukas = (event) => {
        this.setState({paveiksliukas: event.target.value});
    }

    updateKaina = (event) => {
        this.setState({kaina: event.target.value});
    }

    updateBukle = (event) => {
        this.setState({bukle: event.target.value});
    }

    updateKiekis = (event) => {
        this.setState({kiekis: event.target.value});
    }

    render(){
        return(
            <form onSubmit={this.handleSubmit}>
                <div className="form-group">
                    <label htmlFor="pavadinimas">Pavadinimas: </label>
                    <input type="text" value={this.state.pavadinimas} onChange={this.updatePavadinimas}/>
                </div><br/>
                <div className="form-group">
                    <label htmlFor="autorius">Autorius: </label>
                    <input type="text"  value={this.state.autorius} onChange={this.updateAutorius}/>
                </div><br/>
                <div className="form-group">
                    <label htmlFor="puslapiusk">Puslpių skaičius: </label>
                    <input type="text" value={this.state.puslapiusk} onChange={this.updatePuslapiuSk}/>
                </div><br/> 
                <div className="form-group">
                    <label htmlFor="paveiksliukas">Įkelkite paveiksliuką: </label>
                    <input type="file" id="paveiksliukas" value={this.state.paveiksliukas} onChange={this.updatePaveiksliukas}/>
                </div><br/>
                <div className="form-group">
                    <label htmlFor="kaina">Kaina: </label>
                    <input type="text" value={this.state.kaina} onChange={this.updateKaina} />
                </div><br/>   
                <div className="form-group">
                    <label htmlFor="bukle">Knygos būklė: </label>
                    <input type="text" value={this.state.bukle} onChange={this.updateBukle} />
                </div><br/>   
                <div className="form-group">
                    <label htmlFor="kiekis">Kiekis: </label>
                    <input type="text" value={this.state.kiekis} onChange={this.updateKiekis} />
                    </div><br/>   
                <br/>
                <button type="save" className="btn btn-default" onClick={this.handleSubmit}>Išsaugoti</button>
            </form>); 
        } 
        
    }

export default KnyguAdministravimoComponent;