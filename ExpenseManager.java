import java.io.*;
import java.util.*;

class ExpenseManager {
    List<Expense> expenses = new ArrayList<>();
    String filePath = "expenses.txt";

    ExpenseManager() {
        loadExpensesFromFile();
    }

    void loadExpensesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                expenses.add(new Expense(parts[0], Double.parseDouble(parts[1]), parts[2], parts[3]));
            }
        } catch (IOException e) {
            System.out.println("No previous data found, starting fresh!");
        }
    }

    void addExpense(String date, double amount, String category, String description) {
        Expense expense = new Expense(date, amount, category, description);
        expenses.add(expense);
        saveExpenseToFile(expense);
    }

    void saveExpenseToFile(Expense expense) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(expense.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving expense.");
        }
    }

    double getTotalForDay(String date) {
        return expenses.stream().filter(e -> e.date.equals(date)).mapToDouble(e -> e.amount).sum();
    }

    double getTotalForMonth(String monthYear) {
        return expenses.stream()
            .filter(e -> e.date.substring(3).equals(monthYear))
            .mapToDouble(e -> e.amount)
            .sum();
    }
}
