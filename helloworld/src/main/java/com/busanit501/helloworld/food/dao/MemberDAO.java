package com.busanit501.helloworld.food.dao;

import com.busanit501.helloworld.food.vo.MemberVO;
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
                    .mid(resultSet.getString("mid"))
                    .mpw(resultSet.getString("mpw"))
                    .mname(resultSet.getString("mname"))
                    .build();
            memberList.add(memberVO);
        }
        return memberList;
    }

    // 멤버 조회
    public MemberVO selectMember(String mid) throws SQLException {
        String sql = "select * from tbl_member where mid = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, mid);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        MemberVO memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .build();
        return (memberVO);
    }

    // 멤버 등록
    public void insertMember(MemberVO memberVO) throws SQLException {
        String sql = "insert into tbl_member (mid, mpw, mname) " +
                "values (?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, memberVO.getMid());
        preparedStatement.setString(2, memberVO.getMpw());
        preparedStatement.setString(3, memberVO.getMname());
        preparedStatement.executeUpdate();
    }

    // 멤버 수정
    public void updateMember(MemberVO memberVO) throws SQLException {
        String sql = "update tbl_member set mid=?, mpw=?, mname=?" +
                " where mid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, memberVO.getMid());
        preparedStatement.setString(2, memberVO.getMpw());
        preparedStatement.setString(3, memberVO.getMname());
        preparedStatement.setString(4, memberVO.getMid());
        preparedStatement.executeUpdate();

    }

    // 멤버 삭제
    public void deleteMember(String mid) throws SQLException {
        String sql = "delete from tbl_member where mid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, mid);
        preparedStatement.executeUpdate();

    }

    // 로그인 유효성 검사
    public MemberVO getMemberWithMpw(String mid, String mpw) throws SQLException {
        String query = "select * from tbl_member where mid=? and mpw=?";

        MemberVO memberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .build();

        return memberVO;
    }

    // 회원 uuid 생성
    public void updateUuid(String mid, String uuid) throws SQLException {
        String query = "update tbl_member set uuid=? where mid=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, uuid);
        preparedStatement.setString(2, mid);
        preparedStatement.executeUpdate();
    } //

    // uuid 확인 및 정보 가져오기
    public MemberVO getMemberWithUuid(String uuid) throws SQLException {
        String query = "select * from tbl_member where uuid=?";
        // 결과 데이터를 담아둘 임시 박스 MemberVO
        MemberVO memberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, uuid);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .uuid(resultSet.getString("uuid"))
                .build();

        return memberVO;
    }


} //class

