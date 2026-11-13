package com.example.metarpg.fabricas;
import com.example.metarpg.personajes.Personaje;
import com.example.metarpg.personajes.PersonajeBase;
import com.example.metarpg.combate.AtaquePuñalada;
public class CreadorGoblin extends CreadorEnemigo { public Personaje crearEnemigo(){return new PersonajeBase("Goblin salvaje",60,14,5,12,new AtaquePuñalada());} }
