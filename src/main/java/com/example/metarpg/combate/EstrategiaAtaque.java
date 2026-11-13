package com.example.metarpg.combate;
import com.example.metarpg.personajes.Personaje;

public interface EstrategiaAtaque {
    ResultadoAtaque atacar(Personaje atacante, Personaje objetivo);
}
