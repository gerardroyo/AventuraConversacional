package com.AventuraConversacional;

public class NPC {
    private String nom = "";
    private String onEstic;
    private boolean viu = true;
    private boolean donar = false;

    public NPC() {
    }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getOnEstic() { return onEstic; }

    public void setOnEstic(String onEstic) { this.onEstic = onEstic; }

    public boolean isViu() { return viu; }

    public void setViu(boolean viu) { this.viu = viu; }

    public boolean isDonar() { return donar; }

    public void setDonar(boolean donar) { this.donar = donar; }
}
