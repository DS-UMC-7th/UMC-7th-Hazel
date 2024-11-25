package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO> addMission(@RequestBody @Valid MissionRequestDTO.AddMissionDto request) {
        MissionResponseDTO response = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(response);
    }

    // 미션 성공
    @PostMapping("/challenge")
    public ApiResponse<String> challengeMission(@RequestBody @Valid MissionRequestDTO.ChallengeMissionDto request) {
        missionCommandService.challengeMission(request);
        return ApiResponse.onSuccess("미션 도전에 성공했습니다.");
    }
}