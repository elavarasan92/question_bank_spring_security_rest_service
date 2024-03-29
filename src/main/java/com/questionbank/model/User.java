package com.questionbank.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private long userId;
	@Column(name = "USERNAME")
	@NotNull(message = "username should not be null")
	@Size(min =3, max = 50, message = "username must be between 3 and 50 characters")
	private String username;
	@Column(name = "FIRST_NAME")
	@NotNull(message = "firstName should not be null")
	@Size(min = 3, max = 50, message = "firstName must be between 3 and 50 characters")
	private String firstName;
	@Column(name = "ROLE")
	@NotNull(message = "role should not be null")
	@Size(min = 3, max = 20, message = "role must be between 3 and 20 characters")
	private String role;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL_ADDRESS")
	@NotNull(message = "emailAddress should not be null")
	@Email(message = "emailAddress should be valid")
	private String emailAddress;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "MOBILE_NUMBER")
	@NotNull
	private String mobileNumber;

	@Column(name = "OTP")
	private String otp;

	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}

	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", role=" + role
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", mobileNumber=" + mobileNumber
				+ ", otp=" + otp + ", password=" + password + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}
	public User() {
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "CREATED_BY")
	@CreatedBy
	private String createdBy;

	@Column(name = "CREATED_DATE")
	@CreatedDate
	private Timestamp createdDate;

	@Column(name = "UPDATED_BY")
	@LastModifiedBy
	private String updatedBy;

	@Column(name = "UPDATED_DATE")
	@LastModifiedDate
	private Timestamp updatedDate;

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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public boolean match(String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}

}
