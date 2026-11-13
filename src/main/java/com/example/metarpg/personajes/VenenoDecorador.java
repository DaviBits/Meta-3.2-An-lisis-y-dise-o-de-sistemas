package com.example.metarpg.personajes;
import com.example.metarpg.combate.ResultadoAtaque;
public class VenenoDecorador extends PersonajeDecorador {
    public VenenoDecorador(Personaje p){super(p);} public int getAtaque(){return personaje.getAtaque()+5;}
    public int danoVenenoPorTurno(){return personaje.danoVenenoPorTurno()+5;}
    public ResultadoAtaque atacar(Personaje objetivo){ResultadoAtaque r=personaje.atacar(objetivo);return new ResultadoAtaque(r.getDano()+5,r.isCritico(),r.getEfecto()+" + veneno");}
    public String getDescripcion(){return personaje.getDescripcion()+" + Veneno";}
}
