package co.simplon.spotmebusiness.validation;

import co.simplon.spotmebusiness.dtos.SpotUpdate;
import co.simplon.spotmebusiness.repositories.SpotRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SpotUpdateUnicityValidator implements ConstraintValidator<SpotUpdateUnicity, SpotUpdate> {

	private final SpotRepository spotRepository;

	public SpotUpdateUnicityValidator(SpotRepository spotRepository) {
		this.spotRepository = spotRepository;
	}

	@Override
	public boolean isValid(SpotUpdate spotUpdate, ConstraintValidatorContext context) {
		String name = spotUpdate.name();
		Double longitude = spotUpdate.lng();
		Double latitude = spotUpdate.lat();
		Long id = ValidationUtils.pathVariableAsLong("id");

		if (name == null || longitude == null || latitude == null) {
			return true;
		}

//		Spot existingSpot = spotRepository.findByNameAndLngAndLat(name, longitude, latitude);
//		System.out.println(existingSpot);
//		if (existingSpot != null) {
////			context.disableDefaultConstraintViolation();
////			context.buildConstraintViolationWithTemplate("test").addConstraintViolation();
//
//			return false;
//		}
//
//		return true;

		return !spotRepository.existsByNameIgnoreCaseAndLatAndLngAndIdNot(name, latitude, longitude, id);
	}

}
