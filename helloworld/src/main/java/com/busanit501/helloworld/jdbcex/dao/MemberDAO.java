package com.busanit501.helloworld.jdbcex.dao;

import com.busanit501.helloworld.food.dao.ConnectionUtil;
import com.busanit501.helloworld.food.vo.FoodVO;
import com.busanit501.helloworld.jdbcex.vo.MemberVO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    // 전체 멤버 조회
    public List<MemberVO> selectMembersAll() throws SQLException {
        String sql = "select * from tbl_member";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<MemberVO> memberList = new ArrayList<>();
        while (resultSet.next()) {
            MemberVO memberVO = MemberVO.builder()
                    .userNo(resultSet.getLong("userNo"))
                    .userId(resultSet.getString("userId"))
                    .userPassword(resultSet.getString("userPassword"))
                    .userName(resultSet.getString("userName"))
                    .userEmail(resultSet.getString("userEmail"))
                    .userPhone(resultSet.getString("userPhone"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .build();
            memberList.add(memberVO);
        }
        return memberList;
    }

    // 멤버 조회
    public MemberVO selectMember(Long userNo) throws SQLException {
        String sql = "select * from tbl_member where userNo = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, userNo);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        MemberVO memberVO = MemberVO.builder()
                .userNo(resultSet.getLong("userNo"))
                .userId(resultSet.getString("userId"))
                .userPassword(resultSet.getString("userPassword"))
                .userName(resultSet.getString("userName"))
                .userEmail(resultSet.getString("userEmail"))
                .userPhone(resultSet.getString("userPhone"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .build();
        return (memberVO);
    }

    // 멤버 등록
    public void insertMember(MemberVO memberVO) throws SQLException {
        String sql = "insert into tbl_member (userId, userPassword, userName, userEmail, userPhone, dueDate) " +
                "values (?, ?, ?, ?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, memberVO.getUserId());
        preparedStatement.setString(2, memberVO.getUserPassword());
        preparedStatement.setString(3, memberVO.getUserName());
        preparedStatement.setString(4, memberVO.getUserEmail());
        preparedStatement.setString(5, memberVO.getUserPhone());
        preparedStatement.setDate(6, Date.valueOf(memberVO.getDueDate()));
        preparedStatement.executeUpdate();
    }

    // 멤버 수정
    public void updateMember(MemberVO memberVO) throws SQLException {
        String sql = "update tbl_member set userId=?, userPassword=?, userName=?, userEmail=?, userPhone=?, dueDate=?" +
                " where userNo = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, memberVO.getUserId());
        preparedStatement.setString(2, memberVO.getUserPassword());
        preparedStatement.setString(3, memberVO.getUserName());
        preparedStatement.setString(4, memberVO.getUserEmail());
        preparedStatement.setString(5, memberVO.getUserPhone());
        preparedStatement.setDate(6, Date.valueOf(memberVO.getDueDate()));
        preparedStatement.setLong(7, memberVO.getUserNo());
        preparedStatement.executeUpdate();

    }

    // 멤버 삭제
    public void deleteMember(Long userNo) throws SQLException {
        String sql = "delete from tbl_member where userNo = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1, userNo);
        preparedStatement.executeUpdate();

    }

} //class

