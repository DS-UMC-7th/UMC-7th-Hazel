package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.ExistStore;

@Component
public class StoreExistsValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreRepository storeRepository;

    public StoreExistsValidator(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        // Repository에서 가게 존재 여부 확인
        return storeId != null && storeRepository.existsById(storeId);
    }
}