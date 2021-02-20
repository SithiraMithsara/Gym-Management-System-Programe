import java.util.Scanner;

public class Over60Member extends DefaultMember {

    Scanner over_60 = new Scanner(System.in);

    int age;

    public void setAge() {
        System.out.println("Please enter your age  -: ");
        while (true) {
            try {
                Integer.parseInt(String.valueOf(this.age));
                this.age = over_60.nextInt();
                break;
            } catch (Exception exception) {
                System.out.println("Invalid input... Please check and enter correct age  -: ");

            }
        }
    }

    public int getAge() {return age;}
}
