package kodlamaio.hmrs.core.utilities.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;

@Service
public class ImageManager implements ImageService{

	private Cloudinary cloudinary;
	
	public ImageManager() {
	
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				     "cloud_name","rain-consultancy",
				     "api_key", "838167715234411",
				     "api_secret","b0Uj40j8GVmJM7UKTPlvZfDUO_4"
				 
				));
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> uploadFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}

}
