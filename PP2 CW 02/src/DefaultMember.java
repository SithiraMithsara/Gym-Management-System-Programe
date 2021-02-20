import java.util.Scanner;

public class DefaultMember {

    Scanner scanner = new Scanner(System.in);

    int memberID;
    String fstName;
    String lstName;
    String address;
    String newdefaultDate;

    public void setMemberID() {
        System.out.println("Please enter your member ID  -: ");
        while (true) {
            try {
                this.memberID = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input... Please enter the correct input again...");
                scanner.next();
            }
        }
    }

    public void setfstName() {
        System.out.println("Please enter your first name  -: ");
        this.fstName = scanner.next();
        while (true) {
            try {
                Integer.parseInt(this.fstName);
                System.out.println("Invalid input... Please check and enter correct first name  -: ");
                this.fstName = scanner.next();
            }catch (Exception e) {
                break;
            }
        }
    }

    public void setlstName() {
        System.out.println("Please enter your last name  -: ");
        this.lstName = scanner.next();
        while (true) {
            try {
                Integer.parseInt(this.lstName);
                System.out.println("Invalid input... Please check and enter correct last name  -: ");
                this.lstName = scanner.next();
            }catch (Exception e) {
                break;
            }
        }
    }

    public void setaddress() {
        System.out.println("Please enter your address  -: ");
        this.address = scanner.next();
        while (true) {
            try {
                Integer.parseInt(this.address);
                System.out.println("Invalid input... Please check and enter correct address  -: ");
                this.address = scanner.next();
            }catch (Exception e) {
                break;
            }
        }
    }

    public void setDefaultdate(String defaultdate) {this.newdefaultDate = defaultdate;}

    public String getDefaultdate() {
        return newdefaultDate;
    }

    public int getMemberID() {return memberID;}
    public String getfName() {return fstName;}
    public String getlName() {return lstName;}
    public String getaddress() {return address;}
}
