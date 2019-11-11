package com.AventuraConversacional;
// By Gerard Royo i Plà
// Twitter: @RoshsKipo

// FINISHED 25/10/2019 20:18
import java.util.Scanner;

public class Main {

    private static int capacitatRooms = 10;
    private static int capacitatItems = 6;
    private static int capacitatNPCs = 2;
    private static int properaLliureItems = 0;
    private static int properaLliureRooms = 0;
    private static boolean soborn = false;
    private static boolean win = false;

    private static Room rooms[]= new Room[capacitatRooms];
    private static Item items[] = new Item[capacitatItems];
    private static NPC NPCs[] = new NPC[capacitatNPCs];
    private static Player jugador = new Player();
    private static PassarMayus toMayus = new PassarMayus();
    private static CaracterCorrecte cc = new CaracterCorrecte();

    private static Scanner teclat = new Scanner(System.in);

    private static String movJugador;
    private static String again = "SI";

    private static int ItemsRandom [] = new int [capacitatItems];
    private static String RoomsRandom [] = new String [9];

    private static String[] nomRooms = {"cuina", "magatzem", "menjador", "bany", "sala", "caballerisses", "ball", "entrada", "gym"};

    public static void main(String[] args) {
        while (again.equals("SI")) {
            crearMapa(); // creació de les habitacions
            crearItems(); // creació dels items
            crearNPCs(); // creació dels NPCs

            System.out.println();
            System.out.println("Sou CarloBon, comandant de les legions catalanes destinades a conquerir el món. Esteu sota\n" +
                    "el mandat de l’emperador RafaFer conegut arreu per la seva bondat i la seva estimació cap el\n" +
                    "poble. CarloBon és un home íntegre per a qui l’honor i la lleialtat són valors inqüestionables.\n" +
                    "L’emperador RafaFer te un hereu, en JordaJor que espera amb anhel algun dia ser el nou\n" +
                    "emperador Català. L’emperador RafaFer està malalt i vol deixar l’imperi a en CarloBon ja que\n" +
                    "serà el millor pel poble però.... En JordiJor s’assabenta de les seves intencions i assassina a\n" +
                    "en RafaFer quedant ell com a únic hereu de l’imperi. Tot seguit demana a les seves hostes\n" +
                    "eliminar sigil·losament a en CarloBon. Se t’emporten en mig d’un bosc i et malfereixen deixantte al \n +" +
                    "llinda de la mort. Mentre l’emperador JordiJor entra a la capital de l’imperi Català gloriós i\n" +
                    "triomfal... comença la seva tirania!.\n" +
                    "Han passat uns mesos i ja estàs plenament recuperat de les ferides ocasionades i el teu cor\n" +
                    "demana venjança. Et dirigeixes a la capital amb la idea de fer justícia i aconseguir matar a\n" +
                    "l’emperador per explicar al poble tota la veritat i quin era el desig del malaurat RafaFer.\n" +
                    "Et davant del seu Palau, només portes una cuirassa i entres sigil·losament per la finestra d'una de les \n" +
                    "habitacions...");

            jugador.setOnEstic(rooms[randomitzarSimple()].getNom()); // iniciem al jugador a l'habitacio "entrada"
            while (movJugador != "EXIT" && win == false) { // si el jugador introdueix "EXIT" per teclat o mata a en JordiJor el joc s'acaba

                accions();
            }
            System.out.println("Vols jugar un altre cop? (SI/NO)");
            again = controladorTeclat();
        }
        System.out.println("Gracies per jugar!");
    }

