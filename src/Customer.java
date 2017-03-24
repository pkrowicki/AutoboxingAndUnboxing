import java.util.ArrayList;

/**
 * Created by Pawel Krowicki on 23.03.2017.
 */
public class Customer {

    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String name, double initTransaction){
        this.name=name;
        this.transactions=new ArrayList<Double>();
        this.transactions.add(Double.valueOf(initTransaction));
    }

    public void addTransactions(double amount) {
        this.transactions.add(Double.valueOf(amount));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
