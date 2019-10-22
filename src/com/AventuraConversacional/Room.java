package com.AventuraConversacional;

public class Room {
    private String nom = "";
    private String descripcio = "";
    private boolean escalaAqui = false;
    private boolean movConfirmat = false;
    private boolean portaNord = false;
    private boolean portaSud = false;
    private boolean portaEst = false;
    private boolean portaOest = false;
    private boolean portaOberta = true;

    public String getNom() { return nom; }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() { return descripcio; }

    public void setDescripcio(String descripcio) { this.descripcio = descripcio; }

    public boolean isEscalaAqui() {
        return escalaAqui;
    }

    public boolean isMovConfirmat() {
        return movConfirmat;
    }

    public boolean getPortaNord() {
        return portaNord;
    }

    public void setPortaNord(boolean portaNord) {
        this.portaNord = portaNord;
    }

    public boolean getPortaSud() {
        return portaSud;
    }

    public void setPortaSud(boolean portaSud) {
        this.portaSud = portaSud;
    }

    public boolean getPortaEst() {
        return portaEst;
    }

    public void setPortaEst(boolean portaEst) {
        this.portaEst = portaEst;
    }

    public boolean getPortaOest() {
        return portaOest;
    }

    public void setPortaOest(boolean portaOest) {
        this.portaOest = portaOest;
    }

    public boolean getEscalaAqui() { return escalaAqui; }

    public void setEscalaAqui(boolean escalaAqui) {
        this.escalaAqui = escalaAqui;
    }
}
