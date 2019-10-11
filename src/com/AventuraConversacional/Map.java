package com.AventuraConversacional;

public class Map {
    private String nom = "";
    private Room []roomList;



    public void instanciarObjsRooms() {
        Room cuina = new Room();
        Room magatzem = new Room();
        Room menjador = new Room();
        Room bany = new Room();
        Room sala = new Room();
        Room caballerisses = new Room();
        Room entrada = new Room();
        Room ball = new Room();
        Room cuina = new Room();
        Room habJordiJor = new Room();
    }

    public String getNom() {
        return nom;
    }

    public Room[] getRoomList() {
        return roomList;
    }
}
