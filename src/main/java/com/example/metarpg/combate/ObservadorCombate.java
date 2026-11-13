package com.example.metarpg.combate;
import com.example.metarpg.personajes.Personaje;
public interface ObservadorCombate { void registrar(String mensaje); void mostrarEstado(Personaje heroe, Personaje enemigo, int turno); }
