

public class CreditCard{
	
	private String customer;
	private String bank;
	private String account;
	private double balance;
	private int limit;
	
	
	/* Getters Methods*/
	public String getCustomer() {
		return customer;
	}


	public String getBank() {
		return bank;
	}


	public String getAccount() {
		return account;
	}


	public double getBalance() {
		return balance;
	}


	public int getLimit() {
		return limit;
	}


	public CreditCard(String cust, String bnk, String acc, int lmt, double bal){
		customer = cust;
		bank = bnk;
		account = acc;
		balance = bal;
		limit = lmt;
	}
	
	
	public CreditCard(String cust, String bnk, String acc, int lmt){
		this(cust,bnk,acc,lmt,0.0);
	}
	
	public void makePayment(double amount){
		balance -=amount;
	}
	
	public void recharge(double rechargeVal){
		if(balance + rechargeVal<limit){
			balance +=rechargeVal;
		}
	}
	
	public static void summary(CreditCard card){
		System.out.println("Customer "+card.customer);
		System.out.println("Issuing Bank "+card.bank);
		System.out.println("Account No "+card.account);
		System.out.println("Account Balance "+card.balance);
		System.out.println("Card Limit "+card.limit+"\n");
	}
	public static void main(String[] args) {
		CreditCard[] wallet = new CreditCard[3];
		wallet[0] = new CreditCard("Anderson","Bank Of America", "5145127917",1000,1000); 
		wallet[1] = new CreditCard("John","Bank Of Sweden", "10024578",500); 
		wallet[2] = new CreditCard("Marie","RBC", "548779546",50000,10000); 
		
		for(CreditCard card: wallet ){
			summary(card);
		}
	}
}
