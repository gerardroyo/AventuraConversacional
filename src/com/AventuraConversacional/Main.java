package com.AventuraConversacional;

import java.util.Scanner;

public class Main {

    private static int capacitatRooms = 10;
    private static int capacitatItems = 4;
    private static int capacitatNPCs = 2;
    private static boolean soborn = false;

    private static Room rooms[]= new Room[capacitatRooms];
    private static Item items[] = new Item[capacitatItems];
    private static NPC NPCs[] = new NPC[capacitatNPCs];
    private static Player jugador = new Player();
    private static PassarMayus toMayus = new PassarMayus();
    private static CaracterCorrecte cc = new CaracterCorrecte();

    private static Scanner teclat = new Scanner(System.in);

    private static String movJugador;

    public static void main(String[] args) {

        crearMapa();
        crearItems();
        crearNPCs();

        jugador.setOnEstic(rooms[7].getNom()); // iniciem al jugador a l'habitacio "entrada"
        while (movJugador != "EXIT") { // si el jugador introdueix "EXIT" per teclat el joc s'acaba (aixo perque encara no esta programat la possibilitat de guanyar o perdre)

            System.out.println("________________________________________________________________________________________________________");
            System.out.println("Instruccions de moviment: NORTH, WEST, SOUTH, EAST, ESCALES | Per sortir escriu EXIT)");

            jugadorOnEsta();

            accionsv2();
        }
        System.out.println("Gracies per jugar!");
    }

    // creem la array i coloquem on estaran totes les habitacions, amb tota la info dels paramentres ja introduida
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

    // creem l'array i coloquem els items dins d'ella amb tota la info dels items tmb.
    public static void  crearItems() {
        items[0] = new Item();
            items[0].setNom("ESPASA");
            items[0].setUsat(false);
            items[0].setDescripcio("Espassa màgica amb la que ens podrem defensar de possibles enemics i inclús\n" +
                    "poder-los atacar en els moments en els que calgui.");
            items[0].setOnEstic(rooms[2].getNom());

        items[1] = new Item();
            items[1].setNom("CLAU");
            items[1].setUsat(false);
            items[1].setDescripcio("La clau ens permetrà obrir certes portes del Palau. El problema es que sempre la\n" +
                    "trobarem a dalt d’algun moble i no hi arribarem tot sols.");
            items[1].setOnEstic(rooms[3].getNom());

        items[2] = new Item();
            items[2].setNom("ESCALA DE MA");
            items[2].setUsat(false);
            items[2].setDescripcio("doncs això.... una escala que ens permetrà accedir a objectes que estiguin elevats.");
            items[2].setOnEstic(rooms[1].getNom());

        items[3] = new Item();
            items[2].setNom("BOSA AMB DINERS");
            items[2].setUsat(false);
            items[2].setDescripcio("Una bossa de dines sempre ens pot ser d’utilitat per aconseguir coses...");
            items[2].setOnEstic(rooms[5].getNom());
    }

    // creem l'array dels NPCs i els coloquem dins d'aquesta + tota la info dels mateixos
    public static void crearNPCs() {
        NPCs[0] = new NPC();
            NPCs[0].setNom("Cuinera");
            NPCs[0].setOnEstic(rooms[0].getNom());
            NPCs[0].setViu(true);
            NPCs[0].setDonar(false);
            NPCs[0].setParlar("WASAAAAAAAAAAAAAA, sóc la cuinera, dame tol money si kere la info, otaku culiao");

        NPCs[1] = new NPC();
            NPCs[1].setNom("JordiJor");
            NPCs[1].setOnEstic(rooms[9].getNom());
            NPCs[1].setViu(true);
            NPCs[1].setDonar(false);
            NPCs[1].setParlar("zzZZzZzzZzzZz... titis... zzZZzZZZzZzZZ...");
    }

    // mostrar per pantalla en quina habitació es trova el jugador
    public static void jugadorOnEsta() {

        System.out.println("________________________________________________________________________________________________________");
        System.out.println("Estas situat a l'habitació: " + jugador.getOnEstic());
    }

