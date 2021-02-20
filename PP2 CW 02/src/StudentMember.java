import java.util.Scanner;

public class StudentMember extends DefaultMember {

    Scanner student = new Scanner(System.in);

    String school;

    public void setSchool() {
        System.out.println("Please enter your school name  -: ");
        this.school = student.next();
        while (true) {
            try {
                Integer.parseInt(this.school);
                System.out.println("Invalid input... Please check and enter your input correctly  -: ");
                this.school = student.next();
            }catch (Exception exception) {
                break;
            }
        }
    }

    public String getSchool() {return school;}

}
