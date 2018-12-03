package spring.model.c_rate;

public class C_RateDTO {
	private int cr_num;
	private String u_ID;
	private String cr_content;
	private int cr_star;
	private String cr_ratecode;
	private String c_ID;

	public int getCr_num() {
		return cr_num;
	}

	public void setCr_num(int cr_num) {
		this.cr_num = cr_num;
	}

	public String getU_ID() {
		return u_ID;
	}

	public void setU_ID(String u_ID) {
		this.u_ID = u_ID;
	}

	public String getCr_content() {
		return cr_content;
	}

	public void setCr_content(String cr_content) {
		this.cr_content = cr_content;
	}

	public int getCr_star() {
		return cr_star;
	}

	public void setCr_star(int cr_star) {
		this.cr_star = cr_star;
	}

	public String getCr_ratecode() {
		return cr_ratecode;
	}

	public void setCr_ratecode(String cr_ratecode) {
		this.cr_ratecode = cr_ratecode;
	}

	public String getC_ID() {
		return c_ID;
	}

	public void setC_ID(String c_ID) {
		this.c_ID = c_ID;
	}

}
