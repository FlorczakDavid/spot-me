package co.simplon.spotmebusiness.services;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import co.simplon.spotmebusiness.dtos.SpotUpdate;
import co.simplon.spotmebusiness.dtos.SpotView;
import co.simplon.spotmebusiness.entities.Category;
import co.simplon.spotmebusiness.entities.Spot;
import co.simplon.spotmebusiness.repositories.CategoryRepository;
import co.simplon.spotmebusiness.repositories.SpotRepository;

@Service
public class SpotService {

	@Value("${spotmebusiness.upload.dest}")
	private String uploadDest;

	private final SpotRepository spots;
	private final CategoryRepository categories;

	public SpotService(SpotRepository spots, CategoryRepository categories) {
		this.spots = spots;
		this.categories = categories;
	}

	@Transactional
	public void create(SpotCreate inputs) {
		Spot entity = new Spot();
		entity.setName(inputs.name());
		entity.setDescription(inputs.description());
		entity.setLat(inputs.lat());
		entity.setLng(inputs.lng());
		if (inputs.image() != null) {
			String imageId = buildImageId(inputs.image());
			storeImage(inputs.image(), imageId);
			entity.setImageId(imageId);
		}
		// Handle category
		String categoryName = inputs.categoryName();
		Category category = categories.findByNameIgnoreCase(categoryName);
		if (category == null) { // Create
			category = new Category();
			category.setName(categoryName);
			categories.save(category);
		}
		entity.setCategory(category);
		spots.save(entity); // update de max length de la colonne dans le modele/schema bdd

	}

	private String buildImageId(MultipartFile image) {
		UUID uuid = UUID.randomUUID(); // UUID
		String name = image.getOriginalFilename();
		int index = name.lastIndexOf('.');
		String ext = name.substring(index, name.length());
		return uuid + ext;
	}

	private void storeImage(MultipartFile image, String imageId) {
		try {
			String dest = String.format("%s/%s", uploadDest, imageId);
			File file = new File(dest);
			image.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Collection<SpotView> getAll() {
		return spots.findProjectedBy();
	}

	public void deleteOne(Long id) {
		spots.deleteById(id);

	}

	public void updateSpot(Long id, SpotUpdate inputs) {
		Spot entity = spots.findById(id).get();
		entity.setName(inputs.name());
		entity.setDescription(inputs.description());
		entity.setLat(inputs.lat());
		entity.setLng(inputs.lng());
		spots.save(entity); // update de max length de la colonne dans le modele/schema bdd
	}

}
