package com.busanit501.helloworld.food;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Log4j2
public class FoodServiceTest {
    private FoodService foodService;

    @BeforeEach
    public void ready() {
        foodService = FoodService.INSTANCE;
    }

    // 전체 조회
    @Test
    public void testSelectAll() throws SQLException {
        List<FoodDTO> dtoList = foodService.getAllFoods();

        for (FoodDTO foodDTO: dtoList) {
            log.info(foodDTO);
        }
    }

    // 입력
    @Test
    public void testInsert() throws SQLException {
        FoodDTO foodDTO = FoodDTO.builder()
                .foodName("샘플 작업 1126")
                .dueDate(LocalDate.now())
                .build();
        foodService.addFood(foodDTO);
    }

    // 하나조회
    @Test
    public void testSelectOne() throws SQLException {
        FoodDTO foodDTO = foodService.getFood(15L);

    }

    // 수정
    @Test
    public void updateTest() throws SQLException {
        FoodDTO foodDTO = FoodDTO.builder()
                .fno(15L)
                .foodName("수정된 내용")
                .finished(true)
                .dueDate(LocalDate.of(2024, 11, 25))
                .build();
        foodService.updateFood(foodDTO);
    }

    // 삭제
    @Test
    public void deleteTest() throws SQLException {
       foodService.deleteFood(15L);
    }


}
