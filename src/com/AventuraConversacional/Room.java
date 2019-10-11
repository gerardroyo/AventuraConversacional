package com.AventuraConversacional;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Room {
    private String nom = "";
    private boolean escalaAqui = false;
    private boolean movConfirmat = false;
    private boolean portaNord = false;
    private boolean portaSud = false;
    private boolean portaEst = false;
    private boolean portaOest = false;
    private boolean portaOberta = true;
    Items []itemsList;
    NPC []NPCList;

    /*Items espassa = new Items("Espassa",false,"És una arma màgica que pots usar contra perills imminents i que hauràs d'usar per matar a en JordiJor");
    Items escala = new Items("Escala de Ma", false, "És una escala de mà que pot ajudar-te a aconseguir els objectes que no estiguin a la teva alçada");
    Items clauPrivada = new Items("Clau Privada", false, "És la clau que obre l'habitació dan JordiJor");
    Items clauUniversal = new Items("Clau Universal", false, "És la clau que et permet obrir les portes tancades (menys la dan JordiJor)");
    Items diners = new Items("Bossa de diners", false, "Bossa de diners, potser hi ha algú disposat a intercanviar aquests diners per coses valuoses...");*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Items[] getItemsList() {
        return itemsList;
    }

    public void setItemsList(Items[] itemsList) {
        this.itemsList = itemsList;
    }

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

    public void setEscalaAqui(boolean escalaAqui) {
        this.escalaAqui = escalaAqui;
    }
}
