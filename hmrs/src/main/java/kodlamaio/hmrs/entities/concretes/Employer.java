package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="companys")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "company_name")
	private String companyName;
	
	
	@Column(name = "company_website")
	private String companyWebsite;
	
	@Column(name = "is_verified")
	private boolean isVerifed;

	@Column(name = "phone_number")
	private int phoneNumber;

}
