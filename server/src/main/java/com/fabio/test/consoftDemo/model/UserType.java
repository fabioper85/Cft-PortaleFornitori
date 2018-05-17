package com.fabio.test.consoftDemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="userType")
public class UserType
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_type")
	private String userType;
	
	@OneToMany
	@JoinTable(
			name="userType_docs",
			joinColumns = { @JoinColumn(name="id_user_type", referencedColumnName="id") },
			inverseJoinColumns = { @JoinColumn(name="id_docs", referencedColumnName="id") }
			)
	private List<Documents> docsList;
	
	public UserType() {
		docsList = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<Documents> getDocsList() {
		return docsList;
	}

	public void setDocsList(List<Documents> docsList) {
		this.docsList = docsList;
	}
}
