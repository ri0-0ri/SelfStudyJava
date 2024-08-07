package model.dto;

public class UserDTO {
	private String userid;
	private String userpw;
	private String username;
	private String gender;
	private int age;
	private String phone;
	private int credit;
	
	public UserDTO() {}

	public UserDTO(String userid, String userpw, String username, String gender, int age, String phone, int credit) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.credit = credit;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
}
	
	