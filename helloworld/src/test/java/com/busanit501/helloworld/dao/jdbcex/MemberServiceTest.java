package com.busanit501.helloworld.dao.jdbcex;

import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.service.MemberService;
import com.busanit501.helloworld.jdbcex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;
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
        MemberDTO memberDTO = memberService.memberSelect(4L);
        log.info("TodoList 하나 조회" + memberDTO);
    }

    // 멤버 등록
    @Test
    public void testInsert() throws SQLException {
        MemberDTO memberDTO = MemberDTO.builder()
                .userId("샘플 작업 service")
                .userPassword("123")
                .userName("서비스 샘플")
                .userEmail("12")
                .userPhone("564684623")
                .dueDate(LocalDate.now())
                .build();
        memberService.memberRegister(memberDTO);
    }

    // 멤버 수정
    @Test
    public void testUpdate() throws SQLException {
        //
        MemberDTO memberDTO = MemberDTO.builder()
                .userNo(3L)
                .userId("update")
                .userPassword("123")
                .userName("수정된 내용입니다.")
                .userEmail("")
                .userPhone("")
                .dueDate(LocalDate.now())
                .build();
        memberService.memberUpdate(memberDTO);
    }

    // 멤버 삭제
    @Test
    public void testDelete() throws SQLException {
        memberService.memberDelete(4L);
    }


}
