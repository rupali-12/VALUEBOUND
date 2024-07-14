// src/services/ReservationService.java

package services;

import models.Reservation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private List<Reservation> reservations;

    public ReservationService() {
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void updateReservation(int index, Reservation reservation) {
        if (index >= 0 && index < reservations.size()) {
            reservations.set(index, reservation);
        }
    }

    public void deleteReservation(int index) {
        if (index >= 0 && index < reservations.size()) {
            reservations.remove(index);
        }
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }

    public void saveReservationsToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(reservations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadReservationsFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            reservations = (List<Reservation>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
