package kodlamaio.hmrs.entities.concretes;

import java.util.List
;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_types")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})

public class JobType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_type_id")
	private int id;
	
	@Column(name="job_type")
	private String jobType;
	
	@OneToMany(mappedBy = "jobType")
	@JsonIgnore
	private List<JobAdvert> jobAdverts;
	

}
