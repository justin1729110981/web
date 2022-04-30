package Vo;

public class User {
	private int id;
	private String username;
	private String password;
	private String country;
	public User(int id, String username, String password, String country) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.country = country;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", country=" + country + "]";
	}
	

}
