package com.vkart.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "USER")
public class User implements Serializable{

	@Id	
	@GeneratedValue
    @Column(name = "USER_ID", unique = true, nullable = false)
    private int userId;
	@Pattern(regexp="[a-zA-Z]+",message="First name should not contain invalid character")
	@Column(name = "F_NAME", nullable = false)
	private String firstName;
	@Pattern(regexp="[a-zA-Z]+",message="Last name should not contain invalid character")
	@Column(name = "L_NAME")
	private String lastName;
	@Pattern(regexp="[6-9]\\d{9}",message="Please enter valid phone number")
	@Column(name = "MOBILE")
	private String mobileNo;
	
	@Pattern(regexp="[\\w.]+",message="UserName should not contain special character ecxept _")
    @Column(name = "USER_NAME", nullable = false, length = 32)
    private String userName;
	@Size(min=8)
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message="Password should contain at least an uppercase and a lowercase character, a number and a special character")
    @Column(name = "PASSWORD", nullable = false, length = 64)
    private String password;
    
	@NotNull
	@Column(name = "EMAIL",unique =true , nullable = false)
    private String emailId;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active = true;
    
    @Column(name = "ROLE")
    private String role = "ROLE_USER";

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", emailId=" + emailId + ", active=" + active + ", role=" + role
				+ "]";
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}