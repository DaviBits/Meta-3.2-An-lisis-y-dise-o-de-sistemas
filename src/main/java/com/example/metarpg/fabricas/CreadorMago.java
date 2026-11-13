package com.example.metarpg.fabricas;
import com.example.metarpg.personajes.Personaje;
import com.example.metarpg.personajes.PersonajeMago;
public class CreadorMago extends CreadorPersonaje { public Personaje crearPersonaje(String n){validarNombre(n);return new PersonajeMago(n);} }
