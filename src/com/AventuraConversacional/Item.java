package com.AventuraConversacional;

public class Item {

    private String nom = "";
    private boolean usat = false;
    private String descripcio = "";
    private String onEstic = "";

    public Item() {
    }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public boolean isUsat() { return usat; }

    public void setUsat(boolean usat) { this.usat = usat; }

    public String getDescripcio() { return descripcio; }

    public void setDescripcio(String descripcio) { this.descripcio = descripcio; }

    public String getOnEstic() { return onEstic; }

    public void setOnEstic(String onEstic) { this.onEstic = onEstic; }
}
