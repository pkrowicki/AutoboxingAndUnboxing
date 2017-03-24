import java.util.ArrayList;

/**
 * Created by Pawel Krowicki on 24.03.2017.
 */
public class Branch {

    private String branchName;
    private ArrayList<Customer> customer;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customer = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public String getBranchName() {
        return branchName;
    }

    public boolean addCst(String name, double firstTransaction) {
        if (findCst(name)!=null){
            Customer existingCst = findCst(name);
            System.out.println("Customer " + existingCst.getName() + " already in DB.");
            return false;
        } else {
            Customer newC = new Customer(name, firstTransaction);
            customer.add(newC);
            System.out.println("Customer " + newC.getName() + " successfully added.");
            return true;
        }
    }

    private Customer findCst(String name) {
        for(int i=0; i<this.customer.size();i++){
            Customer checkedCst = this.customer.get(i);
            if(checkedCst.getName().equals(name)){
                return checkedCst;
            }
        }
        return null;
    }

    public boolean transactionCst(String name, double amount){
        Customer existingCst = findCst(name);
        if(existingCst==null){
            System.out.println("Customer not in DB");
            return false;
        } else {
            existingCst.addTransactions(amount);
            return true;
        }
    }


}
