public class Main {

    public static void main(String[] args) {

    Bank bank1 = new Bank("Polish Good Boy's Bank");
    bank1.addBranch("Premium users");
    bank1.addCst("Jizzy", "Premium users", 44.22);
    bank1.addCst("Natalie", "Premium users", 190.02);
    bank1.addCst("Elizabeth", "Premium users", 223d);

    bank1.addBranch("Eco");
    bank1.addCst("Tommy", "Eco", 0d);
    bank1.addCst("Nicky Nick", "Eco", 5.20);
    bank1.addCst("Frank", "Eco", 10d);

    bank1.addCstT("Premium users", "Natalie", 40);
    bank1.addCstT("Eco", "Tommy", 10);

    bank1.showCustomers("Eco", false);
    bank1.showCustomers("Premium users", true);


    }
}
