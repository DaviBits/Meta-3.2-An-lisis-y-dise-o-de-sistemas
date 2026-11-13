package com.example.metarpg.combate;

public final class ResultadoAtaque {
    private final int dano;
    private final boolean critico;
    private final String efecto;

    public ResultadoAtaque(int dano, boolean critico, String efecto) {
        this.dano = Math.max(0, dano);
        this.critico = critico;
        this.efecto = efecto == null ? "" : efecto;
    }
    public int getDano() { return dano; }
    public boolean isCritico() { return critico; }
    public String getEfecto() { return efecto; }
}
