package com.example.metarpg.personajes;
public class EspadaDecorador extends PersonajeDecorador {
    public EspadaDecorador(Personaje p){super(p);} public int getAtaque(){return personaje.getAtaque()+10;}
    public String getDescripcion(){return personaje.getDescripcion()+" + Espada";}
}
