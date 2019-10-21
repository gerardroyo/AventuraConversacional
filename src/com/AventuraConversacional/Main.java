package com.AventuraConversacional;

import java.util.Scanner;

public class Main {

    private static int capacitatRooms = 10;
    private static int capacitatItems = 4;
    private static int capacitatNPCs = 2;

    private static Room rooms[]= new Room[capacitatRooms];
    private static Item items[] = new Item[capacitatItems];
    private static NPC NPCs[] = new NPC[capacitatNPCs];
    private static Player jugador = new Player();
    private static PassarMayus toMayus = new PassarMayus();
    private static CaracterCorrecte cc = new CaracterCorrecte();

    private static Scanner teclat = new Scanner(System.in);

    private static char movJugador;

    public static void main(String[] args) {

        System.out.println("________________________________________________________________________________________________________");
        System.out.println("Instruccions de moviment: AMUNT(W), ESQUERRA(A), AVALL(S), DRETA(D), ESCALES(E) | Per sortir escriu (Q))");

        crearMapa();
        crearItems();
        crearNPCs();

        jugador.setOnEstic(rooms[7].getNom());
        while (movJugador != 'Q' && movJugador != 'q') {
            jugadorOnEsta();

            moure();
        }
        System.out.println("Gracies per jugar!");
    }

    public static void crearMapa() {
        rooms[0] = new Room();
            rooms[0].setNom("cuina");
            rooms[0].setDescripcio("descripció cuina");
            rooms[0].setPortaNord(false);
            rooms[0].setPortaSud(true);
            rooms[0].setPortaEst(true);
            rooms[0].setPortaOest(false);
            rooms[0].setEscalaAqui(true);

        rooms[1] = new Room();
            rooms[1].setNom("magatzem");
            rooms[1].setDescripcio("descripció magatzem");
            rooms[1].setPortaNord(false);
            rooms[1].setPortaSud(true);
            rooms[1].setPortaEst(true);
            rooms[1].setPortaOest(true);
            rooms[1].setEscalaAqui(false);

        rooms[2] = new Room();
            rooms[2].setNom("menjador");
            rooms[2].setDescripcio("descripció menjador");
            rooms[2].setPortaNord(false);
            rooms[2].setPortaSud(true);
            rooms[2].setPortaEst(false);
            rooms[2].setPortaOest(true);
            rooms[2].setEscalaAqui(false);

        rooms[3] = new Room();
            rooms[3].setNom("bany");
            rooms[3].setDescripcio("descripció bany");
            rooms[3].setPortaNord(true);
            rooms[3].setPortaSud(true);
            rooms[3].setPortaEst(true);
            rooms[3].setPortaOest(false);
            rooms[3].setEscalaAqui(false);

        rooms[4] = new Room();
            rooms[4].setNom("sala");
            rooms[4].setDescripcio("descripció sala");
            rooms[4].setPortaNord(true);
            rooms[4].setPortaSud(true);
            rooms[4].setPortaEst(true);
            rooms[4].setPortaOest(true);
            rooms[4].setEscalaAqui(false);

        rooms[5] = new Room();
            rooms[5].setNom("caballerisses");
            rooms[5].setDescripcio("descripció caballerisses");
            rooms[5].setPortaNord(true);
            rooms[5].setPortaSud(true);
            rooms[5].setPortaEst(false);
            rooms[5].setPortaOest(true);
            rooms[5].setEscalaAqui(false);

        rooms[6] = new Room();
            rooms[6].setNom("ball");
            rooms[6].setDescripcio("descripció ball");
            rooms[6].setPortaNord(true);
            rooms[6].setPortaSud(false);
            rooms[6].setPortaEst(true);
            rooms[6].setPortaOest(false);
            rooms[6].setEscalaAqui(false);

        rooms[7] = new Room();
            rooms[7].setNom("entrada");
            rooms[7].setDescripcio("descripció entrada");
            rooms[7].setPortaNord(true);
            rooms[7].setPortaSud(false);
            rooms[7].setPortaEst(true);
            rooms[7].setPortaOest(true);
            rooms[7].setEscalaAqui(false);

        rooms[8] = new Room();
            rooms[8].setNom("gym");
            rooms[8].setDescripcio("descripció gym");
            rooms[8].setPortaNord(true);
            rooms[8].setPortaSud(false);
            rooms[8].setPortaEst(false);
            rooms[8].setPortaOest(true);
            rooms[8].setEscalaAqui(false);

        rooms[9] = new Room();
            rooms[9].setNom("habJordiJor");
            rooms[9].setDescripcio("descripció habJordiJor");
            rooms[9].setPortaNord(false);
            rooms[9].setPortaSud(false);
            rooms[9].setPortaEst(false);
            rooms[9].setPortaOest(false);
            rooms[9].setEscalaAqui(true);

    }

