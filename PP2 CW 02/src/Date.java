public class Date extends DefaultMember{

    String startingDate;
    int year;
    int month;
    int date;

    public void setStartingDate() {
        while (true) {
            System.out.println("Please enter your starting year  -: ");
            try {
                this.year = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input... Please enter a correct input...");
            }
        }

        while (true) {
            System.out.println("Please enter your starting month  -: ");
            try {
                this.month = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input... Please enter a correct input...");
            }
        }

        while (true) {
            System.out.println("Please enter your starting date  -: ");
            try {
                this.date = scanner.nextInt();
                break;
            } catch (Exception exception) {
                System.out.println("Invalid input... Please enter a correct input...");
            }
        }

        startingDate = year + "/" + month + "/" + date;

    }

    public String getStartingDate() {
        return startingDate;
    }
}
