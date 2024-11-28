package com.busanit501.helloworld.food;

import com.busanit501.helloworld.food.dto.MemberDTO;
import com.busanit501.helloworld.food.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Log4j2
public class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    public void ready() {
        memberService = MemberService.INSTANCE;
    }

    // 전체 멤버 조회
    @Test
    public void testSelectAll() throws SQLException {
        List<MemberDTO> dtoMemberList = memberService.membersAllSelect();
        for (MemberDTO memberDTO:dtoMemberList) {
            log.info(memberDTO);
        }
    }

    // 멤버 조회
    @Test
    public void testSelectOne() throws SQLException {
        MemberDTO memberDTO = memberService.memberSelect("lsy");
        log.info("TodoList 하나 조회" + memberDTO);
    }

    // 멤버 등록
    @Test
    public void testInsert() throws SQLException {
        MemberDTO memberDTO = MemberDTO.builder()
                .mid("servicetest3")
                .mpw("123")
                .mname("Service테스트2")
                .build();
        memberService.memberRegister(memberDTO);
    }

    // 멤버 수정
    @Test
    public void testUpdate() throws SQLException {
        MemberDTO memberDTO = MemberDTO.builder()
                .mid("servicetest2")
                .mpw("123")
                .mname("Service수정")
                .build();
        memberService.memberUpdate(memberDTO);
    }

    // 멤버 삭제
    @Test
    public void testDelete() throws SQLException {
        memberService.memberDelete("servivcetest3");
    }


}