    public static void  crearItems() {
        items[0] = new Item();
            items[0].setNom("Espassa");
            items[0].setUsat(false);
            items[0].setDescripcio("Espassa màgica amb la que ens podrem defensar de possibles enemics i inclús\n" +
                    "poder-los atacar en els moments en els que calgui.");
            items[0].setOnEstic(rooms[2].getNom());

        items[1] = new Item();
            items[1].setNom("Clau");
            items[1].setUsat(false);
            items[1].setDescripcio("La clau ens permetrà obrir certes portes del Palau. El problema es que sempre la\n" +
                    "trobarem a dalt d’algun moble i no hi arribarem tot sols.");
            items[1].setOnEstic(rooms[3].getNom());

        items[2] = new Item();
            items[2].setNom("Escala de Má");
            items[2].setUsat(false);
            items[2].setDescripcio("doncs això.... una escala que ens permetrà accedir a objectes que estiguin elevats.");
            items[2].setOnEstic(rooms[1].getNom());

        items[3] = new Item();
            items[2].setNom("Bosa de Diners");
            items[2].setUsat(false);
            items[2].setDescripcio("Una bossa de dines sempre ens pot ser d’utilitat per aconseguir coses...");
            items[2].setOnEstic(rooms[5].getNom());
    }

    public static void crearNPCs() {
        NPCs[0] = new NPC();
            NPCs[0].setNom("Cuinera");
            NPCs[0].setOnEstic(rooms[0].getNom());
            NPCs[0].setViu(true);
            NPCs[0].setDonar(false);

        NPCs[1] = new NPC();
            NPCs[1].setNom("JordiJor");
            NPCs[1].setOnEstic(rooms[9].getNom());
            NPCs[1].setViu(true);
            NPCs[1].setDonar(false);
    }

    public static void jugadorOnEsta() {

        System.out.println("________________________________________________________________________________________________________");
        System.out.println("Estas situat a l'habitació: " + jugador.getOnEstic());
    }

