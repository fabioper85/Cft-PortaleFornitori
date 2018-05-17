package com.fabio.test.consoftDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VW_BodyRentalVendor_qualificationDocs")
public class Documents {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "doctype")
	private String doctype;
	
	@Column(name = "hasScadenza")
	private boolean hasScadenza;
	
	@ManyToOne
	@JoinTable(
			name="userType_docs",
			joinColumns = { @JoinColumn(name="id_docs", referencedColumnName="id") },
			inverseJoinColumns = { @JoinColumn(name="id_user_type", referencedColumnName="id") }
			)
	private UserType userType;
}
