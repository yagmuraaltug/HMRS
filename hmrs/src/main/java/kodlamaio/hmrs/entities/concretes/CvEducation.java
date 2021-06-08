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
@Table(name="cv_educations")
@AllArgsConstructor
@NoArgsConstructor

public class CvEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id;

    
    @Column(name="school_name")
	private String schoolName;
    
    
    @Column(name="school_department")
	private String schoolDepartment;
    
    @Column(name="graduation_date")
	private Date graduationDate;

    
    @ManyToOne()
    @JoinColumn(name="job_seeker_id")
    private JobSeeker jobSeeker;
    
    public String getGraduationDate() {
    	if(this.graduationDate == null) {
    		return "continuing";
    	}
		return this.graduationDate.toString();

    }
}


