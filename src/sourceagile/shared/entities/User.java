package sourceagile.shared.entities;

import java.io.Serializable;

/**
 * 
 * @Entity
 */
public class User implements Serializable {

	public static final String ADMIN_USER = "admin";

	private static final long serialVersionUID = 1L;

	private String nickName;

	private String name;

	private String email;

	private String password;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
