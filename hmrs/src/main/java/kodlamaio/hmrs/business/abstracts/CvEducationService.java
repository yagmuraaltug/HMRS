package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvEducation;

public interface CvEducationService {

	DataResult<List<CvEducation>>  findByJobSeekerId(int id);
    Result add(CvEducation cvEducation);
    DataResult<List<CvEducation>> getAllByJobSeeker_idOrderByGraduationDateDesc(int id);
    Result delete(int id);
    Result update(CvEducation cvEducation);

}
