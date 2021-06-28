package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvImage;

public interface CvImageService {

	DataResult<List<CvImage>>  findByJobSeekerId(int id);
	DataResult<List<CvImage>> getAll();
    Result add(CvImage cvImage,  MultipartFile imageFile);
    Result update(CvImage cvImage);
	Result delete(int id);
}