    // creem la array i coloquem on estaran totes les habitacions, amb tota la info dels paramentres ja introduida
    public static void crearMapa() {

        String roomRandomitzada;
        rooms[0] = new Room();
            rooms[0].setNom(roomRandomitzada = randomitzarRooms());
            rooms[0].setPortaNord(false);
            rooms[0].setPortaSud(true);
            rooms[0].setPortaEst(true);
            rooms[0].setPortaOest(false);
            rooms[0].setEscalaAqui(false);

        //roomRandomitzada = randomitzarRooms();
        rooms[1] = new Room();
            rooms[1].setNom(randomitzarRooms());
            rooms[1].setPortaNord(false);
            rooms[1].setPortaSud(true);
            rooms[1].setPortaEst(true);
            rooms[1].setPortaOest(true);
            rooms[1].setEscalaAqui(false);

        //roomRandomitzada = randomitzarRooms();
        rooms[2] = new Room();
            rooms[2].setNom(randomitzarRooms());
            rooms[2].setPortaNord(false);
            rooms[2].setPortaSud(true);
            rooms[2].setPortaEst(false);
            rooms[2].setPortaOest(true);
            rooms[2].setEscalaAqui(false);

        //roomRandomitzada = randomitzarRooms();
        rooms[3] = new Room();
            rooms[3].setNom(randomitzarRooms());
            rooms[3].setPortaNord(true);
            rooms[3].setPortaSud(true);
            rooms[3].setPortaEst(true);
            rooms[3].setPortaOest(false);
            rooms[3].setEscalaAqui(false);

        //roomRandomitzada = randomitzarRooms();
        rooms[4] = new Room();
            rooms[4].setNom(randomitzarRooms());
            rooms[4].setPortaNord(true);
            rooms[4].setPortaSud(true);
            rooms[4].setPortaEst(true);
            rooms[4].setPortaOest(true);
            rooms[4].setEscalaAqui(false);

        //roomRandomitzada = randomitzarRooms();
        rooms[5] = new Room();
            rooms[5].setNom(randomitzarRooms());
            rooms[5].setPortaNord(true);
            rooms[5].setPortaSud(true);
            rooms[5].setPortaEst(false);
            rooms[5].setPortaOest(true);
            rooms[5].setEscalaAqui(false);

        //roomRandomitzada = randomitzarRooms();
        rooms[6] = new Room();
            rooms[6].setNom(randomitzarRooms());
            rooms[6].setPortaNord(true);
            rooms[6].setPortaSud(false);
            rooms[6].setPortaEst(true);
            rooms[6].setPortaOest(false);
            rooms[6].setEscalaAqui(false);

        //roomRandomitzada = randomitzarRooms();
        rooms[7] = new Room();
            rooms[7].setNom(randomitzarRooms());
            rooms[7].setPortaNord(true);
            rooms[7].setPortaSud(false);
            rooms[7].setPortaEst(true);
            rooms[7].setPortaOest(true);
            rooms[7].setEscalaAqui(false);

        //String roomRandomitzada = randomitzarRooms();
        rooms[8] = new Room();
            rooms[8].setNom(randomitzarRooms());
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
            rooms[9].setEscalaAqui(false);

            descripcio();
            rooms[randomitzarSimple()].setEscalaAqui(true);
    }

