package co.simplon.spotmebusiness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.spotmebusiness.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByNameIgnoreCase(String categoryName);

}
