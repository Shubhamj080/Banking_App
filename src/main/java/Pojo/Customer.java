package Pojo;

public class Customer {
	int cust_id;
	String cname;
	String mail_id;
	String mob;

	public Customer(int cust_id, String cname, String mail_id, String mob) {
		this.cust_id = cust_id;
		this.cname = cname;
		this.mail_id = mail_id;
		this.mob = mob;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	@Override
	public String toString() {
		return "cust_id=" + cust_id + ", cname=" + cname + ", mail_id=" + mail_id + ", mob=" + mob + "\n";
	}

}
