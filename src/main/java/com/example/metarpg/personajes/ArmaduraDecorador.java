package com.example.metarpg.personajes;
public class ArmaduraDecorador extends PersonajeDecorador {
    public ArmaduraDecorador(Personaje p){super(p);} public int getDefensa(){return personaje.getDefensa()+8;}
    public String getDescripcion(){return personaje.getDescripcion()+" + Armadura";}
}
