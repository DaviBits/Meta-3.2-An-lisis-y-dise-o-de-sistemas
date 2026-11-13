package com.example.metarpg.combate;
import com.example.metarpg.personajes.Personaje;

public class MotorCombate {
    private final SelectorAccion selector;
    private final ObservadorCombate observador;
    private final int pocionesIniciales;
    public MotorCombate(SelectorAccion selector, ObservadorCombate observador) { this(selector, observador, 2); }
    public MotorCombate(SelectorAccion selector, ObservadorCombate observador, int pociones) {
        if(selector==null||observador==null)throw new IllegalArgumentException("Selector y bitácora son obligatorios.");
        this.selector=selector;this.observador=observador;this.pocionesIniciales=Math.max(0,pociones);
    }
    public Personaje iniciarCombate(Personaje heroe, Personaje enemigo) {
        int turno=1, pociones=pocionesIniciales; boolean defenderse=false;
        observador.registrar("=== COMBATE INICIADO ===");
        while(heroe.getHp()>0&&enemigo.getHp()>0){
            observador.registrar("--- TURNO "+turno+" ---");observador.mostrarEstado(heroe,enemigo,turno);
            AccionCombate accion=selector.seleccionarAccion(heroe,pociones);
            if(accion==AccionCombate.DEFENDER){defenderse=true;observador.registrar(heroe.getDescripcion()+" se prepara para defender.");}
            else if(accion==AccionCombate.POCION&&pociones>0){int antes=heroe.getHp();heroe.curar(30);pociones--;observador.registrar("Poción: HP "+antes+" -> "+heroe.getHp()+" (quedan "+pociones+")");}
            else {if(accion==AccionCombate.POCION)observador.registrar("No quedan pociones; el héroe ataca.");ejecutarAtaque(heroe,enemigo);}
            aplicarEfectos(heroe,enemigo);
            if(enemigo.getHp()>0){ejecutarAtaque(enemigo,heroe,defenderse);aplicarEfectos(enemigo,heroe);}
            defenderse=false;turno++;
        }
        Personaje ganador=heroe.getHp()>0?heroe:enemigo;
        observador.registrar("=== COMBATE FINALIZADO ===");
        observador.registrar("Ganador: "+ganador.getDescripcion()+" (HP restante: "+ganador.getHp()+")");
        return ganador;
    }
    private void ejecutarAtaque(Personaje atacante,Personaje defensor){ejecutarAtaque(atacante,defensor,false);}
    private void ejecutarAtaque(Personaje atacante,Personaje defensor,boolean defendiendo){
        ResultadoAtaque r=atacante.atacar(defensor);int dano=defendiendo?Math.max(1,(r.getDano()+1)/2):r.getDano();
        int antes=defensor.getHp();defensor.recibirDano(dano);
        observador.registrar(atacante.getDescripcion()+" usa "+atacante.getEstrategia().getClass().getSimpleName()+" sobre "+defensor.getNombre());
        observador.registrar("  Daño: "+dano+(r.isCritico()?" | ¡CRÍTICO!":"")+" | Efecto: "+r.getEfecto());
        observador.registrar("  "+defensor.getNombre()+" HP: "+antes+" -> "+defensor.getHp()+(defendiendo?" (defensa)":""));
    }
    private void aplicarEfectos(Personaje fuente,Personaje objetivo){
        if(fuente.danoVenenoPorTurno()>0&&objetivo.getHp()>0){objetivo.recibirDano(fuente.danoVenenoPorTurno());observador.registrar("Veneno: "+objetivo.getNombre()+" recibe "+fuente.danoVenenoPorTurno()+" de daño.");}
        if(fuente.regeneracionPorTurno()>0&&fuente.getHp()>0){int antes=fuente.getHp();fuente.curar(fuente.regeneracionPorTurno());if(fuente.getHp()>antes)observador.registrar("Regeneración: "+fuente.getNombre()+" recupera "+(fuente.getHp()-antes)+" HP.");}
    }
}