    // creem l'array i coloquem els items dins d'ella amb tota la info dels items tmb.
    public static void  crearItems() {

        items[0] = new Item();
            items[0].setNom("ESPASA");
            items[0].setUsat(false);
            items[0].setDescripcio("Espassa màgica amb la que ens podrem defensar de possibles enemics i inclús\n" +
                    "poder-los atacar en els moments en els que calgui.");
            items[0].setOnEstic(rooms[randomitzarItems()].getNom());
            items[0].setPoderAgafar(true);

        items[1] = new Item();
            items[1].setNom("CLAU");
            items[1].setUsat(false);
            items[1].setDescripcio("La clau ens permetrà obrir certes portes del Palau. El problema es que sempre la\n" +
                    "trobarem a dalt d’algun moble i no hi arribarem tot sols.");
            items[1].setOnEstic(rooms[randomitzarItems()].getNom());
            items[1].setPoderAgafar(false);

        items[2] = new Item();
            items[2].setNom("ESCALAMA");
            items[2].setUsat(false);
            items[2].setDescripcio("doncs això.... una escala que ens permetrà accedir a objectes que estiguin elevats.");
            items[2].setOnEstic(rooms[randomitzarItems()].getNom());
            items[2].setPoderAgafar(true);

        items[3] = new Item();
            items[3].setNom("BOSADINERS");
            items[3].setUsat(false);
            items[3].setDescripcio("Una bossa de dines sempre ens pot ser d’utilitat per aconseguir coses...");
            items[3].setOnEstic(rooms[randomitzarItems()].getNom());
            items[3].setPoderAgafar(true);

        items[4] = new Item();
            items[4].setNom("NOTA1");
            items[4].setUsat(false);
            items[4].setDescripcio("PISTA: Per agafar la clau necessitaràs usar una ESCALA DE MA, la trobaràs en alguna d'aquestes habitacions.");
            items[4].setOnEstic(rooms[randomitzarItems()].getNom());
            items[4].setPoderAgafar(true);

        items[5] = new Item();
            items[5].setNom("NOTA2");
            items[5].setUsat(false);
            items[5].setDescripcio("PISTA: Per saber on esta l'escala per pujar al 2n pis, necessites subornar a la cuinera entregant-li una bossa de diners... ai lo dejo...");
            items[5].setOnEstic(rooms[randomitzarItems()].getNom());
            items[5].setPoderAgafar(true);
    }

    // creem l'array dels NPCs i els coloquem dins d'aquesta + tota la info dels mateixos
    public static void crearNPCs() {
        NPCs[0] = new NPC();
            NPCs[0].setNom("CUINERA");
            NPCs[0].setOnEstic("cuina");
            NPCs[0].setDonar(false);
            NPCs[0].setParlar("Cuinera: WASAAAAAAAAAAAAAA, sóc la cuinera, dame tol money si kere la info, otaku culiao");

        NPCs[1] = new NPC();
            NPCs[1].setNom("JORDIJOR");
            NPCs[1].setOnEstic(rooms[9].getNom());
            NPCs[1].setDonar(false);
            NPCs[1].setParlar("JordiJor: zzZZzZzzZzzZz... titis... zzZZzZZZzZzZZ...");
    }

    // mostrar per pantalla en quina habitació es troba el jugador


    // on es produeixen totes les accions que pot fer el jugador i les seves interactuacions amb Items i NPCs
    public static void accions() {

        int hiHaItemRoom;
        int hiHaItemJugador;
        int hiHaNPCsRoom;
        String movJugadorMayus;
        String itemADeixar;
        String verbMenu;

        for (int i = 0; i < capacitatRooms; i++) { // recorre l'array rooms
            if(jugador.getOnEstic() == rooms[i].getNom()) {

                System.out.println("________________________________________________________________________________________________________");
                System.out.println("Estas situat a l'habitació: " + jugador.getOnEstic());

                System.out.println("Descripció: " + rooms[i].getDescripcio()); // mostrem per pantalla la descripció de l'habitacio on esta situat el jugador
                hiHaItemRoom = itemsRoom(rooms[i].getNom()); // Mostra els Items que hi han en l'habitació actual
                hiHaItemJugador = itemsJugador(); // Mostra els Items que te el jugador a l'inventari
                hiHaNPCsRoom = NPCsRoom(rooms[i].getNom()); // Mostra els NPCs que hi ha a l'habitacio on esta el jugador

                if (soborn == true) { // controlar que es mostri o no la informació per pantalla d'on esta situada l'escala per pujar al 2n pis
                    for (int j = 0; j < capacitatRooms; j++) {
                        if (rooms[j].getEscalaAqui() == true) {
                            System.out.println("L'escala per pujar al 2n pis esta a l'habitació: " + rooms[j].getNom());
                        }
                    }
                }

                verbMenu = menuVerbs(); // menu on es pregunta el verb de l'accio que l'usuari vol realitzar

                switch (verbMenu) {
                    case "ANAR":

                        System.out.println("On et vols moure? NORTH, WEST, SOUTH, EAST, ESCALES | Per sortir del joc escriu EXIT)");

                        movJugadorMayus = controladorTeclat(); // controla que s'introdueixi les instruccions correctes, si no es així el programa avisa i orna a preguntar

                        moureJugador(movJugadorMayus); // moure el jugador d'habitació

                        break;
                    case "AGAFAR":

                        algoritmeAgafar(hiHaItemRoom); // si l'usuari decideix agafar un Item

                        break;
                    case "DEIXAR":

                        algoritmeDeixar(hiHaItemJugador); // si l'usuari decideix deixar un Item

                        break;
                    case "USAR":

                        algoritmeUsar(hiHaItemJugador); // si l'usuari decideix usar un Item

                        break;
                    case "INTERACTUAR":

                        algoritmeInteractuarNPC(hiHaNPCsRoom); // si l'usuari decideix Interactuar/Parlar/intercanviar amb un NPCs (excepte en JordiJor)

                        break;
                    case "LLEGIR":

                        algoritmeLlegir(hiHaItemJugador);

                        break;
                    default:
                        System.out.println("Aquesta instrucció no va aquí!!!!!!!");
                }
            }
        }
    }

