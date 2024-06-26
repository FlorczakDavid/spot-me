package co.simplon.spotmebusiness.dtos.validators;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {

//	public ImageTypeValidator(SpotService service) {
//		this.service = service;
//	}
	private long max = 0;

	@Override
	public void initialize(FileSize fileSize) {
		max = fileSize.max();
	}

	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		Boolean result = (value.getSize() < max);
		return result;
	}

}