    // on es produeixen totes les accions que pot fer el jugador i les seves interactuacions amb Items i NPCs
    public static void accionsv2() {

        int hiHaItemRoom;
        int hiHaItemJugador;
        int hiHaNPCsRoom;
        String movJugadorMayus;
        String itemADeixar;
        String verbMenu;

        for (int i = 0; i < capacitatRooms; i++) {
            if(jugador.getOnEstic() == rooms[i].getNom()) {
                System.out.println("Descripció: " + rooms[i].getDescripcio());
                hiHaItemRoom = itemsRoom(rooms[i].getNom()); // Mostra els Items que hi han en l'habitació actual
                hiHaItemJugador = itemsJugador(); // Mostra els Items que te el jugador a l'inventari
                hiHaNPCsRoom = NPCsRoom(rooms[i].getNom());
                if (soborn == true) {
                    for (int j = 0; j < capacitatRooms; j++) {
                        if (rooms[j].getEscalaAqui() == true) {
                            System.out.println("L'escala per pujar al segon pis esta a l'habitacio: " + rooms[j].getNom());
                        }
                    }
                }

                verbMenu = menuVerbs();

                switch (verbMenu) {
                    case "ANAR":

                        System.out.println("On et vols moure?");

                        movJugadorMayus = controladorChars();

                        moureJugador(movJugadorMayus);

                        break;
                    case "AGAFAR":

                        algoritmeAgafar(hiHaItemRoom);

                        break;
                    case "DEIXAR":

                        algoritmeDeixar(hiHaItemJugador);

                        break;
                    case "INTERACTUAR":

                        algoritmeInteractuarNPC(hiHaNPCsRoom);

                        break;
                }
            }
        }
    }

    public static void moureJugador(String movJugadorMayus) {
        switch (movJugadorMayus) {
            case "EAST":
               if(jugador.getOnEstic() == rooms[0].getNom()) {
                    jugador.setOnEstic(rooms[1].getNom());
                } else if(jugador.getOnEstic() == rooms[1].getNom()) {
                   jugador.setOnEstic(rooms[2].getNom());
                } else if(jugador.getOnEstic() == rooms[3].getNom()) {
                    jugador.setOnEstic(rooms[4].getNom());
                } else if(jugador.getOnEstic() == rooms[4].getNom()) {
                    jugador.setOnEstic(rooms[5].getNom());
                } else if(jugador.getOnEstic() == rooms[6].getNom()) {
                    jugador.setOnEstic(rooms[7].getNom());
                } else if(jugador.getOnEstic() == rooms[7].getNom()) {
                    jugador.setOnEstic(rooms[8].getNom());
                } else {
                   System.out.println("No pots anar cap aquesta direcció.");
               }
                break;
            case "SOUTH":
                if(jugador.getOnEstic() == rooms[0].getNom()) {
                    jugador.setOnEstic(rooms[3].getNom());
                } else if(jugador.getOnEstic() == rooms[1].getNom()) {
                    jugador.setOnEstic(rooms[4].getNom());
                } else if(jugador.getOnEstic() == rooms[2].getNom()) {
                    jugador.setOnEstic(rooms[5].getNom());
                } else if(jugador.getOnEstic() == rooms[3].getNom()) {
                    jugador.setOnEstic(rooms[6].getNom());
                } else if(jugador.getOnEstic() == rooms[4].getNom()) {
                    jugador.setOnEstic(rooms[7].getNom());
                } else if(jugador.getOnEstic() == rooms[5].getNom()) {
                    jugador.setOnEstic(rooms[8].getNom());
                } else {
                    System.out.println("No pots anar cap aquesta direcció.");
                }
                break;
            case "WEST":
                if(jugador.getOnEstic() == rooms[1].getNom()) {
                    jugador.setOnEstic(rooms[0].getNom());
                } else if(jugador.getOnEstic() == rooms[2].getNom()) {
                    jugador.setOnEstic(rooms[1].getNom());
                } else if(jugador.getOnEstic() == rooms[4].getNom()) {
                    jugador.setOnEstic(rooms[3].getNom());
                } else if(jugador.getOnEstic() == rooms[5].getNom()) {
                    jugador.setOnEstic(rooms[4].getNom());
                } else if(jugador.getOnEstic() == rooms[7].getNom()) {
                    jugador.setOnEstic(rooms[6].getNom());
                } else if(jugador.getOnEstic() == rooms[8].getNom()) {
                    jugador.setOnEstic(rooms[7].getNom());
                } else {
                    System.out.println("No pots anar cap aquesta direcció.");
                }
                break;
            case "NORTH":
                if(jugador.getOnEstic() == rooms[3].getNom()) {
                    jugador.setOnEstic(rooms[0].getNom());
                } else if(jugador.getOnEstic() == rooms[4].getNom()) {
                    jugador.setOnEstic(rooms[1].getNom());
                } else if(jugador.getOnEstic() == rooms[5].getNom()) {
                    jugador.setOnEstic(rooms[2].getNom());
                } else if(jugador.getOnEstic() == rooms[6].getNom()) {
                    jugador.setOnEstic(rooms[3].getNom());
                } else if(jugador.getOnEstic() == rooms[7].getNom()) {
                    jugador.setOnEstic(rooms[4].getNom());
                } else if(jugador.getOnEstic() == rooms[8].getNom()) {
                    jugador.setOnEstic(rooms[5].getNom());
                } else {
                    System.out.println("No pots anar cap aquesta direcció.");
                }
                break;
            case "ESCALES":
                if(jugador.getOnEstic() == rooms[0].getNom()) {
                    jugador.setOnEstic(rooms[9].getNom());
                } else if(jugador.getOnEstic() == rooms[9].getNom()) {
                    jugador.setOnEstic(rooms[0].getNom());
                } else {
                    System.out.println("No pots anar cap aquesta direcció.");
                }
                break;
        }
    }

