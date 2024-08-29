package co.simplon.spotmebusiness.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.spotmebusiness.dtos.SpotView;
import co.simplon.spotmebusiness.entities.Spot;

@Repository // optional
public interface SpotRepository extends JpaRepository<Spot, Long> {

	Collection<SpotView> findProjectedBy(); // Query Method

	Spot findByNameAndLngAndLat(String name, Double lng, Double lat);

	Boolean existsByNameIgnoreCaseAndLatAndLng(String name, Double lng, Double lat);

	/*
	 * Derived query/Query method Verifies if spot exists with same name/lat/lng BUT
	 * not with the given id
	 */
	Boolean existsByNameIgnoreCaseAndLatAndLngAndIdNot(String name, Double lng, Double lat, Long id);
}
