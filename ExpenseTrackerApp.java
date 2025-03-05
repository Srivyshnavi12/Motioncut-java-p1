import java.util.*;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\nWelcome to Daily Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Today's Expenses");
            System.out.println("3. View This Month's Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter date (DD/MM/YYYY): ");
                String date = sc.nextLine();
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter category: ");
                String category = sc.nextLine();
                System.out.print("Enter description: ");
                String description = sc.nextLine();

                manager.addExpense(date, amount, category, description);
                System.out.println("Expense added!");

            } else if (choice == 2) {
                System.out.print("Enter today's date (DD/MM/YYYY): ");
                String date = sc.nextLine();
                System.out.println("Total spent today: " + manager.getTotalForDay(date));

            } else if (choice == 3) {
                System.out.print("Enter month and year (MM/YYYY): ");
                String monthYear = sc.nextLine();
                System.out.println("Total spent this month: " + manager.getTotalForMonth(monthYear));

            } else if (choice == 4) {
                System.out.println("Bye-bye!");
                break;

            } else {
                System.out.println("Invalid choice. Try again!");
            }
        }
        sc.close();
    }
}
