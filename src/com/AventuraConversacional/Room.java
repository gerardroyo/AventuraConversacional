package com.AventuraConversacional;

public class Room {
    private int id = 0;
    private String nom = "";
    private boolean escala = false;
    private boolean movConfirmat = false;
    private char portaNord = ' ';
    private char portaSud = ' ';
    private char portaEst = ' ';
    private char portaOest = ' ';
    private boolean portaOberta = true;
    Items []itemsList;
    NPC []NPCList;

    public void instanciarObjsItems() {
        Items espassa = new Items("Espassa",false,"És una arma màgica que pots usar contra perills imminents i que hauràs d'usar per matar a en JordiJor");
        Items escala = new Items("Escala de Ma", false, "És una escala de mà que pot ajudar-te a aconseguir els objectes que no estiguin a la teva alçada");
        Items clauPrivada = new Items("Clau Privada", false, "És la clau que obre l'habitació dan JordiJor");
        Items clauUniversal = new Items("Clau Universal", false, "És la clau que et permet obrir les portes tancades (menys la dan JordiJor)");
        Items diners = new Items("Bossa de diners", false, "Bossa de diners, potser hi ha algú disposat a intercanviar aquests diners per coses valuoses...");
    }

    public Room() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isEscala() {
        return escala;
    }

    public boolean isMovConfirmat() {
        return movConfirmat;
    }
}
