package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cities")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType .IDENTITY)
	@Column(name = "city_id")
	private Integer cityId;
	
	@Column(name = "city_name")
    private String cityName;
	
	@OneToMany(mappedBy = "city")
	private List<JobAdvert> jobAdverts;

}
