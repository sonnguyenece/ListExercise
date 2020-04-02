package Class;

import java.util.Scanner;

public class Student extends Person {
    private String studentID;
    private float avgScore;
    private String email;
    public Scanner scn = new Scanner(System.in);

    public Student() {

    }

    public Student(String name, boolean gender, String address, String dateOfBirth,
                   String studentID, float avgScore, String email) {
        super(name, gender, address, dateOfBirth);
        this.avgScore = avgScore;
        this.email = email;
        this.studentID = studentID;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentID() {
        return studentID;
    }

    public boolean isGetReward() {
        return this.avgScore >= 8.0;
    }

    public String getReward(){
        if (isGetReward())return "Yes";
        else return "No";
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.print("StudentID : ");
        this.studentID = scn.nextLine();
        System.out.print("AVG Score : ");
        this.avgScore = scn.nextFloat();
        scn.nextLine();
        System.out.print("Email : ");
        this.email = scn.nextLine();
    }

    @Override
    public void display() {
        if (isGetReward())
            System.out.printf("Name: %-20s Gender: %-10s Adds: %-20s Birth: %-10s StudentID: %-10s AVG Score: %-5.2f Email: %-20s Get Reward : yes",
                    super.getName(), super.getStringGender(), super.getAddress(), super.getDateOfBirth(), this.studentID, this.avgScore, this.email);
        else
            System.out.printf("Name: %-20s Gender: %-10s Adds: %-20s Birth: %-10s StudentID: %-10s AVG Score: %-5.2f Email: %-20s Reward : no",
                    super.getName(), super.getStringGender(), super.getAddress(), super.getDateOfBirth(), this.studentID, this.avgScore, this.email);
    }

    @Override
    public String toString() {
        return "Student name: " + super.getName() +
                " Gender: " + super.getStringGender() +
                " Address: " + super.getAddress() +
                " Birth: " + super.getDateOfBirth() +
                " StudentID: " + studentID +
                " AvgScore: " + avgScore +
                " Email: " + email +
                " Reward: " + (isGetReward() ? " yes" : " no");
    }
}
