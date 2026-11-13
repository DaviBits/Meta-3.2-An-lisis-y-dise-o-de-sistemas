package com.example.metarpg.fabricas;
import com.example.metarpg.personajes.Personaje;
import com.example.metarpg.personajes.PersonajePicaro;
public class CreadorPicaro extends CreadorPersonaje { public Personaje crearPersonaje(String n){validarNombre(n);return new PersonajePicaro(n);} }
