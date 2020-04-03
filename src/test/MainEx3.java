package test;

import Class.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEx3 {
    public static void main(String[] args) {
        ArrayList<Object> studentsList = initList();
        init(studentsList);
    }

    public static void init(ArrayList<Object> studentsList) {
        int selection;
        do {
            Scanner scn = new Scanner(System.in);
            System.out.println("Input a number follow the selection list below : ");
            System.out.println("1.Display student List");
            System.out.println("2.Add a student");
            System.out.println("3.Edit student's info by ID");
            System.out.println("4.Edit student's info by name");
            System.out.println("5.Delete student's info by ID");
            System.out.println("6.Search by name");
            System.out.println("7.Search by ID");
            System.out.println("8.Display students get reward");
            System.out.println("9.Display female student");
            System.out.println("0.Exit");
            System.out.print("Input your choice: ");
            selection = scn.nextInt();
            System.out.println();

            switch (selection) {
                case 1:
                    displayList(studentsList);
                    System.out.println("\n");
                    break;
                case 2:
                    addNewStudent(studentsList);
                    System.out.println("\n");
                    break;
                case 3:
                    editInfoByID(studentsList);
                    System.out.println();
                    break;
                case 4:
                    editInfoByName(studentsList);
                    System.out.println();
                    break;
                case 5:
                    deleteInfoWithID(studentsList);
                    System.out.println("\n");
                    break;
                case 6:
                    findByName(studentsList);
                    System.out.println("\n");
                    break;
                case 7:
                    findByID(studentsList);
                    System.out.println("\n");
                    break;
                case 8:
                    displayRewardStudent(studentsList);
                    System.out.println("\n");
                    break;
                case 9:
                    femaleStudentList(studentsList);
                    System.out.println("\n");
                    break;

            }
        } while (selection != 0);
    }

    public static ArrayList<Object> initList() {
        ArrayList<Object> studentsList = new ArrayList<Object>();
        Student student1 = new Student("Nguyen Minh Son", true, "Thanh Xuan", "07/01/1994",
                "C0220H1", 8.1f, "sonnguyenece@gmail.com");
        Student student2 = new Student("Gordon Freeman", true, "USA",
                "07/11/1987", "BM1236", 10.0f, "gordonFreeman@gmail.com");
        Student student3 = new Student("Alyx", false, "USA",
                "05/06/1990", "CT12336", 7.0f, "alyx@gmail.com");
        Student student4 = new Student("Gordon Freeman", true, "USA",
                "07/11/1987", "BM1237", 3.0f, "gordon@gmail.com");
        Student student5 = new Student("Thuy Kieu", false, "China",
                "07/11/1987", "CV1237", 3.0f, "kieucv@gmail.com");
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);
        return studentsList;
    }

    public static void displayList(ArrayList studentList) {
        System.out.printf("STT%6sName%8sGender%5sAddress%6sBirth%7sStudentID%2sAVG%5sEmail%17sReward", "", "", "", "", "", "", "", "");
        Student[] std = new Student[100];
        for (int i = 0; i < studentList.size(); i++) {
            std[i] = (Student) studentList.get(i);
            System.out.println();
            System.out.printf("%2d   %-17s%-10s%-12s%-14s%-10s%-5s%-26s%-5s "
                    , (i + 1), std[i].getName(), std[i].getStringGender(), std[i].getAddress(), std[i].getDateOfBirth(), std[i].getStudentID(), std[i].getAvgScore(), std[i].getEmail(), std[i].getReward());
        }
    }

    public static void addNewStudent(ArrayList studentList) {
        Student std = new Student();
        std.inputInfo();
        studentList.add(std);
    }

    public static void editInfoByID(ArrayList studentList) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Input Student ID need to edit:");
        String inputID = scn.next();
        Student[] std = new Student[100];
        for (int i = 0; i < studentList.size(); i++) {
            std[i] = (Student) studentList.get(i);
            if ((std[i].getStudentID()).equals(inputID)) {
                std[i].inputInfo();
                return;
            }
        }
        System.out.print("ID doesn't exist!");
    }

    public static void editInfoByName(ArrayList studentList) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Input (full) name need to edit :");
        String inputName = scn.nextLine();
        Student[] std = new Student[100];
        int temp = 0;
        for (int i = 0; i < studentList.size(); i++) {
            std[i] = (Student) studentList.get(i);
            if ((std[i].getName()).equals(inputName)) {
                temp++;
                System.out.println("Edit " + std[i].getName() + " ID:" + std[i].getStudentID());
                std[i].inputInfo();
            }
            if (i == studentList.size() - 1 && temp == 0) System.out.println("Can't find that name");
        }

    }

    public static void deleteInfoWithID(ArrayList studentList) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Input student ID need to delete:");
        String inputID = scn.next();
        Student[] std = new Student[100];
        for (int i = 0; i < studentList.size(); i++) {
            std[i] = (Student) studentList.get(i);
            if ((std[i].getStudentID()).equals(inputID)) {
                studentList.remove(std[i]);
                return;
            }
        }
        System.out.println("ID doesn't exist!");
    }

    public static void findByName(ArrayList studentList) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Input (full) student's name: ");
        String inputName = scn.nextLine();
        Student[] std = new Student[100];
        int temp = 0;
        for (int i = 0; i < studentList.size(); i++) {
            std[i] = (Student) studentList.get(i);
            if ((std[i].getName()).equals(inputName)) {
                temp++;
                if (temp == 1) {
                    System.out.printf("STT%6sName%8sGender%5sAddress%6sBirth%7sStudentID%2sAVG%5sEmail%17sReward", "", "", "", "", "", "", "", "");
                }
                System.out.println();
                System.out.printf("%2d   %-17s%-10s%-12s%-14s%-10s%-5s%-26s%-5s "
                        , (i + 1), std[i].getName(), std[i].getStringGender(), std[i].getAddress(), std[i].getDateOfBirth(), std[i].getStudentID(), std[i].getAvgScore(), std[i].getEmail(), std[i].getReward());
            }
            if (i == studentList.size() - 1 && temp == 0) System.out.println("ID doesn't exist!");
        }

    }

    public static void findByID(ArrayList studentList) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Input student's ID: ");
        String inputID = scn.nextLine();
        Student[] std = new Student[100];
        for (int i = 0; i < studentList.size(); i++) {
            std[i] = (Student) studentList.get(i);
            if ((std[i].getStudentID()).equals(inputID)) {
                System.out.printf("STT%6sName%8sGender%5sAddress%6sBirth%7sStudentID%2sAVG%5sEmail%17sReward", "", "", "", "", "", "", "", "");
                System.out.println();
                System.out.printf("%2d   %-17s%-10s%-12s%-14s%-10s%-5s%-26s%-5s "
                        , (i + 1), std[i].getName(), std[i].getStringGender(), std[i].getAddress(), std[i].getDateOfBirth(), std[i].getStudentID(), std[i].getAvgScore(), std[i].getEmail(), std[i].getReward());
                return;
            }
        }
        System.out.println("ID doesn't exist!");
    }

    public static void displayRewardStudent(ArrayList studentList) {

        Student[] std = new Student[100];
        int temp = 0;
        for (int i = 0; i < studentList.size(); i++) {
            std[i] = (Student) studentList.get(i);
            if (std[i].isGetReward()) {
                temp++;
                if (temp == 1) {
                    System.out.printf("STT%6sName%8sGender%5sAddress%6sBirth%7sStudentID%2sAVG%5sEmail%17sReward", "", "", "", "", "", "", "", "");
                }
                System.out.println();
                System.out.printf("%2d   %-17s%-10s%-12s%-14s%-10s%-5s%-26s%-5s "
                        , (i + 1), std[i].getName(), std[i].getStringGender(), std[i].getAddress(), std[i].getDateOfBirth(), std[i].getStudentID(), std[i].getAvgScore(), std[i].getEmail(), std[i].getReward());
            }
            if (i == studentList.size() - 1 && temp == 0) System.out.println("No one can get the reward!");
        }
    }

    public static void femaleStudentList(ArrayList studentList) {

        Student[] std = new Student[100];
        int temp = 0;
        for (int i = 0; i < studentList.size(); i++) {
            std[i] = (Student) studentList.get(i);
            if (!std[i].isGender()) {
                temp++;
                if (temp == 1) {
                    System.out.printf("STT%6sName%8sGender%5sAddress%6sBirth%7sStudentID%2sAVG%5sEmail%17sReward", "", "", "", "", "", "", "", "");
                }
                System.out.println();
                System.out.printf("%2d   %-17s%-10s%-12s%-14s%-10s%-5s%-26s%-5s "
                        , (i + 1), std[i].getName(), std[i].getStringGender(), std[i].getAddress(), std[i].getDateOfBirth(), std[i].getStudentID(), std[i].getAvgScore(), std[i].getEmail(), std[i].getReward());
            }
            if (i == studentList.size() - 1 && temp == 0) System.out.print("No lady no funny!");
        }

    }
}
