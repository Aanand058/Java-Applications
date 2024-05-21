/**********************************************
Workshop 4&5
Course:APD545 -5th Semester
Last Name:Aman
First Name:Aanand
ID:166125211
Section:ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:2024/03/26
**********************************************/


package model;

public class InHouse extends Part {
    private int machineId;

    // Constructor
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    // Setter method for machineId
    public void setMachine(int machineId) {
        this.machineId = machineId;
    }

    // Getter method for machineId
    public int getMachine() {
        return machineId;
    }
}
