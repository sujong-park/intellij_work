package com.busanit501.helloworld.food;

import com.busanit501.helloworld.food.dao.MemberDAO;
import com.busanit501.helloworld.food.vo.MemberVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
        String mid = "lsy";
        MemberVO memberVO = memberDAO.selectMember(mid);
        System.out.println(memberVO);
    }

    // 멤버 등록
    @Test
    public void testInsertMember() throws Exception {
        MemberVO memberVO = MemberVO.builder()
                .mid("daotest3")
                .mpw("1234")
                .mname("DAO테스트3")
                .build();
        memberDAO.insertMember(memberVO);
    }

    // 멤버 수정
    @Test
    public void testUpdateMember() throws SQLException {
        // 실제 작업은 내용을 화면에서 받아오는 대신,
        // 하드 코딩으로 값을 더미로 테스트.
        MemberVO memberVO = MemberVO.builder()
                .mid("daotest2")
                .mpw("1234")
                .mname("DAO수정")
                .build();
        memberDAO.updateMember(memberVO);
    }

    // 멤버 삭제
    @Test
    public void testDeleteTest() throws SQLException {
        String mid = "daotest3";
        memberDAO.deleteMember(mid);
    }

    // 로그인 유효성 검사
    @Test
    public void TestGetMemberWithMpw() throws SQLException {
        String mid = "daotest1";
        String mpw = "1234";
        MemberVO memberVO = memberDAO.getMemberWithMpw(mid,mpw);
    }

    // 회원 uuid 생성
    @Test
    public void TestUpdateUuid() throws SQLException {
        String uuid = UUID.randomUUID().toString();
        memberDAO.updateUuid("daotest1", uuid);
    }

    // uuid 확인 및 정보 가져오기
    @Test
    public void TestGetMemberWithUuid() throws SQLException {
        MemberVO memberVO = memberDAO.getMemberWithUuid("8ebc11c0-ed47-42ad-a073-bacf7298543d");
    }

}
