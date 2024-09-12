
package com.mycompany.clinicmanagementsystem;



public class Specialist extends Doctor {
    public Specialist(String name, String specialization) {
        super(name, specialization);
    }

    @Override
    public void displayAvailability() {
        System.out.println(getName() + " requires appointment confirmation.");
    }
}
