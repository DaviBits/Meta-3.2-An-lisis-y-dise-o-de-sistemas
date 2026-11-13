package com.example.metarpg;

import com.example.metarpg.consola.ConsolaJuego;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/** Punto de entrada de Meta RPG en consola. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        configurarSalidaUtf8();
        new ConsolaJuego(new Scanner(System.in)).iniciar();
    }

    private static void configurarSalidaUtf8() {
        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException exception) {
            throw new IllegalStateException("No se pudo configurar UTF-8.", exception);
        }
    }
}
