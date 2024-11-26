package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.service.StoreService.StoreQueryService;
import org.springframework.data.domain.Page;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getOngoingMissionsByMember(Long memberId, Integer page) {
        // 진행 중인 미션을 MemberMission 기준으로 조회
        Page<MemberMission> memberMissions = memberMissionRepository.findByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, PageRequest.of(page, 10));

        return memberMissions.map(MemberMission::getMission);
    }
}