    // Algoritme que mou l'usuari segons la direcció que indiqui
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
                   System.out.println("________________________________________________________________________________________________________");
                   System.out.println("No pots anar cap aquesta direcció.");
                } else {
                   System.out.println("________________________________________________________________________________________________________");
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
                    System.out.println("________________________________________________________________________________________________________");
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
                    System.out.println("________________________________________________________________________________________________________");
                    System.out.println("No pots anar cap aquesta direcció.");
                } else if(jugador.getOnEstic() == rooms[8].getNom()) {
                    jugador.setOnEstic(rooms[7].getNom());
                } else {
                    System.out.println("________________________________________________________________________________________________________");
                    System.out.println("No pots anar cap aquesta direcció.");
                }
                break;
            case "NORTH":
                if(jugador.getOnEstic() == rooms[3].getNom()) {
                    jugador.setOnEstic(rooms[0].getNom());
                } else if(jugador.getOnEstic() == rooms[4].getNom()) {
                    System.out.println("________________________________________________________________________________________________________");
                    System.out.println("No pots anar cap aquesta direcció.");
                } else if(jugador.getOnEstic() == rooms[5].getNom()) {
                    jugador.setOnEstic(rooms[2].getNom());
                } else if(jugador.getOnEstic() == rooms[6].getNom()) {
                    jugador.setOnEstic(rooms[3].getNom());
                } else if(jugador.getOnEstic() == rooms[7].getNom()) {
                    jugador.setOnEstic(rooms[4].getNom());
                } else if(jugador.getOnEstic() == rooms[8].getNom()) {
                    jugador.setOnEstic(rooms[5].getNom());
                } else {
                    System.out.println("________________________________________________________________________________________________________");
                    System.out.println("No pots anar cap aquesta direcció.");
                }
                break;
            case "ESCALES":
                for (int j = 0; j < capacitatRooms; j++) {
                    if (rooms[j].getEscalaAqui() == true) {
                        if(jugador.getOnEstic().equals(rooms[j].getNom())) {
                            if (soborn == true) { // controlem que es mostri la info o no de l'escala al segon pis
                                if (items[1].getOnEstic().equals(jugador.getNom())) { // controlem que el jugador tingui l'Item clau a l'inventari per poder accedir al 2n pis.
                                    jugador.setOnEstic(rooms[9].getNom());
                                } else {
                                    System.out.println("________________________________________________________________________________________________________");
                                    System.out.println("No tens la CLAU per accedir a aquesta habitació");
                                }
                            } else {
                                System.out.println("________________________________________________________________________________________________________");
                                System.out.println("No pots anar cap aquesta direcció. no soborn");
                            }
                        } else if(jugador.getOnEstic() == rooms[9].getNom()) {
                            for (int o = 0; o < capacitatRooms; o++) {
                                if (rooms[o].getEscalaAqui() == true) {
                                    jugador.setOnEstic(rooms[o].getNom());
                                    o = capacitatRooms;
                                }
                            }

                        } else {
                            System.out.println("________________________________________________________________________________________________________");
                            System.out.println("No pots anar cap aquesta direcció. No entra al primer if");
                        }
                    }
                }

                break;
            default:
                System.out.println("Aquesta instrucció no va aquí!!!!!!!");
        }
    }

    // pregunta per l'accio
    public static String menuVerbs() {
        String verbMenu;
        System.out.println("Quina acció vols fer? (ANAR/DEIXAR/AGAFAR/USAR/INTERACTUAR/LLEGIR)");
        verbMenu = controladorTeclat(); //controla que la instruccio introduida sigui la correcte, si no ho es, torna a preguntar

        return verbMenu;
    }

    //llista per pantalla els items que hi ha en l'habitacio on el jugador esta situat
    public static int itemsRoom(String nomRoom) {
        int numItems = 0;

        System.out.println("Items de l'habitació: ");

        for (int i = 0; i < items.length; i++) {
            if (items[i].getOnEstic() == nomRoom) {
                System.out.print("| " + items[i].getNom() + " | ");
                numItems++;
            }
        }
        System.out.println();
        return numItems;
    }

    //llista per pantalla els items que te el jugador a l'inventari
    public static int itemsJugador() {
        int numItems = 0;

        System.out.println("Items de l'inventari: ");

        for (int i = 0; i < items.length; i++) {
            if (items[i].getOnEstic() == jugador.getNom()) {
                System.out.print("| " + items[i].getNom() + " | ");
                numItems++;
            }
        }
        System.out.println();
        return numItems;
    }

    //llista per pantalla els NPCs de l'habitacio on esta situat l'usuari
    public static int NPCsRoom(String nomRoom) {
        int numNPCs = 0;

        System.out.println("NPCs de l'habitació: ");

        for (int i = 0; i < NPCs.length; i++) {
            if (NPCs[i].getOnEstic() == nomRoom) {
                System.out.print("| " + NPCs[i].getNom() + " | ");
                numNPCs++;
            }
        }
        System.out.println();
        return numNPCs;
    }

    // controla els Strings introduits per l'usuari a traves d'una classe externa (PASSARMAYUS i CARACTERCORRECTE)
    public static String controladorTeclat() {
        boolean caracterIncorrecte = true;

        String movJugadorMayus = "";

        while (caracterIncorrecte == true) {
            movJugador = teclat.next();
            teclat.nextLine();

            movJugadorMayus = toMayus.cadenaAMayus(movJugador);// Canvia les lletres a Mayus de tot l'String
            caracterIncorrecte = cc.controladorTeclat(movJugadorMayus); // Controla que l'instrucció sigui correcte
        }

        return movJugadorMayus;
    }

    public static void algoritmeAgafar(int hiHaItemRoom) {
        String itemAAgafar;

        if (hiHaItemRoom > 0) { // controla si hi han items a l'habitacio
            System.out.println("Quin Item de l'habitació vols agafar?");
            itemAAgafar = controladorTeclat(); //control de String
            for (int i = 0; i < capacitatItems; i++) {
                for (int j = 0; j < capacitatRooms; j++) {
                    if (itemAAgafar.equals(items[i].getNom()) && items[i].getOnEstic().equals(rooms[j].getNom())) {// controlem que l'String sigui igual a l'item i l'usuari estigui en l'habitacio on esta l'item
                        if (items[i].getPoderAgafar() == true) { //controlem si es necessita una escala de ma per agafar l'item i si tenim o no aquesta
                            items[i].setOnEstic(jugador.getNom());
                            i = capacitatItems; //forçem l'end del for
                            j = capacitatRooms; //forçem l'end del for
                            System.out.println("________________________________________________________________________________________________________");
                            System.out.println("He agafat l'Item i l'he guardat a l'inventari");
                        } else {
                            System.out.println("________________________________________________________________________________________________________");
                            System.out.println("Per agafar aquest Item necessites Usar una escala de má");
                        }
                    }
                }
            }
        } else {
            System.out.println("________________________________________________________________________________________________________");
            System.out.println("No pots fer aquesta acció perque no hi han Items a l'habitació o no hi arribes (necessites l'escala de má)");
        }
    }

    public static void algoritmeDeixar(int hiHaItemJugador) {
        String itemADeixar;

        if (hiHaItemJugador > 0) { // controla si hi han items a l'inventari
            System.out.println("Quin Item de l'Inventari vols deixar en aquesta habitació");
            itemADeixar = controladorTeclat(); //control de String
            for (int i = 0; i < capacitatItems; i++) {
                if (itemADeixar.equals(items[i].getNom()) && items[i].getOnEstic().equals(jugador.getNom())) { // controlem que l'String sigui igual a l'item i que l'usuari tingui realment aquest Item a l'inventari
                    items[i].setOnEstic(jugador.getOnEstic());
                    i = capacitatItems; //forçem l'end del for
                    System.out.println("________________________________________________________________________________________________________");
                    System.out.println("He deixat l'item de l'inventari en aquesta habitació");
                }
            }

        } else {
            System.out.println("________________________________________________________________________________________________________");
            System.out.println("No pots fer aquesta acció perque no tens Items L'INVENTARI");
        }
    }

    public static void algoritmeUsar(int hiHaItemJugador) {
        String itemAUsar;

        if (hiHaItemJugador > 0) { // controla si hi han items a l'inventari
            System.out.println("Quin Item de l'Inventari vols usar?");
            itemAUsar = controladorTeclat(); //control de String
            for (int i = 0; i < capacitatItems; i++) {
                if (itemAUsar.equals(items[i].getNom()) && items[i].getOnEstic().equals(jugador.getNom())) { // controlem que l'String sigui igual a l'item i que l'usuari tingui realment aquest Item a l'inventari
                    if (jugador.getOnEstic().equals(items[1].getOnEstic()) && itemAUsar.equals("ESCALAMA")) { // controlem que si la clau esta a la mateixa habitacio que el jugador i que per aplicar l'algoritme de escala, l'usuari hagi indicat que l'item a usar sigui exactament ESCALA DE MA
                        items[1].setPoderAgafar(true);
                        System.out.println("________________________________________________________________________________________________________");
                        System.out.println("He colocat l'escala de má.");
                        i = capacitatItems; //forçem l'end del for
                    } else if (jugador.getOnEstic().equals(NPCs[1].getOnEstic()) && itemAUsar.equals("ESPASA")) { // controlem que l'NPC JordiJor esta a la mateixa habitacio que el jugador i que per aplicar l'algoritme matar-lo, l'usuari hagi indicat que l'item a usar sigui exactament ESPASA
                        System.out.println("________________________________________________________________________________________________________");
                        System.out.println("T'apropes sigilosament...");
                        System.out.println(NPCs[1].getParlar());
                        System.out.println("Usas l'espasa contra en JordiJor i el mates");
                        System.out.println("VICTORY, WINNER WINNER, CHICKEN DINNER");
                        i = capacitatItems; //forçem l'end del for
                        win = true; // aixo provoca l'aturada del bucle que continua amb la partida actual
                    } else {
                        System.out.println("________________________________________________________________________________________________________");
                        System.out.println("No pots usar aquest Item aquí");
                    }
                }
            }

        } else {
            System.out.println("________________________________________________________________________________________________________");
            System.out.println("No pots fer aquesta acció perque no tens Items L'INVENTARI");
        }
    }

    public static void algoritmeInteractuarNPC(int hiHaNPCsRoom) {
        String NPCAParlar;

        if (hiHaNPCsRoom > 0) { // controla si hi han items a l'habitacio
            System.out.println("Amb quin NPC vols Interactuar?");
            NPCAParlar = controladorTeclat();
            for (int i = 0; i < capacitatNPCs; i++) {
                for (int j = 0; j < capacitatRooms; j++) {
                    if (NPCAParlar.equals(NPCs[i].getNom()) && NPCs[i].getOnEstic().equals(rooms[j].getNom())) {
                        System.out.println("________________________________________________________________________________________________________");
                        System.out.println(NPCs[i].getParlar());

                        if (items[3].getOnEstic().equals(jugador.getNom())) {
                            items[3].setOnEstic(NPCs[i].getNom());
                            System.out.println("________________________________________________________________________________________________________");
                            System.out.println("Li has donat la bosa de diners a la cuinera, a canvi de la informacio d'on esta situada l'escala per pujar al 2n pis.");
                            soborn = true; // confirmem que s'ha entregat els diners a la cuinera i ara estigui habilitada la info d'on esta l'escala del 2n pis i que s'hi pugui accedir.
                        }

                        i = capacitatNPCs; //forçem l'end del for
                        j = capacitatRooms; //forçem l'end del for
                    }
                }
            }
        } else{
            System.out.println("________________________________________________________________________________________________________");
            System.out.println("No pots fer aquesta acció perque no hi han ningun NPC a l'habitació");
        }
    }

    // depenent de quina nota vol llegir es mostrara el contingut d'aquesta, en cas de que la tingui a l'inventari
    public static void algoritmeLlegir(int hiHaItemJugador) {
        String itemAUsar;

        if (hiHaItemJugador > 0) { // controla si hi han items a l'inventari
            System.out.println("Quina Nota  vols llegir?");
            itemAUsar = controladorTeclat(); //control de String
            for (int i = 0; i < capacitatItems; i++) {
                if (itemAUsar.equals(items[i].getNom()) && items[i].getOnEstic().equals(jugador.getNom())) { // controlem que l'String sigui igual a l'item i que l'usuari tingui realment aquest Item a l'inventari
                        System.out.println("________________________________________________________________________________________________________");
                        System.out.println(items[i].getDescripcio());
                        i = capacitatItems; //forçem l'end del for
                }
            }
        } else {
            System.out.println("________________________________________________________________________________________________________");
            System.out.println("No pots fer aquesta acció perque no tens ninguna Nota a L'INVENTARI");
        }
    }

    // Aquest algoritme de randomització sense repeticions està explicat 1 mètode més cap abaix
    public static int randomitzarItems() {
        int numArrayAleatoriItems = 0;
        int comptador = 0;

        while (comptador != capacitatItems) {
            numArrayAleatoriItems = (int) (Math.random()*8+0);
            comptador = 0;
            for (int i = 0; i < ItemsRandom.length; i++) {
                if (ItemsRandom[i] != numArrayAleatoriItems) {
                    comptador++;
                }
            }
        }
            ItemsRandom[properaLliureItems] = numArrayAleatoriItems;
            properaLliureItems++;


        return numArrayAleatoriItems;
    }

    // Randomització sense repetició per l'array de les habitacions (by: mi solito jeje)
    public static String randomitzarRooms() {
        int numArrayAleatoriItems = 0;
        int comptador = 0;
        String nomRoomAleatori ="";

        while (comptador != 9) {
            numArrayAleatoriItems = (int) (Math.random()*9+0); // num aleatori entre 0 i 9
            nomRoomAleatori = nomRooms[numArrayAleatoriItems]; // El num random és la posició de l'array que conte tots els noms de les habitacions aleatori entre 0 i 9
            comptador = 0; // Inicialitzem el comptador a 0 perquè així s'aprofiti quer a cada volta

            // Bàsicament el que es fa aquí es del nom que s'ha agafat aleatòriament de l'array "nomRooms", comprovem que no estigui repetit dins l'array de repeticions, si només 1 cop el nom està repetit el comptador -->
                // --> no sumarà i el bucle es repetirà agafant un altre nom aleatori, així fins que tovi un nom que no estigui repetit
            for (int i = 0; i < RoomsRandom.length; i++) {
                if (RoomsRandom[i] != nomRoomAleatori) {
                    comptador++;
                }
            }
        }

        // Un cop trobat el nom i comprovat que no estigui repetit l'introduïm dins l'array per saber en un futur que es necessiti buscar un nou nom aquest no estigui repetit i no hi hagi 2 sales amb el mateix nom
        RoomsRandom[properaLliureRooms] = nomRoomAleatori;
        properaLliureRooms++;


        return nomRoomAleatori; // Retornem el nom de l'habitació, cercat aleatòriament
        // Cosecha pròpia (5 hores, seguides molt dures de procés mental per arribar a aquesta solució (+ 1 h més de corregir bugs), satisfet, no, el següent :)
    }

    // randomització simple
    public static int randomitzarSimple() {
        int numArrayAleatoriItems = 0;

            numArrayAleatoriItems = (int) (Math.random()*8+0); // num aleatori entre 0 i 8

        return numArrayAleatoriItems; // retorna un numero aleatori que sera la posicio de l'array
    }

    // descripcions de totes les habitacions
    public static void descripcio() {
        for (int i = 0; i < capacitatRooms; i++) {
            if (rooms[i].getNom().equals("cuina")) {
                rooms[i].setDescripcio("Un espai molt gran, ple d'eines per cuinar i plats amb una pinta deliciosa a punt de ser servits, digne d'un palau com aquest... GRRRRRRRRRRR... hem sona la panxa del bé que olora aquí. Per algun motiu, crec que la cuinera està disposada a fer algun tipus de pacte");
            } else if (rooms[i].getNom().equals("magatzem")) {
                rooms[i].setDescripcio("Moltes caixes hi ha aquí, molts trastos... molta pols també... AAAAAAACHÍS... sniff...");
            } else if (rooms[i].getNom().equals("menjador")) {
                rooms[i].setDescripcio("Aquí hi ha molta gent, més em val mourem sigil·losament, si em detecten, GAME OVER, així que al lorete... quina pinta tenen els plats de menjar... quina gana.");
            } else if (rooms[i].getNom().equals("bany")) {
                rooms[i].setDescripcio("QUINA PUDOR QUE FOT HOSTIA, amb el jala que s'estan fotent al menjador, millor que no quedar-se molta estona per aquí...");
            } else if (rooms[i].getNom().equals("sala")) {
                rooms[i].setDescripcio("Carai, quina llar de foc més gran i quines butaques més còmodes, donen ganes d'encendre-la i posar-se a dormir una bona estona... zzzZZZzzz...");
            } else if (rooms[i].getNom().equals("caballerisses")) {
                rooms[i].setDescripcio("Quin tufo a merda que fot aquí, els cavalls dels nassos, ja podrien netejar més de seguit aquest lloc...");
            } else if (rooms[i].getNom().equals("ball")) {
                rooms[i].setDescripcio("Quin lloc més gran, sembla broma que estiguem en un espai tancat... sembla que estan preparant algun tipus d'esdeveniment important amb gent important, home no, estem en un palau, òbviament seran persones importants, sóc subnormal...");
            } else if (rooms[i].getNom().equals("entrada")) {
                rooms[i].setDescripcio("Aquesta sala té una porta gegant, podria entrar un Brontosaurio i tot... JOOOODER, però hi ha bastant de corrent d'aire...");
            } else if (rooms[i].getNom().equals("gym")) {
                rooms[i].setDescripcio("Sembla que en JordiJor estigui tan gras, amb la maquinària de fer exercici físic que hi ha aquí muntada");
            } else if (rooms[i].getNom().equals("habJordiJor")) {
                rooms[i].setDescripcio("Habitació principal, on dorm l'emperador... perfecte, està dormint en aquest moment, amb l'espasa sagrada mel carrego instantani.");
            }
        }
    }

}
