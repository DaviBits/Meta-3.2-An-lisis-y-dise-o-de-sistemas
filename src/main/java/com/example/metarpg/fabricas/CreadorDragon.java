package com.example.metarpg.fabricas;
import com.example.metarpg.personajes.Personaje;
import com.example.metarpg.personajes.PersonajeBase;
import com.example.metarpg.combate.AtaqueHechizo;
public class CreadorDragon extends CreadorEnemigo { public Personaje crearEnemigo(){return new PersonajeBase("Dragon",130,24,11,13,new AtaqueHechizo());} }
