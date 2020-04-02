package Class;

import java.util.Scanner;

public class Person {
    private String name;
    private boolean gender;
    private String address;
    private String dateOfBirth;
    public Scanner scn = new Scanner(System.in);
    public Person() {

    }

    public Person(String name, boolean gender, String address, String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getStringGender() {
        if (gender) return "male";
        else return "female";
    }

    public boolean isGender() {
        return gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public void inputInfo(){

        System.out.println("Input person info ");
        System.out.print("Name : ");
        this.name = scn.nextLine();
        System.out.print("Gender (male input true,female input false): ");
        this.setGender(scn.nextBoolean());
        scn.nextLine();
        System.out.print("Address: ");
         this.address = scn.nextLine();
        System.out.print("Date of Birth : ");
         this.dateOfBirth = scn.nextLine();
    }

    public void display() {
        System.out.printf("Name: %-20s Gender: %-10s Adds: %-20s Birth: %-10s", this.name, this.getStringGender(), this.address, this.dateOfBirth);
    }
}
