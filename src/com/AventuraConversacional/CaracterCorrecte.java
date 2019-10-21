package com.AventuraConversacional;

public class CaracterCorrecte {

    public boolean controladorChar(char caracterChar) {
        boolean entradaCorrecte = true;

        if (caracterChar == 'W' || caracterChar == 'A' || caracterChar == 'S' || caracterChar == 'D' || caracterChar == 'E' || caracterChar == 'Q') {
            entradaCorrecte = false;
        }
        else {
            System.out.println("No has escrit be la instrucció, torna-hi: ");
        }
        return entradaCorrecte;
    }

}
