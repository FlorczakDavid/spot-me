package co.simplon.spotmebusiness.validation;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import co.simplon.spotmebusiness.entities.Spot;
import co.simplon.spotmebusiness.repositories.SpotRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SpotUnicityValidator implements ConstraintValidator<SpotUnicity, SpotCreate> {

	private final SpotRepository spotRepository;

	public SpotUnicityValidator(SpotRepository spotRepository) {
		this.spotRepository = spotRepository;
	}

	@Override
	public boolean isValid(SpotCreate spotCreate, ConstraintValidatorContext context) {
		String name = spotCreate.name();
		Double longitude = spotCreate.lng();
		Double latitude = spotCreate.lat();

		if (name == null || longitude == null || latitude == null) {
			return true;
		}

		Spot existingSpot = spotRepository.findByNameAndLngAndLat(name, longitude, latitude);
		System.out.println(existingSpot);
		if (existingSpot != null) {
//			context.disableDefaultConstraintViolation();
//			context.buildConstraintViolationWithTemplate("test").addConstraintViolation();

			return false;
		}

		return true;

//		return !spotRepository.existsByNameIgnoreCaseAndLatAndLng(name, latitude, longitude);
	}

}
