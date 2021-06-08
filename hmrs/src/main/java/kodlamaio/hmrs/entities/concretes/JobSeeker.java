package kodlamaio.hmrs.entities.concretes;

import java.sql.Date;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hmrs.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;


@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity

@EqualsAndHashCode(callSuper = false)
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {


	
	@Column(name = "first_name")
	private String firstName;
	
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "national_id")
	private String nationalId;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "is_verified")
	private boolean isVerified;
	
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvEducation> cvEducations;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvJobExperience> cvJobExperiences;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvLanguage> cvLanguages;
	
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvSkill> cvSkills;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvCoverLetter> cvCoverLetters;
	
	@JsonIgnore
	@OneToOne(mappedBy = "jobSeeker")
	private CvImage cvImage;
	
	public JobSeeker(String email, String password,boolean isVerified, String firstName, String lastName, String nationalId, Date birthDate) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.isVerified = isVerified;
		this.birthDate = birthDate;
	}
	

}
