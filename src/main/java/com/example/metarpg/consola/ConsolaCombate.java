package com.example.metarpg.consola;
import com.example.metarpg.personajes.Personaje;
import com.example.metarpg.combate.AccionCombate;
import com.example.metarpg.combate.ObservadorCombate;
import com.example.metarpg.combate.SelectorAccion;

import java.util.Scanner;

public class ConsolaCombate implements SelectorAccion, ObservadorCombate {
    private final Scanner entrada;
    public ConsolaCombate(Scanner entrada){this.entrada=entrada;}
    public AccionCombate seleccionarAccion(Personaje heroe,int pociones){
        System.out.println("Acción: 1) Atacar  2) Defender  3) Usar poción ("+pociones+")");
        int opcion=leerEntero("Elige: ",1,3);
        return opcion==2?AccionCombate.DEFENDER:opcion==3?AccionCombate.POCION:AccionCombate.ATACAR;
    }
    public void registrar(String mensaje){System.out.println(mensaje);}
    public void mostrarEstado(Personaje heroe,Personaje enemigo,int turno){
        System.out.println("Estado | "+heroe.getDescripcion()+" HP "+heroe.getHp()+"/"+heroe.getHpMaximo()+" ATK "+heroe.getAtaque()+" DEF "+heroe.getDefensa()+" VEL "+heroe.getVelocidad()+" || "+enemigo.getDescripcion()+" HP "+enemigo.getHp()+"/"+enemigo.getHpMaximo());
    }
    public String leerTexto(String mensaje){System.out.print(mensaje);while(entrada.hasNextLine()){String s=entrada.nextLine().trim();if(!s.isEmpty())return s;System.out.print("No puede quedar vacío. "+mensaje);}throw new IllegalStateException("Se cerró la entrada.");}
    public int leerEntero(String mensaje,int min,int max){while(true){System.out.print(mensaje);if(!entrada.hasNextLine())throw new IllegalStateException("Se cerró la entrada.");try{int n=Integer.parseInt(entrada.nextLine().trim());if(n>=min&&n<=max)return n;}catch(NumberFormatException ignored){}System.out.println("Ingresa un número entre "+min+" y "+max+".");}}
}
