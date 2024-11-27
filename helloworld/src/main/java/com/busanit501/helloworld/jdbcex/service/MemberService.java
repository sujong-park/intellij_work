package com.busanit501.helloworld.jdbcex.service;

import com.busanit501.helloworld.jdbcex.dao.MemberDAO;
import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.jdbcex.vo.MemberVO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 전체 멤버 조회
    public List<MemberDTO> membersAllSelect() throws SQLException {
        List<MemberVO> voMemberList = memberDAO.selectMembersAll();
        log.info("voList : " + voMemberList);

        List<MemberDTO> dtoMemberList = voMemberList.stream().map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        return dtoMemberList;
    }

    // 멤버 조회
    public MemberDTO memberSelect(Long userNo) throws SQLException {
        log.info("userNo : " + userNo);

        MemberVO memberVO = memberDAO.selectMember(userNo);
        MemberDTO memberDTO = modelMapper.map(memberVO,MemberDTO.class);
        return memberDTO;
    }

    // 멤버 등록
    public void memberRegister(MemberDTO memberDTO) throws SQLException {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        log.info("memberVo : " + memberVO);
        memberDAO.insertMember(memberVO);
    }

    // 멤버 수정
    public void memberUpdate(MemberDTO memberDTO) throws SQLException {
        log.info("memberDTO : " + memberDTO);

        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.updateMember(memberVO);
    }

    // 멤버 삭제
    public void memberDelete(Long userNo) throws SQLException {
        memberDAO.deleteMember(userNo);
    }
}






