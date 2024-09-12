/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clinicmanagementsystem;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicManagementSystem {
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeDoctors();
        boolean running = true;

        while (running) {
            System.out.println("------ Clinic Management System ------");
            System.out.println("1. Book an appointment");
            System.out.println("2. View a patient's appointments");
            System.out.println("3. View doctor list");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookAppointment(scanner);
                    break;
                case 2:
                    viewPatientAppointments(scanner);
                    break;
                case 3:
                    viewDoctorList();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeDoctors() {
        doctors.add(new GeneralPractitioner("Dr. khan", "General Medicine"));
        doctors.add(new Specialist("Dr. Rakib Ahsan", "Cardiology"));
        doctors.add(new GeneralPractitioner("Dr. shirin Akter", "Pediatrics"));
        doctors.add(new Specialist("Dr. Sadia Sharmin", "Neurology"));
    }

    private static void bookAppointment(Scanner scanner) {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        int patientID = patients.size() + 1;
        Patient patient = new Patient(name, patientID);
        patients.add(patient);
        
        System.out.println("your paitient reg_ID:"+patientID);

        System.out.println("Available doctors: ");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getName() + " - " + doctors.get(i).getSpecialization());
        }

        System.out.print("Enter the number of the doctor you want to book: ");
        int doctorIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (doctorIndex >= 0 && doctorIndex < doctors.size()) {
            Doctor doctor = doctors.get(doctorIndex);
            System.out.print("Enter appointment date and time (e.g., 2024-09-10 12:00): ");
            String dateTime = scanner.nextLine();
            patient.bookAppointment(doctor, dateTime, "12:00");
        } else {
            System.out.println("Invalid doctor selection.");
        }
    }

    private static void viewPatientAppointments(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        int patientID = scanner.nextInt();

        if (patientID > 0 && patientID <= patients.size()) {
            Patient patient = patients.get(patientID - 1);
            patient.viewAppointments();
        } else {
            System.out.println("Invalid patient ID.");
        }
    }

    private static void viewDoctorList() {
        System.out.println("Doctors available at the clinic:");
        for (Doctor doctor : doctors) {
            doctor.displayAvailability();
        }
    }
}
