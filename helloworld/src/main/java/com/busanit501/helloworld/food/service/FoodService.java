package com.busanit501.helloworld.food.service;

import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.vo.FoodVO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


@Log4j2
public enum FoodService {
    INSTANCE;

    private FoodDAO foodDAO;
    private ModelMapper modelMapper;

    FoodService(){
        foodDAO = new FoodDAO();
        modelMapper = new ModelMapper();
    }

    // 조회
    public List<FoodDTO> getAllFoods() throws SQLException {
        List<FoodVO> voList = foodDAO.selectAll();

        List<FoodDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, FoodDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    // 등록
    public void addFood(FoodDTO foodDTO) throws SQLException {
        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        foodDAO.insert(foodVO);
    }

    // 하나 조회
    public FoodDTO getFood(Long fno) throws SQLException {
        FoodVO foodVO = foodDAO.selectOne(fno);
        FoodDTO foodDTO = modelMapper.map(foodVO, FoodDTO.class);
        return foodDTO;
    }

    // 수정
    public void updateFood(FoodDTO foodDTO) throws SQLException {
        log.info("foodDTO : " + foodDTO);

        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        foodDAO.updateOne(foodVO);
    }

    // 삭제
    public void deleteFood(Long fno) throws SQLException {
        foodDAO.deleteOne(fno);
    }

}
