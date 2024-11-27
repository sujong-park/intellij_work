package com.busanit501.helloworld.food.dao;

import com.busanit501.helloworld.food.vo.FoodVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {

    public String getTime() {
        String now = null;

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            resultSet.next();
            now = resultSet.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        } //catch
        return now;
    } //getTime

    public String getTime2() throws SQLException {
        String now = null;
        // 자동으로 디비의 connection 반납하는 방법2
        // @Cleanup
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select now()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        now = resultSet.getString(1);
        return now;
    }

    // 전체 조회
    public List<FoodVO> selectAll() throws SQLException {
        String sql = "select * from tbl_food";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<FoodVO> list = new ArrayList<>();
        while (resultSet.next()) {
            FoodVO foodVO = FoodVO.builder()
                    .fno(resultSet.getLong("fno"))
                    .foodName(resultSet.getString("foodName"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();
            list.add(foodVO);
        }
        return list;
    }

    // 하나 조회
    public FoodVO selectOne(Long fno) throws SQLException {
        String sql = "select * from tbl_food where fno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, fno);
        // 하나만 받아온 상태,
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        // 임시 TotoVO , 인스턴스 만들어서, 한행의 각 컬럼 4개를 담기.
        // 0행에서 -> 1행으로 조회를 해야하는데, 요게 누락됨.
        resultSet.next();
        FoodVO foodVO = FoodVO.builder()
                .fno(resultSet.getLong("fno"))
                .foodName(resultSet.getString("foodName"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();
        return foodVO;
    }

    // 등록
    public void insert(FoodVO foodVO) throws SQLException {
        String sql = "insert into tbl_food (foodName, dueDate, finished) " +
                "values (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, foodVO.getFoodName());
        preparedStatement.setDate(2, Date.valueOf(foodVO.getDueDate()));
        preparedStatement.setBoolean(3, foodVO.isFinished());
        preparedStatement.executeUpdate();
    } //insert

    // 수정
    public void updateOne(FoodVO foodVO) throws SQLException {
        String sql = "update tbl_food set foodName=?, dueDate=?, finished=?" +
                " where fno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, foodVO.getFoodName());
        preparedStatement.setDate(2, Date.valueOf(foodVO.getDueDate()));
        preparedStatement.setBoolean(3, foodVO.isFinished());
        preparedStatement.setLong(4, foodVO.getFno());
        preparedStatement.executeUpdate();

    }

    // 삭제
    public void deleteOne(Long fno) throws SQLException {
        String sql = "delete from tbl_food where fno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, fno);
        preparedStatement.executeUpdate();

    }


} //class
