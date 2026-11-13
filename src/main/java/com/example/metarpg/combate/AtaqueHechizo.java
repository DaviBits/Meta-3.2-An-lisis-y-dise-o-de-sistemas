package com.example.metarpg.combate;
import com.example.metarpg.personajes.Personaje;
import java.util.concurrent.ThreadLocalRandom;
public class AtaqueHechizo implements EstrategiaAtaque {
    public ResultadoAtaque atacar(Personaje a, Personaje o) {
        boolean crit = ThreadLocalRandom.current().nextInt(100) < 20;
        int dano = Math.max(1, a.getAtaque() + 5 - o.getDefensa() / 2);
        return new ResultadoAtaque(crit ? dano * 2 : dano, crit, "hechizo");
    }
}
