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
@Table(name = "cv_job_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class CvJobExperience {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
		private int id;

	    
	    @Column(name="company_name")
		private String companyName;
	    
	    
	    @Column(name="position")
		private String position;
	    
	    @Column(name="start_date")
		private Date startDate;

	    @Column(name="end_date")
	  	private Date endDate;
	    
	    @ManyToOne()
	    @JoinColumn(name="job_seeker_id")
	    private JobSeeker jobSeeker;
	    
	    public String getEndDate() {
	    	if(this.endDate == null) {
	    		return "continuing";
	    	}
			return this.endDate.toString();

	    }

}
