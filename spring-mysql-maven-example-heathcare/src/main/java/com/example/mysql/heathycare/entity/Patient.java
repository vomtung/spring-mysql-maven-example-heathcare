package com.example.mysql.heathycare.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.mysql.heathycare.type.SexEnum;


/**
 * 
 * @author vominhtung
 *
 */
@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="patient_id")
	private String patientId;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="sex")
	@Enumerated(value=EnumType.STRING)
	private SexEnum sex;
	
	@Column(name="age")
	private Integer age;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="patient", cascade= CascadeType.ALL)
	private Set<Answer>answer= new HashSet<Answer>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="patient", cascade= CascadeType.ALL)
	private Set<Prescription>prescriptions= new HashSet<Prescription>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	
}
