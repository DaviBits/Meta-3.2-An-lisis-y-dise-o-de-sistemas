package com.example.metarpg.personajes;
import com.example.metarpg.combate.EstrategiaAtaque;
import com.example.metarpg.combate.ResultadoAtaque;

public interface Personaje {
    String getNombre(); int getAtaque(); int getDefensa(); int getVelocidad(); int getHp(); int getHpMaximo();
    void setHp(int hp); EstrategiaAtaque getEstrategia(); void setEstrategia(EstrategiaAtaque estrategia);
    ResultadoAtaque atacar(Personaje objetivo); String getDescripcion();
    default void recibirDano(int dano) { setHp(Math.max(0, getHp() - Math.max(0, dano))); }
    default void curar(int cantidad) { setHp(Math.min(getHpMaximo(), getHp() + Math.max(0, cantidad))); }
    default int regeneracionPorTurno() { return 0; }
    default int danoVenenoPorTurno() { return 0; }
}
