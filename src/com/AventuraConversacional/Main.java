package com.AventuraConversacional;

import java.util.Scanner;

public class Main {

    private static int capacitat = 10;
    private static Room rooms[]= new Room[capacitat];
    private static Player jugador = new Player();

    private static Scanner teclat = new Scanner(System.in);
    private static PassarMayus toMayus = new PassarMayus();
    private static CaracterCorrecte cc = new CaracterCorrecte();

    private static char movJugador;

    public static void main(String[] args) {

        System.out.println("Instruccions de moviment: AMUNT(W), ESQUERRA(A), AVALL(S), DRETA(D), ESCALES(E) | Per sortir escriu (Q))");

        crearMapa();
        jugador.setOnEstic(rooms[7].getNom());
        while (movJugador != 'Q' && movJugador != 'q') {
            jugador();

            moure();
        }
        System.out.println("Gracies per jugar!");
    }

    public static void crearMapa() {
        rooms[0] = new Room();
            rooms[0].setNom("cuina");
            rooms[0].setPortaNord(false);
            rooms[0].setPortaSud(true);
            rooms[0].setPortaEst(true);
            rooms[0].setPortaOest(false);
            rooms[0].setEscalaAqui(true);

        rooms[1] = new Room();
            rooms[1].setNom("magatzem");
            rooms[1].setPortaNord(false);
            rooms[1].setPortaSud(true);
            rooms[1].setPortaEst(true);
            rooms[1].setPortaOest(true);
            rooms[1].setEscalaAqui(false);

        rooms[2] = new Room();
            rooms[2].setNom("menjador");
            rooms[2].setPortaNord(false);
            rooms[2].setPortaSud(true);
            rooms[2].setPortaEst(false);
            rooms[2].setPortaOest(true);
            rooms[2].setEscalaAqui(false);

        rooms[3] = new Room();
            rooms[3].setNom("bany");
            rooms[3].setPortaNord(true);
            rooms[3].setPortaSud(true);
            rooms[3].setPortaEst(true);
            rooms[3].setPortaOest(false);
            rooms[3].setEscalaAqui(false);

        rooms[4] = new Room();
            rooms[4].setNom("sala");
            rooms[4].setPortaNord(true);
            rooms[4].setPortaSud(true);
            rooms[4].setPortaEst(true);
            rooms[4].setPortaOest(true);
            rooms[4].setEscalaAqui(false);

        rooms[5] = new Room();
            rooms[5].setNom("caballerisses");
            rooms[5].setPortaNord(true);
            rooms[5].setPortaSud(true);
            rooms[5].setPortaEst(false);
            rooms[5].setPortaOest(true);
            rooms[5].setEscalaAqui(false);

        rooms[6] = new Room();
            rooms[6].setNom("ball");
            rooms[6].setPortaNord(true);
            rooms[6].setPortaSud(false);
            rooms[6].setPortaEst(true);
            rooms[6].setPortaOest(false);
            rooms[6].setEscalaAqui(false);

        rooms[7] = new Room();
            rooms[7].setNom("entrada");
            rooms[7].setPortaNord(true);
            rooms[7].setPortaSud(false);
            rooms[7].setPortaEst(true);
            rooms[7].setPortaOest(true);
            rooms[7].setEscalaAqui(false);

        rooms[8] = new Room();
            rooms[8].setNom("gym");
            rooms[8].setPortaNord(true);
            rooms[8].setPortaSud(false);
            rooms[8].setPortaEst(false);
            rooms[8].setPortaOest(true);
            rooms[8].setEscalaAqui(false);

        rooms[9] = new Room();
            rooms[9].setNom("habJordiJor");
            rooms[9].setPortaNord(false);
            rooms[9].setPortaSud(false);
            rooms[9].setPortaEst(false);
            rooms[9].setPortaOest(false);
            rooms[9].setEscalaAqui(true);

    }

    public static void jugador() {
        System.out.println("Estas situat a la habitació: " + jugador.getOnEstic());
    }

