package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.MemberDAO;
import com.busanit501.helloworld.jdbcex.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.UUID;

@Log4j2
public class MemberDAOTest {
    private MemberDAO memberDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }

    @Test
    public void getMemberWithMpwTest() throws SQLException {
        String mid = "lsy";
        String mpw = "1234";
        MemberVO memberVO = memberDAO.getMemberWithMpw(mid,mpw);
    }

    @Test
    public void updateUuidTest() throws SQLException {
        String uuid = UUID.randomUUID().toString();
        log.info("uuid 랜덤 문자열 샘플 : " + uuid);
        memberDAO.updateUuid("lsy", uuid);
    }

    @Test
    public void getMemberWithUuidTest() throws SQLException {

        // 각자 테이블의 유저의uuid를 직접 복사해서 붙여넣기.
        // 각각 전부 다 달라요.
        MemberVO memberVO = memberDAO.getMemberWithUuid("1e7bc836-f43b-4e5d-89d8-7c56a153c3d8");
        log.info("memberVO : " + memberVO);

    }

}
