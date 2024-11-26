package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public MissionResponseDTO addMission(MissionRequestDTO.AddMissionDto request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Mission mission = MissionConverter.toMission(request, store);

        // 기본값 설정
        if (mission.getStatus() == null) {
            mission.setStatus(MissionStatus.NOT_STARTED);
        }

        Mission savedMission = missionRepository.save(mission);

        return MissionConverter.toMissionResponseDTO(savedMission);
    }

    @Transactional
    public void challengeMission(MissionRequestDTO.ChallengeMissionDto request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버입니다."));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));

        // 미션 상태를 'CHALLENGING'으로 변경
        mission.setStatus(MissionStatus.CHALLENGING);
        missionRepository.save(mission);

        // 상태 변경된 Mission 객체 저장
        missionRepository.save(mission);

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING) // 상태 설정
                .build();

        memberMissionRepository.save(memberMission);
    }
}