    public static void moure() {

        boolean caracterIncorrecte = true;

        char movJugadorMayus = ' ';

        if (jugador.getOnEstic() == rooms[0].getNom()) {


            System.out.println("Et pots moure cap a la DRETA/AVALL/ESCALES");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'D':
                    jugador.setOnEstic(rooms[1].getNom());
                    break;
                case 'S':
                    jugador.setOnEstic(rooms[3].getNom());
                    break;
                case 'E':
                    jugador.setOnEstic(rooms[9].getNom());
                    break;
            }

        } else if (jugador.getOnEstic() == rooms[1].getNom()) {
            System.out.println("Et pots moure cap a l'ESQUERRA/DRETA/AVALL");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'A':
                    jugador.setOnEstic(rooms[0].getNom());
                    break;
                case 'D':
                    jugador.setOnEstic(rooms[2].getNom());
                    break;
                case 'S':
                    jugador.setOnEstic(rooms[4].getNom());
                    break;
            }

        } else if (jugador.getOnEstic() == rooms[2].getNom()) {
            System.out.println("Et pots moure cap a l'ESQUERRA/AVALL");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'A':
                    jugador.setOnEstic(rooms[1].getNom());
                    break;
                case 'S':
                    jugador.setOnEstic(rooms[5].getNom());
                    break;
            }

        } else if (jugador.getOnEstic() == rooms[3].getNom()) {
            System.out.println("Et pots moure cap a la DRETA/AVALL/AMUNT");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'D':
                    jugador.setOnEstic(rooms[4].getNom());
                    break;
                case 'S':
                    jugador.setOnEstic(rooms[6].getNom());
                    break;
                case 'W':
                    jugador.setOnEstic(rooms[0].getNom());
                    break;
            }

        } else if (jugador.getOnEstic() == rooms[4].getNom()) {
            System.out.println("Et pots moure cap a l'ESQUERRA/DRETA/AVALL/AMUNT");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'D':
                    jugador.setOnEstic(rooms[5].getNom());
                    break;
                case 'S':
                    jugador.setOnEstic(rooms[7].getNom());
                    break;
                case 'A':
                    jugador.setOnEstic(rooms[3].getNom());
                    break;
                case 'W':
                    jugador.setOnEstic(rooms[1].getNom());
                    break;
            }

        } else if (jugador.getOnEstic() == rooms[5].getNom()) {
            System.out.println("Et pots moure cap a l'ESQUERRA/AVALL/AMUNT");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'S':
                    jugador.setOnEstic(rooms[8].getNom());
                    break;
                case 'A':
                    jugador.setOnEstic(rooms[4].getNom());
                    break;
                case 'W':
                    jugador.setOnEstic(rooms[2].getNom());
                    break;
            }

        } else if (jugador.getOnEstic() == rooms[6].getNom()) {
            System.out.println("Et pots moure cap a la DRETA/AMUNT");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'D':
                    jugador.setOnEstic(rooms[7].getNom());
                    break;
                case 'W':
                    jugador.setOnEstic(rooms[3].getNom());
                    break;
            }

        } else if (jugador.getOnEstic() == rooms[7].getNom()) {
            System.out.println("Et pots moure cap a l'ESQUERRA/DRETA/AMUNT");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'D':
                    jugador.setOnEstic(rooms[8].getNom());
                    break;
                case 'A':
                    jugador.setOnEstic(rooms[6].getNom());
                    break;
                case 'W':
                    jugador.setOnEstic(rooms[4].getNom());
                    break;
            }

        } else if (jugador.getOnEstic() == rooms[8].getNom()) {
            System.out.println("Et pots moure cap a l'ESQUERRA/AMUNT");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'A':
                    jugador.setOnEstic(rooms[7].getNom());
                    break;
                case 'W':
                    jugador.setOnEstic(rooms[5].getNom());
                    break;
            }

        } else if (jugador.getOnEstic() == rooms[9].getNom()) {
            System.out.println("Et pots moure cap a les ESCALES");
            System.out.println("On et vols moure?");

            while (caracterIncorrecte == true) {
                movJugador = teclat.next().charAt(0);
                movJugadorMayus = toMayus.cadenaAMayus(movJugador);
                caracterIncorrecte = cc.controladorChar(movJugadorMayus);
            }

            switch (movJugadorMayus) {
                case 'E':
                    jugador.setOnEstic(rooms[0].getNom());
                    break;
            }

        }
    }


}
