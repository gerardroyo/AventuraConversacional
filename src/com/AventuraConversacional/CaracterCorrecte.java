package com.AventuraConversacional;

public class CaracterCorrecte {

    public boolean controladorChar(String caracterChar) {
        boolean entradaCorrecte = true;

        if (caracterChar.equals("NORTH") || caracterChar.equals("WEST") || caracterChar.equals("SOUTH") || caracterChar.equals("EAST") || caracterChar.equals("ESCALES") || caracterChar.equals("EXIT")) {
            entradaCorrecte = false;
        } else if (caracterChar.equals("ANAR") || caracterChar.equals("DEIXAR") || caracterChar.equals("AGAFAR") || caracterChar.equals("USAR") || caracterChar.equals("INTERACTUAR")) {
            entradaCorrecte = false;
        } else {
            System.out.println("No has escrit be la instrucció, torna-hi: ");
        }
        return entradaCorrecte;
    }

}
