import React from 'react';

var KnygosComponent = (props)=>{
    var knyga = props.vienaKnyga;
    return <span>{knyga.paveiksliukas}<br/>
                Pavadinimas: {knyga.pavadinimas}<br/>
                Autorius: {knyga.autorius}<br/>
                Puslapių skaičius: {knyga.puslapiusk}<br/>
                Kaina: {knyga.kaina} Eur<br/>
                Būklė: {knyga.bukle}<br/>
                Kiekis: {knyga.kiekis}<br/>
    </span>

}

export default KnygosComponent;