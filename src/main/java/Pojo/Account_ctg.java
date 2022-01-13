package Pojo;

public class Account_ctg {

	String acctype;
	String accname;

	public Account_ctg(String acctype, String accname) {
		this.acctype = acctype;
		this.accname = accname;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	@Override
	public String toString() {
		return "Account_ctg [acctype=" + acctype + ", accname=" + accname + "]";
	}
}
