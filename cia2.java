import java.util.*;

interface Bank
 {
	void Deposit(double amount);
	void Withdraw(double amount) throws InsuffiecientBalanceException;
	double GetBalance();
	double GetAnnualInterest();
}

class SBI implements Bank {
    private int Bankid;
    private String Branch;
    private String Location;
    private float Roi;

    private double totalAmount;

    public SBI() {
        Roi = 14.5f;
    }

    public void setBankid(int id) {
        Bankid = id;
    }

    public int getBankId() {
        return Bankid;
    }

    public String getBankName() {
        return "SBI";
    }


    public void Deposit(double amount) {
        totalAmount += amount;
    }

    public void Withdraw(double amount) throws InsuffiecientBalanceException {
        if (amount > totalAmount) {
            throw new InsuffiecientBalanceException("Withdrawal can't be completed Due To Insufficient Balance!!");
        } else {
            totalAmount -= amount;
        }
    } 
    
    public double GetBalance() {
        return totalAmount;
    }

    public double GetAnnualInterest() {
        return Roi;
    }
}

class HDFC implements Bank {
    private int Bankid;
    private String branch;
    private String location;
    private float Roi;

    private double totalAmount;

    public HDFC() {
        Roi= 15.5f;
    }

    public void setBankid(int id) {
        Bankid = id;
    }

    public int getBankId() {
        return Bankid;
    }

    public String getBankName() {
        return "HDFC";
    }


    public void Deposit(double amount) {
        totalAmount += amount;
    }

    public void Withdraw(double amount) throws InsuffiecientBalanceException {
        if (amount > totalAmount) {
            throw new InsuffiecientBalanceException("Insufficient Balance!!");
        } else {
            totalAmount -= amount;
        }
    } 
    
    public double GetBalance() {
        return totalAmount;
    }

    public double GetAnnualInterest() {
        return Roi;
    }
}

class ICICI implements Bank {
    private int Bankid;
    private String branch;
    private String location;
    private float Roi;

    private double totalAmount;

    public ICICI() {
        Roi = 16.25f;
    }

    public void setBankid(int id) {
        Bankid = id;
    }

    public int getBankId() {
        return Bankid;
    }

    public String getBankName() {
        return "ICICI";
    }


    public void Deposit(double amount) {
        totalAmount += amount;
    }

    public void Withdraw(double amount) throws InsuffiecientBalanceException {
        if (amount > totalAmount) {
            throw new InsuffiecientBalanceException("Insufficient Balance!!");
        } else {
            totalAmount -= amount;
        }
    } 
    
    public double GetBalance() {
        return totalAmount;
    }

    public double GetAnnualInterest() {
        return Roi;
    }
}


class InsuffiecientBalanceException extends Exception {
    
    String message;
    
    public InsuffiecientBalanceException(String message) {
        super(message);
        this.message = message;
        
    }
    
    public String getMessage() {
        return message;
    }
}


class Person extends SBI {
    private int personID;
    private String name;
    private int accountNumber;
    private String typeOfAccount;
    private String email;
    private String bankName;

    Person(int pId, String pName, int accountNo, String accountType, String pEmail, String pBankName) {
        personID = pId;
        name = pName;
        name = name.toUpperCase();
        accountNumber = accountNo;
        typeOfAccount = accountType;
        email = pEmail;
        bankName = pBankName;
        if (bankName == "SBI") {
            setBankid(1);
        } else if(bankName == "HDFC") {
            setBankid(2);
        }else {
            setBankid(3);
        }
    }

    public int getPersonId() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void accountDetails() {
        System.out.println("Person id : " + getPersonId());
        System.out.println("Person name : " + getName());
        System.out.println("Bank id : " + getBankId());
        System.out.println("Bank name : " + getBankName());
        System.out.println("Balance : " + GetBalance());
        System.out.println("Annual Interest : " + GetAnnualInterest());
    }
}

public class cia2
{ 
	public static void main(String[] args)
	{

        Scanner scn = new Scanner(System.in);

        Person Person_MaxAmount = null;
        double maxAmount = 0;

        System.out.print("Enter No Of Times Add Data: ");
        int n = scn.nextInt();
        

        for (int i=1; i<=n; i++) {
            System.out.println("Enter Person id : ");
            int pId = scn.nextInt();
            System.out.println("Enter Person name : ");
            scn.nextLine();
            String pName = scn.nextLine();
            System.out.println("Enter Person email : ");
            String email = scn.nextLine();
            System.out.println("Enter your type of account : ");
            String typeOfAccount = scn.nextLine();
            System.out.println("Enter Person account number : ");
            int accountNumber = scn.nextInt();
            System.out.println("Enter your bank name : ");
            String bankName = scn.nextLine();   

	 

            Person person = new Person(pId, pName, accountNumber, typeOfAccount, email, bankName);

            int ch;
            do {
                System.out.println("-----------------Main Menu------------------\n");
                System.out.println("1. Deposit money");
                System.out.println("2. Withdraw money");
                System.out.println("3. Check balance");
                System.out.println("4. Print Account Details");
                System.out.println("5. Exit");
                System.out.println("Give Your choice : "); 
                ch = scn.nextInt();

                switch(ch) {
                    case 1:
                        System.out.println("Enter amount to deposit : ");
                        double amount = scn.nextDouble();
                        person.Deposit(amount);
                        break;

                    case 2:
                        System.out.println("Enter amount to withdraw : ");
                        double money = scn.nextDouble();  
                        try {
                           person.Withdraw(money); 
                        } catch(InsuffiecientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        break;

                    case 3:
                        System.out.println("Balance : " + person.GetBalance());
                        break;

                    case 4:
                        person.accountDetails();
                        break;

                    case 5:
                        System.out.println("Thank You Visit Again........");
                        break;

                }
                
                if (person.GetBalance() > maxAmount) {
                    maxAmount = person.GetBalance();
                    Person_MaxAmount = person;
                }

            } while (ch != 5);            
        }
        
        System.out.println("Person with maximum amount : " + Person_MaxAmount.getName());
    }
}