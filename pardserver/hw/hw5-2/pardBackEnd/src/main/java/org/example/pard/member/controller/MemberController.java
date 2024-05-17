package org.example.pard.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.entity.Member;
import org.example.pard.member.service.MemberService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;



// 요청 주소 매핑을 해주는 역할
// 서비스 단으로 리퀘스트를 넘겨준다.
// 최종 렌더링을 도와준다.
@RestController
@RequiredArgsConstructor
@RequestMapping("/pard") // '/pard' is the base path 
//@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
//@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"}, allowCredentials = "true")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public String createMember(@RequestBody MemberCreateDTO dto) {
        memberService.createMember(dto);
        return "파드에 가입을 축하드립니다.";
    }

    @GetMapping("")
    public List<MemberReadDTO> findMember(@RequestParam(required = false) String part) {
        if (StringUtils.hasText(part)) {
            return memberService.findByPart(part);
        }

        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public MemberReadDTO findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return "삭제됨";
    }


    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody MemberCreateDTO memberCreateDTO){
        memberService.update(id, memberCreateDTO);

    }
}
