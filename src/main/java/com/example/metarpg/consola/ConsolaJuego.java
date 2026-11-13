package com.example.metarpg.consola;
import com.example.metarpg.personajes.Personaje;
import com.example.metarpg.personajes.EspadaDecorador;
import com.example.metarpg.personajes.ArmaduraDecorador;
import com.example.metarpg.personajes.VenenoDecorador;
import com.example.metarpg.personajes.AmuletoRegeneracionDecorador;
import com.example.metarpg.personajes.BendicionDecorador;
import com.example.metarpg.fabricas.CreadorPersonaje;
import com.example.metarpg.fabricas.CreadorGuerrero;
import com.example.metarpg.fabricas.CreadorMago;
import com.example.metarpg.fabricas.CreadorArquero;
import com.example.metarpg.fabricas.CreadorPicaro;
import com.example.metarpg.fabricas.CreadorEnemigo;
import com.example.metarpg.fabricas.CreadorGoblin;
import com.example.metarpg.fabricas.CreadorOrco;
import com.example.metarpg.fabricas.CreadorDragon;
import com.example.metarpg.combate.MotorCombate;

import java.util.Scanner;

public class ConsolaJuego {
    private final ConsolaCombate consola;
    public ConsolaJuego(Scanner entrada){this.consola=new ConsolaCombate(entrada);}
    public void iniciar(){
        System.out.println("==================================\n       META RPG - CONSOLA\n==================================");
        boolean jugar=true;
        while(jugar){
            String nombre=consola.leerTexto("Nombre del héroe: ");
            CreadorPersonaje creador=seleccionarCreador();Personaje heroe=creador.crearPersonaje(nombre);
            heroe=seleccionarEquipo(heroe);
            CreadorEnemigo enemigoCreador=seleccionarEnemigo();Personaje enemigo=enemigoCreador.crearEnemigo();
            System.out.println("\nHéroe: "+heroe.getDescripcion());
            System.out.println("ATK: "+heroe.getAtaque()+" | DEF: "+heroe.getDefensa()+" | VEL: "+heroe.getVelocidad()+" | HP: "+heroe.getHp());
            System.out.println("Enemigo: "+enemigo.getNombre()+" | HP: "+enemigo.getHp()+"\n");
            new MotorCombate(consola,consola).iniciarCombate(heroe,enemigo);
            jugar=consola.leerEntero("¿Jugar otra partida? 1) Sí  2) No: ",1,2)==1;
        }
        System.out.println("Gracias por jugar.");
    }
    private CreadorPersonaje seleccionarCreador(){
        System.out.println("Clase: 1) Guerrero  2) Mago  3) Arquero  4) Pícaro");
        switch(consola.leerEntero("Elige: ",1,4)){case 1:return new CreadorGuerrero();case 2:return new CreadorMago();case 3:return new CreadorArquero();default:return new CreadorPicaro();}
    }
    private Personaje seleccionarEquipo(Personaje p){
        System.out.println("Equipo (separa los números con coma; 0 para terminar):");
        System.out.println("1) Espada (+10 ATK)  2) Armadura (+8 DEF)  3) Veneno (+5 daño y DOT)  4) Amuleto (+3 DEF, +2 HP/turno)  5) Bendición (+15% atributos)");
        boolean[] usado=new boolean[6];
        while(true){int opcion=consola.leerEntero("Añadir objeto: ",0,5);if(opcion==0)break;if(usado[opcion]){System.out.println("Ese objeto ya está equipado.");continue;}usado[opcion]=true;
            switch(opcion){case 1:p=new EspadaDecorador(p);break;case 2:p=new ArmaduraDecorador(p);break;case 3:p=new VenenoDecorador(p);break;case 4:p=new AmuletoRegeneracionDecorador(p);break;case 5:p=new BendicionDecorador(p);break;default:break;}}
        return p;
    }
    private CreadorEnemigo seleccionarEnemigo(){
        System.out.println("Enemigo: 1) Goblin  2) Orco  3) Dragón");
        switch(consola.leerEntero("Elige: ",1,3)){case 2:return new CreadorOrco();case 3:return new CreadorDragon();default:return new CreadorGoblin();}
    }
}
