package com.example.metarpg.personajes;
public class BendicionDecorador extends PersonajeDecorador {
    public BendicionDecorador(Personaje p){super(p);} public int getAtaque(){return (int)Math.round(personaje.getAtaque()*1.15);}
    public int getDefensa(){return (int)Math.round(personaje.getDefensa()*1.15);}
    public int getVelocidad(){return (int)Math.round(personaje.getVelocidad()*1.15);}
    public String getDescripcion(){return personaje.getDescripcion()+" + Bendición";}
}
