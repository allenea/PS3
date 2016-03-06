package PS.Account;
import java.text.DecimalFormat;
import java.util.Date;

public class Account {
	public static void main(String[] args){
		//TEST INSTANCE
		Account myAccount = new Account(1122, 20000.00, 4.5);
		myAccount.deposit(3000.00);
		//Try-Catch for exception
		try {
			myAccount.withdraw(2500.00);
		} catch (InsufficientFundsException e) 
	      {
          System.out.println("Sorry, but you are short $"
                                   + e.getAmount());
          e.printStackTrace();
	       }
		//display balance, monthly interest and date of account
		DecimalFormat df = new DecimalFormat("#.00"); 
		System.out.println("The Balance Is:"   + df.format(myAccount.Balance));
		System.out.println("Monthly Interest Is:" + df.format(myAccount.getMonthlyInterest()));
		System.out.println("The Account Was Created On: " + myAccount.dateCreated);
		}



	private int ID = 0;
	private double Balance = 0.00;
	private double AnnualIntrestRate = 0.00;
	private Date dateCreated;


	public Account() {
		super();
	}

	public Account(int ID, double Balance, double AnnualInterestRate) {
		super();
		this.ID = ID;
		this.Balance = Balance;
		this.AnnualIntrestRate = AnnualInterestRate;
		this.dateCreated = new Date();
	}
	
	public int getId() {
		return ID;
		}

	public void setId(int ID) {
		this.ID = ID;
		}
	
	public double getBalance(){
		return Balance;
	}
	
	public void setBalance(double Balance){
		this.Balance = Balance;
	}
	
	public double getAnnualIntrestRate(){
		return (AnnualIntrestRate/100);
	}
	
	public void setAnnualIntrestRate(double AnnualIntrestRate){
		this.AnnualIntrestRate = AnnualIntrestRate;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		// TODO Auto-generated method stub
		return (this.getAnnualIntrestRate()/12);
	}
	public double getMonthlyInterest() {
		// TODO Auto-generated method stub
		return (Balance * getMonthlyInterestRate());
	}

	
	public void deposit(double amount) {
		 Balance += amount;	
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount <= Balance) {
			Balance -= amount;
		} else {
			double needs = amount - Balance;
			throw new InsufficientFundsException(needs);
		}
}
}
