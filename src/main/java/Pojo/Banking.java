package Pojo;

public class Banking {

	int trnnum;
	int accnum;
	String dot;
	double amount;

	public Banking(int trnnum, int accnum, String dot, double amount) {
		this.trnnum = trnnum;
		this.accnum = accnum;
		this.dot = dot;
		this.amount = amount;
	}

	public int getTrnnum() {
		return trnnum;
	}

	public void setTrnnum(int trnnum) {
		this.trnnum = trnnum;
	}

	public int getAccnum() {
		return accnum;
	}

	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}

	public String getDot() {
		return dot;
	}

	public void setDot(String dot) {
		this.dot = dot;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Banking [trnnum=" + trnnum + ", accnum=" + accnum + ", dot=" + dot + ", amount=" + amount + "]";
	}
}
