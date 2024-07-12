import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TVManagementSystem system = new TVManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("TV Management System");
            System.out.println("1. Add TV Show");
            System.out.println("2. Remove TV Show");
            System.out.println("3. List TV Shows");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter show name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter rating: ");
                    double rating = sc.nextDouble();
                    TVShow show = new TVShow(name, category, rating);
                    system.addShow(show);
                    break;
                case 2:
                    System.out.print("Enter show name to remove: ");
                    String removename = sc.nextLine();
                    system.removeShow(removename);
                    break;
                case 3:
                    system.displayAllShows();
                    break;
                case 4:
                    System.out.println("Exiting system.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}