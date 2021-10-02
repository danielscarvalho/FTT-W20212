package ftt.ec.model;
//JavaBean
//POJO - Plan Old Java Object

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class User {
	
	private int userId;
	private String userName;
	private String userEmail;
	private String userTelefone;
	private Date userDOB; //Data Of Birth
	private String userColor;
	private float userValue;
	private String userCep;
	private String userComplement;
	private String userPassword;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String userName, String userEmail, String userTelefone, String userDOB, String userColor, 
			String userValue, String userCep, String userComplement,  String userPassword) {
		
		super();
		
		this.setUserId(userId);
		this.setUserName(userName);
		this.setUserEmail(userEmail);
		this.setUserTelefone(userTelefone);
		this.setUserDOB(userDOB);
		this.setUserColor(userColor);
		this.setUserValue(userValue);
		this.setUserCep(userCep);
		this.setUserComplement(userComplement);
		this.setUserPassword(userPassword);
	}	

	public User(int userId, String userName, String userTelefone, Date userDOB, String userColor, String userCep, String Complement, String userPassword,
			float userValue) {
		
		super();
		
		this.userId = userId;
		this.userName = userName;
		this.userTelefone = userTelefone;
		this.userDOB = userDOB;
		this.userColor = userColor;
		this.userPassword = userPassword;
		this.userValue = userValue;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserId(String userId) {
		if (userId == null)
			this.setUserId(0);
		else
			this.setUserId(Integer.valueOf(userId));
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		this.userEmail = userEmail;
	}
	public String getUserEmail() {
		// TODO Auto-generated method stub
		return this.userEmail;
	}
	public String getUserTelefone() {
		return userTelefone;
	}
	public void setUserTelefone(String userTelefone) {
		this.userTelefone = userTelefone;
	}
	public Date getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}
	public void setUserDOB(String userDOB) {
		//String para java.util.Date()
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		
		try {
			this.setUserDOB(dateFormat.parse(userDOB));
		//} catch (ParseException e) {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Ops! Data zuada: " + userDOB);
		} //try
	}
	public String getUserColor() {
		return userColor;
	}
	public void setUserColor(String userColor) {
		this.userColor = userColor;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public float getUserValue() {
		return userValue;
	}
	public void setUserValue(float userValue) {
		this.userValue = userValue;
	}
	public void setUserValue(String userValue) {
		if (userValue == null)
			this.setUserValue(0);
		else
			this.setUserValue(Float.valueOf(userValue));
	}
	
	/**
	 * @return the userCep
	 */
	public String getUserCep() {
		return userCep;
	}

	/**
	 * @param userCep the userCep to set
	 */
	public void setUserCep(String userCep) {
		this.userCep = userCep.replace("-", "");
	}

	/**
	 * @return the userComplement
	 */
	public String getUserComplement() {
		return userComplement;
	}

	/**
	 * @param userComplement the userComplement to set
	 */
	public void setUserComplement(String userComplement) {
		this.userComplement = userComplement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userCep, userColor, userComplement, userDOB, userEmail, userId, userName, userPassword,
				userTelefone, userValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(userCep, other.userCep) && Objects.equals(userColor, other.userColor)
				&& Objects.equals(userComplement, other.userComplement) && Objects.equals(userDOB, other.userDOB)
				&& Objects.equals(userEmail, other.userEmail) && userId == other.userId
				&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword)
				&& Objects.equals(userTelefone, other.userTelefone)
				&& Float.floatToIntBits(userValue) == Float.floatToIntBits(other.userValue);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userTelefone="
				+ userTelefone + ", userDOB=" + userDOB + ", userColor=" + userColor + ", userValue=" + userValue
				+ ", userCep=" + userCep + ", userComplement=" + userComplement + ", userPassword=" + userPassword
				+ "]";
	}
	

	
} // User
