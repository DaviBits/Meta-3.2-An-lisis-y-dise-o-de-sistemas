package com.example.metarpg.combate;
import com.example.metarpg.personajes.Personaje;
import java.util.concurrent.ThreadLocalRandom;
public class AtaqueFlecha implements EstrategiaAtaque {
    public ResultadoAtaque atacar(Personaje a, Personaje o) {
        boolean crit = ThreadLocalRandom.current().nextInt(100) < 25;
        int dano = Math.max(1, a.getAtaque() + a.getVelocidad() / 3 - o.getDefensa());
        return new ResultadoAtaque(crit ? dano * 2 : dano, crit, "flecha precisa");
    }
}
