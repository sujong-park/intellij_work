package com.busanit501.helloworld.food;

import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.food.vo.FoodVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class FoodDAOTest {
    private FoodDAO foodDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        foodDAO = new FoodDAO();
    }

    @Test
    public void getTime() {
        System.out.println("sql 전달 후, 시간 조회 확인용: " + foodDAO.getTime());
    }

    @Test
    public void getTime2() throws SQLException {
        System.out.println("sql 전달 후, " +
                "시간 조회 확인용: 자동 반납 @Cleanup 확인 " + foodDAO.getTime2());
    }

    @Test
    public void insetTest() throws Exception {
        FoodVO foodVO = FoodVO.builder()
                .foodName("샘플 데이터 추가1234")
                .dueDate(LocalDate.now())
                .finished(false)
                .build();

        foodDAO.insert(foodVO);
    }

    //2, 전체 목록 조회 테스트
    @Test
    public void testList() throws SQLException {
        List<FoodVO> list = foodDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    //3, 하나 조회 테스트
    @Test
    public void getOneTest() throws SQLException {
        Long tno = 3L;
        FoodVO foodVO = foodDAO.selectOne(tno);
        System.out.println(foodVO);
    }

    // 삭제테스트
    @Test
    public void deleteTest() throws SQLException {
        Long fno = 10L;
        foodDAO.deleteOne(fno);
    }

    // 수정테스트
    @Test
    public void updateTest() throws SQLException {
        FoodVO foodVO = FoodVO.builder()
                .fno(9L)
                .foodName("수정 테스트")
                .finished(true)
                .dueDate(LocalDate.of(2024, 11, 25))
                .build();

        foodDAO.updateOne(foodVO);
    }

}
