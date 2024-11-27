package com.busanit501.helloworld.jdbcex.service;

import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

// 설정1
@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    TodoService() {
        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 전체 조회
    public List<TodoDTO> listAll() throws SQLException {
        List<TodoVO> voList = todoDAO.selectAll();
        log.info("voList : " + voList);

        List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    // 등록
    public void register(TodoDTO todoDTO) throws SQLException {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info("todoVo : " + todoVO);
        todoDAO.insert(todoVO);
    } // register

    // 하나 조회
    public TodoDTO get(Long tno) throws SQLException {
        log.info("tno : " + tno);
        ///  디비에서 하나 조회 결과 받았음.
        TodoVO todoVO = todoDAO.selectOne(tno);
        // VO -> DTO 변환 작업.
        TodoDTO todoDTO = modelMapper.map(todoVO,TodoDTO.class);
        return todoDTO;

    }

    // 수정
    public void update(TodoDTO todoDTO) throws SQLException {
        log.info("todoDTO : " + todoDTO);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoDAO.updateOne(todoVO);

    }

    // 삭제
    public void delete(Long tno) throws SQLException {
        todoDAO.deleteTodo(tno);
    }



}






