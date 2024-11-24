package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.foodCategory;

public interface FoodCategoryRepository extends JpaRepository<foodCategory, Long> {
}