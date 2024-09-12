
package com.mycompany.clinicmanagementsystem;



import java.io.FileWriter;
import java.io.IOException;

public class Appointment {
    private String date;
    private String time;
    private Doctor doctor;
    private Patient patient;

    public Appointment(String date, String time, Doctor doctor, Patient patient) {
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("appointments.txt", true)) {
            writer.write("Appointment on " + date + " at " + time + " with Dr. " + doctor.getName() +
                         " for patient " + patient.getName() + "\n");
            System.out.println("Appointment saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public String getDetails() {
        return "Appointment on " + date + " at " + time + " with Dr. " + doctor.getName() + " (" + doctor.getSpecialization() + ")";
    }
}
