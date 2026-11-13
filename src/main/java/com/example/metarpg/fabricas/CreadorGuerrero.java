package com.example.metarpg.fabricas;
import com.example.metarpg.personajes.Personaje;
import com.example.metarpg.personajes.PersonajeGuerrero;
public class CreadorGuerrero extends CreadorPersonaje { public Personaje crearPersonaje(String n){validarNombre(n);return new PersonajeGuerrero(n);} }
