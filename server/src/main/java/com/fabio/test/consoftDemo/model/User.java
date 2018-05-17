package com.fabio.test.consoftDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="VW_BodyRentalVendor")
public class User
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Company")
	private String company;
	
	@Column(name = "Company_Name_No")
	private String companyNameNo;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Name_2")
	private String name2;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Address_2")
	private String address2;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "Post_Code")
	private String postCode;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Phone_No")
	private String phoneNumber;
	
	@Column(name = "Fax_No")
	private String faxNumber;
	
	@Column(name = "Vat_No")
	private String vatNumber;
	
	@Column(name = "Blocked_Qualification")
	private int blockedQualification;
	
	@Column(name = "Qualification_Notes")
	private String qualificationNotes;	
	
	@OneToOne(mappedBy = "user")
	private UserLogin login;
	
	@ManyToOne
	@JoinColumn(name="user_type_id")
	private UserType userType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyNameNo() {
		return companyNameNo;
	}

	public void setCompanyNameNo(String companyNameNo) {
		this.companyNameNo = companyNameNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public int getBlockedQualification() {
		return blockedQualification;
	}

	public void setBlockedQualification(int blockedQualification) {
		this.blockedQualification = blockedQualification;
	}

	public String getQualificationNotes() {
		return qualificationNotes;
	}

	public void setQualificationNotes(String qualificationNotes) {
		this.qualificationNotes = qualificationNotes;
	}
	
	@JsonIgnore
	public UserLogin getLogin() {
		return login;
	}

	public void setLogin(UserLogin login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", company=" + company + ", companyNameNo=" + companyNameNo + ", vatNumber="
				+ vatNumber + "]";
	}
}
