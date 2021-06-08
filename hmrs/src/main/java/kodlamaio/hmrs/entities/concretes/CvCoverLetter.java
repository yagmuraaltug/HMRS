package kodlamaio.hmrs.entities.concretes;

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
@Table(name = "cv_cover_letters")
@AllArgsConstructor
@NoArgsConstructor
public class CvCoverLetter {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
		private int id;
	  
	    @Column(name="cover_letter")
		private String coverLetter;
	    
	    
	    @ManyToOne()
	    @JoinColumn(name="job_seeker_id")
	    private JobSeeker jobSeeker;

}
