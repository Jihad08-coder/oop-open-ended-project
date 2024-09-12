/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicmanagementsystem;



public class GeneralPractitioner extends Doctor {
    public GeneralPractitioner(String name, String specialization) {
        super(name, specialization);
    }

    @Override
    public void displayAvailability() {
        System.out.println(getName() + " is available for walk-ins.");
    }
}
