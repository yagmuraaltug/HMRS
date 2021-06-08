package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hmrs.business.abstracts.CvImageService;
import kodlamaio.hmrs.core.utilities.cloudinary.*;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvImageDao;
import kodlamaio.hmrs.entities.concretes.CvImage;

@Service
public class CvImageManager implements CvImageService{

	private CvImageDao cvImageDao;
	
	@Autowired
	public CvImageManager(CvImageDao cvImageDao, ImageService imageService) {
		super();
		this.cvImageDao = cvImageDao;
		this.imageService = imageService;
	}

	private ImageService imageService;
	
	
	@Override
	public DataResult<List<CvImage>> getAll() {
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll());

	}

	@Override
	public Result add(CvImage cvImage, MultipartFile imageFile) {
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = this.imageService.uploadFile(imageFile).getData();
		cvImage.setImageUrl(uploadImage.get("url"));
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Your photo has been added to system successfully!");
	}

	@Override
	public DataResult<List<CvImage>> findByJobSeekerId(int id) {
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.getByJobSeeker_id(id));

	}

}
