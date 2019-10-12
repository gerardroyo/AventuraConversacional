package com.AventuraConversacional;

public class Player {
    private String nom = "CarloBon";
    private String onEstic;
    private boolean viu = true;
    private char moviment = ' ';

    public Player() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getOnEstic() {
        return onEstic;
    }

    public void setOnEstic(String onEstic) {
        this.onEstic = onEstic;
    }

    public boolean isViu() {
        return viu;
    }

    public void setViu(boolean viu) {
        this.viu = viu;
    }

    public char getMoviment() {
        return moviment;
    }

    public void setMoviment(char moviment) {
        this.moviment = moviment;
    }

}