    // pregunta per l'accio
    public static String menuVerbs() {
        String verbMenu;
        System.out.println("Quina acció vols fer? (ANAR/DEIXAR/AGAFAR/USAR/INTERACTUAR)");
        verbMenu = controladorChars(); //controla que la instruccio introduida sigui la correcte, si no ho es, torna a preguntar

        return verbMenu;
    }

    //llista per pantalla els items que hi ha en l'habitacio que el jugador esta situat
    public static int itemsRoom(String nomRoom) {
        int numItems = 0;

        System.out.println("Items de l'habitació: ");

        for (int i = 0; i < items.length; i++) {
            if (items[i].getOnEstic() == nomRoom) {
                System.out.println("| " + items[i].getNom() + " | ");
                numItems++;
            }
        }
        return numItems;
    }

    //llista per pantalla els items que te el jugador a l'inventari
    public static int itemsJugador() {
        int numItems = 0;

        System.out.println("Items de l'inventari: ");

        for (int i = 0; i < items.length; i++) {
            if (items[i].getOnEstic() == jugador.getNom()) {
                System.out.println("| " + items[i].getNom() + " | ");
                numItems++;
            }
        }
        return numItems;
    }

    public static int NPCsRoom(String nomRoom) {
        int numNPCs = 0;

        System.out.println("NPCs de l'habitació: ");

        for (int i = 0; i < NPCs.length; i++) {
            if (NPCs[i].getOnEstic() == nomRoom) {
                System.out.println("| " + NPCs[i].getNom() + " | ");
                numNPCs++;
            }
        }
        return numNPCs;
    }

    // controla els Strings introduits per l'usuari a traves d'una classe externa (PASSARMAYUS i CARACTERCORRECTE)
    public static String controladorChars() {
        boolean caracterIncorrecte = true;

        String movJugadorMayus = "";

        while (caracterIncorrecte == true) {
            movJugador = teclat.next();
            teclat.nextLine();

            movJugadorMayus = toMayus.cadenaAMayus(movJugador);
            caracterIncorrecte = cc.controladorChar(movJugadorMayus);
        }

        return movJugadorMayus;
    }

    public static void algoritmeAgafar(int hiHaItemRoom) {
        String itemAAgafar;

        if (hiHaItemRoom > 0) { // controla si hi han items a l'habitacio
            System.out.println("Quin Item de l'habitació vols agafar?");
            itemAAgafar = teclat.next();
            teclat.nextLine();
            for (int j = 0; j < capacitatRooms; j++) {
                for (int i = 0; i < capacitatItems; i++) {
                    if (itemAAgafar == items[i].getNom() && items[i].getOnEstic() == rooms[j].getNom()) {
                        System.out.println("He entrat a l'if");
                        items[i].setOnEstic(jugador.getNom());
                        i = capacitatItems;
                    }
                }
            }
        } else {
            System.out.println("No pots fer aquesta acció perque no hi han Items a l'habitació");
        }
    }

    public static void algoritmeDeixar(int hiHaItemJugador) {
        String itemADeixar;

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
            System.out.println("No pots fer aquesta acció perque no tens Items L'INVENTARI");
        }
    }

    public static void algoritmeInteractuarNPC(int hiHaNPCsRoom) {
        String NPCAParlar;

        if (hiHaNPCsRoom > 0) { // controla si hi han items a l'habitacio
            System.out.println("Amb quin NPC vols Interactuar?");
            NPCAParlar = teclat.next();
            teclat.nextLine();
            for (int j = 0; j < capacitatRooms; j++) {
                for (int i = 0; i < capacitatNPCs; i++) {
                    if (NPCAParlar == NPCs[i].getNom() && NPCs[i].getOnEstic() == rooms[j].getNom()) {
                        System.out.println(NPCs[i].getParlar());

                        if (items[3].getOnEstic() == jugador.getNom()) {
                            items[3].setOnEstic(NPCs[i].getNom());
                            System.out.println("Li has donat la bosa de diners a la cuinera, a canvi de la informacio d'on esta situada l'escala per pujar al 2n pis.");
                            soborn = true;
                        }

                        i = capacitatItems;
                    }
                }
            }
        } else {
            System.out.println("No pots fer aquesta acció perque no hi han ningun NPC a l'habitació");
        }
    }

}
