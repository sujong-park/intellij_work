package com.busanit501.helloworld.dao.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.MemberDAO;
import com.busanit501.helloworld.jdbcex.vo.MemberVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MemberDAOTest {
    private MemberDAO memberDAO;

    @BeforeEach
    public void ready() throws Exception {
        memberDAO = new MemberDAO();
    }

    // 전체 멤버 조회
    @Test
    public void testSelectMembersAll() throws Exception {
        List<MemberVO> members = memberDAO.selectMembersAll();
        members.forEach(System.out::println);
    }

    // 멤버 조회
    @Test
    public void testSelectMember() throws SQLException {
        Long userNo = 3L;
        MemberVO memberVO = memberDAO.selectMember(userNo);
        System.out.println(memberVO);
    }

    // 멤버 등록
    @Test
    public void testInsertMember() throws Exception {
        MemberVO memberVO = MemberVO.builder()
                .userId("sample")
                .userPassword("123")
                .userName("샘플 디비 작성 테스트")
                .userEmail("sample@gmail.com")
                .userPhone("01012345678")
                .dueDate(LocalDate.of(2024, 12, 31))
                .build();
        memberDAO.insertMember(memberVO);
    }

    // 멤버 수정
    @Test
    public void testUpdateMember() throws SQLException {
        // 실제 작업은 내용을 화면에서 받아오는 대신,
        // 하드 코딩으로 값을 더미로 테스트.
        MemberVO memberVO = MemberVO.builder()
                .userNo(1L)
                .userId("sample1")
                .userPassword("sample1")
                .userName("수정 테스트")
                .userEmail("sample@gmail.com")
                .userPhone("01012345678")
                .dueDate(LocalDate.of(2024, 12, 31))
                .build();
        memberDAO.updateMember(memberVO);
    }

    // 멤버 삭제
    @Test
    public void testDeleteTest() throws SQLException {
        Long userNo = 2L;
        memberDAO.deleteMember(userNo);
    }
}
