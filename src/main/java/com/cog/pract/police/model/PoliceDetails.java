package com.cog.pract.police.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="policedetails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PoliceDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "badgeid")
	private String badgeId;
	@Column(name = "firstname")
	private String firstName;	
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "password")
	private String passord;
	@Column(name = "policerank")
	private String policeRank;

}
