package com.example.metarpg.personajes;
public class AmuletoRegeneracionDecorador extends PersonajeDecorador {
    public AmuletoRegeneracionDecorador(Personaje p){super(p);} public int getDefensa(){return personaje.getDefensa()+3;}
    public int regeneracionPorTurno(){return personaje.regeneracionPorTurno()+2;}
    public String getDescripcion(){return personaje.getDescripcion()+" + Amuleto de regeneración";}
}
