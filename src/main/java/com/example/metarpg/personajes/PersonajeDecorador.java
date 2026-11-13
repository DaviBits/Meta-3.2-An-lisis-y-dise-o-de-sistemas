package com.example.metarpg.personajes;
import com.example.metarpg.combate.EstrategiaAtaque;
import com.example.metarpg.combate.ResultadoAtaque;
public abstract class PersonajeDecorador implements Personaje {
    protected final Personaje personaje;
    protected PersonajeDecorador(Personaje personaje){if(personaje==null)throw new IllegalArgumentException("Se requiere un personaje.");this.personaje=personaje;}
    public String getNombre(){return personaje.getNombre();} public int getAtaque(){return personaje.getAtaque();}
    public int getDefensa(){return personaje.getDefensa();} public int getVelocidad(){return personaje.getVelocidad();}
    public int getHp(){return personaje.getHp();} public int getHpMaximo(){return personaje.getHpMaximo();}
    public void setHp(int hp){personaje.setHp(hp);} public EstrategiaAtaque getEstrategia(){return personaje.getEstrategia();}
    public void setEstrategia(EstrategiaAtaque e){personaje.setEstrategia(e);}
    public ResultadoAtaque atacar(Personaje objetivo){return personaje.atacar(objetivo);}
    public int regeneracionPorTurno(){return personaje.regeneracionPorTurno();}
    public int danoVenenoPorTurno(){return personaje.danoVenenoPorTurno();}
    public String getDescripcion(){return personaje.getDescripcion();}
}
