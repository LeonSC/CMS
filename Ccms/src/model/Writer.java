package model;

import org.mongodb.morphia.annotations.NotSaved;

/**
 * Writer is up on the user. Writer is a role mark it has this right. User is the bean.
 * @author sasgsc
 */
@NotSaved
public class Writer {

	private Integer lv=0;
	
	private Integer state=0;//0待审批, 1正常, 2ban
	
	private String password;

	public Integer getLv() {
		return lv;
	}

	public void setLv(Integer lv) {
		this.lv = lv;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
