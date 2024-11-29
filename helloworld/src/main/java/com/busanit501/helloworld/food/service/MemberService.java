package com.busanit501.helloworld.food.service;

import com.busanit501.helloworld.food.dao.MemberDAO;
import com.busanit501.helloworld.food.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.food.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

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
    public MemberDTO memberSelect(String mid) throws SQLException {
        log.info("mid : " + mid);

        MemberVO memberVO = memberDAO.selectMember(mid);
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
    public void memberDelete(String mid) throws SQLException {
        memberDAO.deleteMember(mid);
    }


    // 로그인 유효성 검사
    public MemberDTO login(String mid, String mpw) throws SQLException {
        MemberVO memberVO = memberDAO.getMemberWithMpw(mid,mpw);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }

    // 회원 uuid 생성
    public void updateUuid(String mid, String uuid) throws SQLException {
        memberDAO.updateUuid(mid,uuid);
    }

    // uuid 확인 및 정보 가져오기
    public MemberDTO getMemberWithUuidService(String uuid) throws SQLException {
        MemberVO memberVO= memberDAO.getMemberWithUuid(uuid);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }




}






