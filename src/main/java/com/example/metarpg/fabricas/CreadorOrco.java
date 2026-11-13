package com.example.metarpg.fabricas;
import com.example.metarpg.personajes.Personaje;
import com.example.metarpg.personajes.PersonajeBase;
import com.example.metarpg.combate.AtaqueEspada;
public class CreadorOrco extends CreadorEnemigo { public Personaje crearEnemigo(){return new PersonajeBase("Orco",90,19,8,7,new AtaqueEspada());} }
