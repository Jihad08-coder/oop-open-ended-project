/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicmanagementsystem;



import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private int id;
    private List<Appointment> appointments;

    public Patient(String name, int id) {
        this.name = name;
        this.id = id;
        this.appointments = new ArrayList<>();
    }

    public void register() {
        System.out.println("Patient " + name + " registered with ID " + id);
    }

    public void bookAppointment(Doctor doctor, String date, String time) {
        if (doctor != null && date != null && time != null) {
            Appointment appointment = new Appointment(date, time, doctor, this);
            appointments.add(appointment);
            appointment.saveToFile();
        } else {
            System.out.println("Error: Invalid doctor, date, or time.");
        }
    }

    public String getName() {
        return name;
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for " + name);
        } else {
            System.out.println("Appointments for " + name + ":");
            for (Appointment appointment : appointments) {
                System.out.println(" - " + appointment.getDetails());
            }
        }
    }
}
