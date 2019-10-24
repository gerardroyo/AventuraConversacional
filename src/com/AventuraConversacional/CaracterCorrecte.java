package com.AventuraConversacional;

public class CaracterCorrecte {

    public boolean controladorTeclat(String caracterChar) {
        boolean entradaCorrecte = true;

        if (caracterChar.equals("NORTH") || caracterChar.equals("WEST") || caracterChar.equals("SOUTH") || caracterChar.equals("EAST") || caracterChar.equals("ESCALES") || caracterChar.equals("EXIT")) {
            entradaCorrecte = false;
        } else if (caracterChar.equals("ANAR") || caracterChar.equals("DEIXAR") || caracterChar.equals("AGAFAR") || caracterChar.equals("USAR") || caracterChar.equals("INTERACTUAR")) {
            entradaCorrecte = false;
        } else if (caracterChar.equals("ESPASA") || caracterChar.equals("CLAU") || caracterChar.equals("ESCALAMA") || caracterChar.equals("BOSADINERS")) {
            entradaCorrecte = false;
        } else if (caracterChar.equals("CUINERA") || caracterChar.equals("JORDIJOR")) {
            entradaCorrecte = false;
        } else if (caracterChar.equals("SI") || caracterChar.equals("NO")) {
            entradaCorrecte = false;
        } else {
            System.out.println("No has escrit be l'instrucció, torna-hi: ");
        }
        return entradaCorrecte;
    }

}
