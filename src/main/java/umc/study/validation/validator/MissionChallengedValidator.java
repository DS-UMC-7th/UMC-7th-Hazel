package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.study.repository.MemberMissionRepository;
import umc.study.validation.annotation.ExistMission;


@RequiredArgsConstructor
public class MissionChallengedValidator implements ConstraintValidator<ExistMission, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        return missionId != null && !memberMissionRepository.existsByMissionId(missionId);
    }
}