class Expense {
    String date;
    double amount;
    String category;
    String description;

    Expense(String date, double amount, String category, String description) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public String toString() {
        return date + "|" + amount + "|" + category + "|" + description;
    }
}
