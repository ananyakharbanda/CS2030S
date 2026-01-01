import java.util.ArrayList;

class Customer {
    private String custID;
    private String name;
    private int phone;
    private String email;
    private ArrayList<BankAccount> bankAccounts;

    public Customer(String custID, String name, int phone, String email) {
        this.custID = custID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bankAccounts = new ArrayList<BankAccount>();
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void addAccount(BankAccount account) {
        this.bankAccounts.add(account);
    }
    
    public ArrayList<BankAccount> getAccount() {
        return this.bankAccounts;
    }

   
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Customer)
        {
            Customer c = (Customer)obj;
            if(c.custID == this.custID)
            {
                return true;
            }
        }
        return false;
    } 

    @Override
    public String toString()
    {
        String toreturn = this.name + " " + this.custID;
        return toreturn;
    }

    public String getName() {
        return this.name;
    }

    public int getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCustID() {
        return this.custID;
    }
}

class BankAccount {
    private int accountNum;
    protected double currBalance;
    private Customer customer;
    private String accStatus;
    
    public BankAccount(int accountNum, double currBalance, Customer customer, String accStatus) {
        this.accountNum = accountNum;
        this.currBalance = currBalance;
        this.customer = customer;
        this.accStatus = "ACTIVE";
    }

    public void depositMoney(double money) {
        this.currBalance = this.currBalance + money;
        System.out.println("current balance: " + this.currBalance);
    }

    public void withdrawMoney(double money) {
        if (this.currBalance >= money) {
            this.currBalance = this.currBalance - money;
            System.out.println("current balance: " + this.currBalance);
        }
        else {
            System.out.println("insufficient balance!");
        }
    }

    public double getMoney() {
        return this.currBalance;
    }

    public void closeAccount() {
        this.accStatus = "CLOSED";
    }
}

class SavingsAccount extends BankAccount {
    private float interest;
    private double monLimit;

    public SavingsAccount(int accountNum, double currBalance, Customer customer, String accStatus, float interest, double monLimit) {
        super(accountNum, currBalance, customer, accStatus);
        this.interest = interest;
        this.monLimit = monLimit;
    }
    
    @Override
    public void withdrawMoney(double money) {
        if (this.currBalance >= money || money < this.monLimit) {
            this.currBalance = this.currBalance - money;
            this.monLimit = this.monLimit - money;
            System.out.println("current balance: " + this.currBalance);
        }
        else {
            System.out.println("insufficient balance or monthly limit exceeded!");
        }
    }
}
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(int accountNum, double currBalance, Customer customer, String accStatus, float overdraftLimit) {
        super(accountNum, currBalance, customer, accStatus);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdrawMoney(double money) {
        if (this.currBalance + this.overdraftLimit >= money) {
            this.currBalance = this.currBalance - money;
            this.overdraftLimit = this.overdraftLimit - money;
            System.out.println("current balance: " + this.currBalance);
        }
        else {
            System.out.println("insufficient balance or overdraft limit exceeded!");
        }
    }
}
    
class Transaction {
    private int transactionID;
    private String type;
    private double amount;
    private int date;
    private int time;
    private Object source;
    private Object target;

    public Transaction(int transactionID, String type, double amount, int date, int time, Object source, Object target) {
        this.transactionID = transactionID;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.source = source;
        this.target = target;
    }
} 
    
    
class Bank {
    public static void main(String[] args) {
        Customer ananya = new Customer("1", "Ananya Kharbanda", 98219012, "ananyakharbanda28@gmail.com");
        Customer ananya2 = new Customer("1", "Ananya Kharbanda", 98219012, "ananyakharbanda28@gmail.com");
        ananya.setName("Ananya");
        ananya.setPhone(12345678);
        System.out.println(ananya.getName());
        System.out.println(ananya.getPhone());
        //ananya.setB

        System.out.println(ananya.equals(ananya2));
        System.out.println(ananya.toString());
    }
}
