package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.MissionStatus;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStoreId(Long storeId, PageRequest pageRequest);
}