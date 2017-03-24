import java.util.ArrayList;

/**
 * Created by Pawel Krowicki on 23.03.2017.
 */
public class Bank {

    private String bName;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.bName = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String bName){
        if(findB(bName)!=null){
            Branch existingB = findB(bName);
            System.out.println("Branch \"" + existingB.getBranchName() + "\" already exists!");
            return false;
        } else {
            this.branches.add(new Branch(bName));
            System.out.println("Branch \"" + bName + "\" successfully added!");
            return true;
        }
    }

    public boolean addCst(String cstName, String branchName, double initialA){
        Branch newB = findB(branchName);
        if(newB!=null){
            return newB.addCst(cstName,initialA);
        }
        System.out.println("Customer \""+cstName+"\" not found.");
        return false;
    }

    public boolean addCstT(String bName, String cstName, double amount){
        Branch newB = findB(bName);
        if(newB!=null){
            return newB.transactionCst(cstName,amount);
        }
        System.out.println("Customer \"" + cstName + "\" or branch \"" + bName + "\" not found.");
        return false;
    }

    public Branch findB(String lName){

        for(int i=0;i<this.branches.size();i++){
            Branch checkedB = this.branches.get(i);
            if(checkedB.getBranchName().equals(lName)){
                return checkedB;
            }
        }
        return null;
    }

    public boolean showCustomers(String bName, boolean showT){
        Branch br1 = findB(bName);
        if(br1!=null){
            System.out.println("Customer list for branch \"" + br1.getBranchName() + "\":");
            ArrayList<Customer> bCustomers = br1.getCustomer();
            for(int i=0;i<bCustomers.size();i++){
                Customer bCustomer = bCustomers.get(i);
                System.out.println("Customer #"+(i)+" -> " + bCustomer.getName());
                if(showT){
                    System.out.println("Transactions: ");
                    ArrayList<Double> transactions = bCustomer.getTransactions();
                    for(int y=0;y<transactions.size();y++){
                        System.out.println("\t#"+y+" -> Amount: "+transactions.get(y));
                    }
                    System.out.println("**************");
                }
            }
            return true;
        }
        System.out.println("Branch \"" +bName + "\" not found.");
        return false;
    }
}
