package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv_links")
@AllArgsConstructor
@NoArgsConstructor
public class CvLink {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
		private int id;

	    @Column(name="linkedIn_url")
		private String linkedInUrl;
	    
	    @Column(name="gitHub_url")
		private String gitHubUrl;

	    
	    @ManyToOne()
	    @JoinColumn(name="job_seeker_id")
	    private JobSeeker jobSeeker;

}
