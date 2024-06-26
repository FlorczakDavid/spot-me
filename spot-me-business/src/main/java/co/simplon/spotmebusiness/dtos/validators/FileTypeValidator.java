package co.simplon.spotmebusiness.dtos.validators;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileTypeValidator implements ConstraintValidator<FileType, MultipartFile> {

//	public ImageTypeValidator(SpotService service) {
//		this.service = service;
//	}
	private ArrayList<String> acceptedTypes = new ArrayList<String>();

	@Override
	public void initialize(FileType fileType) {
		acceptedTypes = new ArrayList<String>(Arrays.asList(fileType.acceptedTypes()));
	}

	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		String fileType = value.getContentType();
		return acceptedTypes.contains(fileType);
	}

}
