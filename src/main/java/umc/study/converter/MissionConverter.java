package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.AddMissionDto request, Store store) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO toMissionResponseDTO(Mission mission) {
        return new MissionResponseDTO(
                mission.getId(),
                mission.getReward(),
                mission.getDeadline(),
                mission.getMissionSpec(),
                mission.getStore().getId()
        );
    }
}