package kodlamaio.hmrs.core.utilities.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;

public interface ImageService {

	@SuppressWarnings({ "rawtypes"})
	DataResult<Map> uploadFile(MultipartFile imageFile);
}
