package umc.study.service.MemberService;

import umc.study.domain.Member;
import umc.study.web.dto.MemberRequestDTO;

public abstract class MemberCommandService {
    public abstract Member joinMember(MemberRequestDTO.JoinDto request);
}
