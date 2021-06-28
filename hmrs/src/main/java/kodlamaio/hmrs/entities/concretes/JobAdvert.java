package kodlamaio.hmrs.entities.concretes;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "min_salary")
	private int minimumSalart;
	
	@Column(name = "max_salary")
	private int maximumSalary;
	
	@Column(name = "open_position")
	private int openPositionNumber;
	
	@Column(name = "published_at")
	private Date publishedAt;
	
	@Column(name = "deadline")
	private Date deadline;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "confirm_status", nullable = false)
	private Boolean confirmStatus;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Employer employer;
	
    @ManyToOne
    @JoinColumn(name="job_type_id")
    private JobType jobType;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	
	
}
