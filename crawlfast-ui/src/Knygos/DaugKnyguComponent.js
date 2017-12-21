import React from 'react';
import KnygosComponent from './KnygosComponent';

var DaugKnyguComponent =(props)=>{
    var visosKnygos = props.visosKnygos;
    if (visosKnygos.length===0){
        return <div></div>
    } else {
        var piesiamosKnygos = visosKnygos.map((knyga)=>{
            return <KnygosComponent key={knyga.name} vienaKnyga={knyga}/>
        })
        return <div>{piesiamosKnygos}</div>
    }
}

export default DaugKnyguComponent;