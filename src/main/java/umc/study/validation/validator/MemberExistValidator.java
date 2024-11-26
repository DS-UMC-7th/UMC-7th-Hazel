package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.study.repository.MemberRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistStore;

public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {
    private MemberRepository memberRepository;

    @Override
    public boolean isValid(Long memberId, ConstraintValidatorContext context) {
        // memberId가 null이 아니고, 해당 멤버가 존재하는지 확인
        return memberId != null && memberRepository.existsById(memberId);
    }
}