import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.io.IOException;
import java.util.Scanner;

public class MyGymManager {

    public static MongoClient mongoClient = new MongoClient("localhost", 27017);
    public static MongoDatabase database = mongoClient.getDatabase("gymDatabase");

    public static void main(String[] args) throws IOException {

        while (true) {
            if (database.getCollection("gymMember") == null) {
                database.createCollection("gymMember");
            }

            MongoCollection<Document> input = database.getCollection("gymMember");

            Scanner gym = new Scanner(System.in);

            System.out.println("********************Gym Management System*******************");
            System.out.println();
            System.out.println("Enter number 01 to Add a new member");
            System.out.println("Enter number 02 to Sort the items in a order");
            System.out.println("Enter number 03 to Print the list of members");
            System.out.println("Enter number 04 to Open the member list in GUI");
            System.out.println("Enter number 09 to Delete a member");
            System.out.println("Enter number 00 to Exit the programme");
            System.out.println("");

            int maximum = 0;

            int choice = gym.nextInt();
            if (choice == 1) {
                if (maximum >= 100) {
                    System.out.println();
                }
            }

            System.out.println("You entered number " + choice);
            System.out.println("------------------------------");

            if (choice == 1) {
                System.out.println("**********Add a new member**********");
                System.out.println("If you are Student Member please enter 01");
                System.out.println("If you are a Over60Member please enter 02");
                System.out.println("If you are a Default member please enter 03");

                int select = gym.nextInt();

                if (select == 1) {
                    System.out.println("Student Member");
                    StudentMember student_member = new StudentMember();
                    student_member.setMemberID();
                    student_member.setfstName();
                    student_member.setlstName();
                    student_member.setaddress();
                    student_member.setSchool();
                    Date date = new Date();
                    date.setStartingDate();
                    student_member.setDefaultdate(date.getStartingDate());

                    Document details = new Document();
                    details.put("Member ID", student_member.getMemberID());
                    details.put("First name", student_member.getfName());
                    details.put("Last name", student_member.getlName());
                    details.put("Address", student_member.getaddress());
                    details.put("School", student_member.getSchool());
                    details.put("Starting Date", date.getStartingDate());
                    input.insertOne(details);

                } else if (select == 2) {
                    System.out.println("**********over 60 Member**********");
                    Over60Member over60_member = new Over60Member();
                    over60_member.setMemberID();
                    over60_member.setfstName();
                    over60_member.setlstName();
                    over60_member.setaddress();
                    over60_member.setAge();
                    Date date = new Date();
                    date.setStartingDate();
                    over60_member.setDefaultdate(date.getStartingDate());

                    Document details = new Document();
                    details.put("Member ID", over60_member.getMemberID());
                    details.put("First name", over60_member.getfName());
                    details.put("Last name", over60_member.getlName());
                    details.put("Address", over60_member.getaddress());
                    details.put("Age", over60_member.getAge());
                    details.put("Starting Date", date.getStartingDate());
                    input.insertOne(details);

                } else if (select == 3) {
                    System.out.println("**********Default Member**********");
                    DefaultMember defaultMember = new DefaultMember();
                    defaultMember.setMemberID();
                    defaultMember.setfstName();
                    defaultMember.setlstName();
                    defaultMember.setaddress();
                    Date date = new Date();
                    date.setStartingDate();
                    defaultMember.setDefaultdate(date.getStartingDate());

                    Document details = new Document();
                    details.put("Member ID", defaultMember.getMemberID());
                    details.put("First name", defaultMember.getfName());
                    details.put("Last name", defaultMember.getlName());
                    details.put("Address", defaultMember.getaddress());
                    details.put("Starting Date", date.getStartingDate());
                    input.insertOne(details);

                } else {
                    System.out.println("Invalid Input.... Please enter a valid input");
                }


            } else if (choice == 2) {
                System.out.println("**********Sort the items in a order**********");
                FindIterable<Document> sort_items = input.find().sort(new BasicDBObject("First name", 1));
                for (Document info : sort_items) {
                    System.out.println(info.get("Member ID") + " - " + info.get("First name") + " - " + info.get("Last name"));
                }

            } else if (choice == 3) {
                System.out.println("**********Print the list of members**********");

                for (Document data : input.find()) {
                    System.out.println("Member ID      -: " + data.get("Member ID"));
                    System.out.println("First name     -: " + data.get("First name"));
                    System.out.println("Last name      -: " + data.get("Last name"));
                    System.out.println("Address        -: " + data.get("Address"));
                    System.out.println("School         -: " + data.get("School"));
                    System.out.println("Age            -: " + data.get("Age"));
                    System.out.println("Starting Date  -: " + data.get("Starting Date"));
                    System.out.println("");
                }
                break;

            } else if (choice == 4) {
                System.out.println("**********Prompt the member list in GUI**********");
                Interface.Interface(args);

            } else if (choice == 9) {
                System.out.println("**********Delete a member**********");
                System.out.println("Enter the member ID-:");
                int id = gym.nextInt();
                BasicDBObject basicDBObject = new BasicDBObject();
                basicDBObject.put("Member ID", id);
                input.deleteOne(basicDBObject);
                System.out.println("Your member's details deleted successfully");

            } else if (choice == 0) {
                System.out.println("Exit the programme");
                break;

            } else {
                System.out.println("Please enter a valid input");
            }


        }

    }


}