package umc.study.service.MissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;

public interface MissionQueryService {
    // 9주차 미션 3 - 내가 (특정 유저가) 진행 중인 미션 목록 조회
    Page<Mission> getOngoingMissionsByMember(Long memberId, Integer page);
}
