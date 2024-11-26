package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

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

    // 내가 (특정 유저가) 진행 중인 미션 목록 조회
    @GetMapping("/challenging/{memberId}")
    @Operation(summary = "특정 유저의 진행 중인 미션 목록 조회 API",description = "특정 유저의 진행 중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<Page<MissionResponseDTO>> getOngoingMissionsByMember(@ExistMember @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page) {
        // 진행 중인 미션을 가져옴
        Page<Mission> ongoingMissions = missionQueryService.getOngoingMissionsByMember(memberId, page);
        // Mission을 MissionResponseDTO로 변환
        Page<MissionResponseDTO> response = ongoingMissions.map(MissionConverter::toMissionResponseDTO);

        return ApiResponse.onSuccess(response);
    }
}