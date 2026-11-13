package com.example.metarpg.combate;
import com.example.metarpg.personajes.Personaje;
import java.util.concurrent.ThreadLocalRandom;
public class AtaqueEspada implements EstrategiaAtaque {
    public ResultadoAtaque atacar(Personaje a, Personaje o) {
        boolean crit = ThreadLocalRandom.current().nextInt(100) < 15;
        int dano = Math.max(1, a.getAtaque() - o.getDefensa());
        return new ResultadoAtaque(crit ? dano * 2 : dano, crit, "espada");
    }
}