    public static void moure() {

        int hiHaItemRoom;
        int hiHaItemJugador;
        char movJugadorMayus;
        String itemAAgafar;
        String itemADeixar;
        String verbMenu;

        if (jugador.getOnEstic() == rooms[0].getNom()) {

            System.out.println("Descripció: " + rooms[0].getDescripcio());
            hiHaItemRoom = itemsRoom(rooms[0].getNom()); // Mostra els Items que hi han en l'habitació actual
            hiHaItemJugador = itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a la DRETA/AVALL/ESCALES");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":
                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

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
                    break;
                case "AGAFAR":

                    if (hiHaItemRoom > 0) {
                        System.out.println("Quin Item de l'habitació vols agafar?");
                        itemAAgafar = teclat.next();
                        teclat.nextLine();
                        for (int i = 0; i < capacitatItems; i++) {
                            if (itemAAgafar == items[i].getNom() && items[i].getOnEstic() == rooms[0].getNom()) {
                                items[i].setOnEstic(jugador.getNom());
                                 i = capacitatItems;
                            }
                        }
                    } else {
                        System.out.println("No pots fer aquesta acció perque no hi han Items a l'habitació");
                    }

                    break;
                case "DEIXAR":

                    if (hiHaItemJugador > 0) {
                        System.out.println("Quin Item de l'habitació vols agafar?");
                        itemADeixar = teclat.next();
                        teclat.nextLine();
                        for (int i = 0; i < capacitatItems; i++) {
                            if (itemADeixar == items[i].getNom() && items[i].getOnEstic() == jugador.getNom()) {
                                items[i].setOnEstic(rooms[0].getNom());
                                i = capacitatItems;
                            }
                        }

                    } else {
                        System.out.println("No pots fer aquesta acció perque no hi han Items a l'habitació");
                    }

                    break;
            }
        } else if (jugador.getOnEstic() == rooms[1].getNom()) {
            System.out.println("Descripció: " + rooms[1].getDescripcio());
            itemsRoom(rooms[1].getNom()); // Mostra els Items que hi han en l'habitació actual
            itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a l'ESQUERRA/DRETA/AVALL");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":

                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

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
            }
        } else if (jugador.getOnEstic() == rooms[2].getNom()) {
            System.out.println("Descripció: " + rooms[2].getDescripcio());
            itemsRoom(rooms[2].getNom()); // Mostra els Items que hi han en l'habitació actual
            itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a l'ESQUERRA/AVALL");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":

                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

                    switch (movJugadorMayus) {
                        case 'A':
                            jugador.setOnEstic(rooms[1].getNom());
                            break;
                        case 'S':
                            jugador.setOnEstic(rooms[5].getNom());
                            break;
                    }
            }
        } else if (jugador.getOnEstic() == rooms[3].getNom()) {
            System.out.println("Descripció: " + rooms[3].getDescripcio());
            itemsRoom(rooms[3].getNom()); // Mostra els Items que hi han en l'habitació actual
            itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a la DRETA/AVALL/AMUNT");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":

                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

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
            }
        } else if (jugador.getOnEstic() == rooms[4].getNom()) {
            System.out.println("Descripció: " + rooms[4].getDescripcio());
            itemsRoom(rooms[4].getNom()); // Mostra els Items que hi han en l'habitació actual
            itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a l'ESQUERRA/DRETA/AVALL/AMUNT");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":

                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

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
            }
        } else if (jugador.getOnEstic() == rooms[5].getNom()) {
            System.out.println("Descripció: " + rooms[5].getDescripcio());
            itemsRoom(rooms[5].getNom()); // Mostra els Items que hi han en l'habitació actual
            itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a l'ESQUERRA/AVALL/AMUNT");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":

                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

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
            }
        } else if (jugador.getOnEstic() == rooms[6].getNom()) {
            System.out.println("Descripció: " + rooms[6].getDescripcio());
            itemsRoom(rooms[6].getNom()); // Mostra els Items que hi han en l'habitació actual
            itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a la DRETA/AMUNT");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":

                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

                    switch (movJugadorMayus) {
                        case 'D':
                            jugador.setOnEstic(rooms[7].getNom());
                            break;
                        case 'W':
                            jugador.setOnEstic(rooms[3].getNom());
                            break;
                    }
            }
        } else if (jugador.getOnEstic() == rooms[7].getNom()) {
            System.out.println("Descripció: " + rooms[7].getDescripcio());
            itemsRoom(rooms[7].getNom()); // Mostra els Items que hi han en l'habitació actual
            itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a l'ESQUERRA/DRETA/AMUNT");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":

                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

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
            }
        } else if (jugador.getOnEstic() == rooms[8].getNom()) {
            System.out.println("Descripció: " + rooms[8].getDescripcio());
            itemsRoom(rooms[8].getNom()); // Mostra els Items que hi han en l'habitació actual
            itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a l'ESQUERRA/AMUNT");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":

                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

                    switch (movJugadorMayus) {
                        case 'A':
                            jugador.setOnEstic(rooms[7].getNom());
                            break;
                        case 'W':
                            jugador.setOnEstic(rooms[5].getNom());
                            break;
                    }
            }
        } else if (jugador.getOnEstic() == rooms[9].getNom()) {
            System.out.println("Descripció: " + rooms[9].getDescripcio());
            itemsRoom(rooms[9].getNom()); // Mostra els Items que hi han en l'habitació actual
            itemsJugador(); // Mostra els Items que te el jugador a l'inventari
            System.out.println("Et pots moure cap a les ESCALES");

            verbMenu = menuVerbs();

            switch (verbMenu) {
                case "ANAR":

                    System.out.println("On et vols moure?");

                    movJugadorMayus = controladorChars();

                    switch (movJugadorMayus) {
                        case 'E':
                            jugador.setOnEstic(rooms[0].getNom());
                            break;
                    }
            }
        }
    }

    public static String menuVerbs() {
        String verbMenu;
        System.out.println("Quina acció vols fer? (ANAR/DEIXAR/AGAFAR/USAR/PARLAR/PUJAR)");
        verbMenu = teclat.next();
        teclat.nextLine();

        return verbMenu;
    }

    public static int itemsRoom(String nomRoom) {
        int numItems = 0;

        System.out.print("Items de l'habitació: ");

        for (int i = 0; i < items.length; i++) {
            if (items[i].getOnEstic() == nomRoom) {
                System.out.println("| " + items[i].getNom() + " | ");
                numItems++;
            }
        }
        return numItems;
    }

    public static int itemsJugador() {
        int numItems = 0;

        System.out.print("Items de l'inventari: ");

        for (int i = 0; i < items.length; i++) {
            if (items[i].getOnEstic() == jugador.getNom()) {
                System.out.println("| " + items[i].getNom() + " | ");
                numItems++;
            }
        }
        return numItems;
    }

    public static char controladorChars() {
        boolean caracterIncorrecte = true;

        char movJugadorMayus = ' ';

        while (caracterIncorrecte == true) {
            movJugador = teclat.next().charAt(0);
            movJugadorMayus = toMayus.cadenaAMayus(movJugador);
            caracterIncorrecte = cc.controladorChar(movJugadorMayus);
        }

        return movJugadorMayus;
    }
}
