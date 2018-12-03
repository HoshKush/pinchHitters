package spring.model.u_rate;

public class U_RateDTO {
	private int u_num;
	private String u_ID;
	private String u_content;
	private int u_star;
	private String c_ID;
	private String u_ratecode;

	public int getU_num() {
		return u_num;
	}

	public void setU_num(int u_num) {
		this.u_num = u_num;
	}

	public String getU_ID() {
		return u_ID;
	}

	public void setU_ID(String u_ID) {
		this.u_ID = u_ID;
	}

	public String getU_content() {
		return u_content;
	}

	public void setU_content(String u_content) {
		this.u_content = u_content;
	}

	public int getU_star() {
		return u_star;
	}

	public void setU_star(int u_star) {
		this.u_star = u_star;
	}

	public String getC_ID() {
		return c_ID;
	}

	public void setC_ID(String c_ID) {
		this.c_ID = c_ID;
	}

	public String getU_ratecode() {
		return u_ratecode;
	}

	public void setU_ratecode(String u_ratecode) {
		this.u_ratecode = u_ratecode;
	}

}
