package com.example.metarpg.personajes;
import com.example.metarpg.combate.EstrategiaAtaque;
import com.example.metarpg.combate.ResultadoAtaque;

public class PersonajeBase implements Personaje {
    private final String nombre; private final int ataque, defensa, velocidad, hpMaximo;
    private int hp; private EstrategiaAtaque estrategia;
    public PersonajeBase(String nombre, int hp, int ataque, int defensa, int velocidad, EstrategiaAtaque estrategia) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacío.");
        this.nombre = nombre.trim(); this.hpMaximo = Math.max(1, hp); this.hp = this.hpMaximo;
        this.ataque = ataque; this.defensa = defensa; this.velocidad = velocidad; setEstrategia(estrategia);
    }
    public String getNombre(){return nombre;} public int getAtaque(){return ataque;} public int getDefensa(){return defensa;}
    public int getVelocidad(){return velocidad;} public int getHp(){return hp;} public int getHpMaximo(){return hpMaximo;}
    public void setHp(int hp){this.hp=Math.max(0,Math.min(hpMaximo,hp));}
    public EstrategiaAtaque getEstrategia(){return estrategia;}
    public void setEstrategia(EstrategiaAtaque estrategia){if(estrategia==null)throw new IllegalArgumentException("La estrategia es obligatoria.");this.estrategia=estrategia;}
    public ResultadoAtaque atacar(Personaje objetivo){return estrategia.atacar(this,objetivo);}
    public String getDescripcion(){return nombre+" (base)";}
}
