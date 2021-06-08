package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv_images")
@AllArgsConstructor
@NoArgsConstructor
public class CvImage {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id;
  
    @Column(name="image_url")
	private String imageUrl;
    
    
    @OneToOne()
    @JoinColumn(name="job_seeker_id", referencedColumnName = "user_id")
    private JobSeeker jobSeeker;
}
