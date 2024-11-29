package com.busanit501.helloworld.food.filter;

import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//톰캣 서버에서,
// 한글로 입력된 내용을, UTF8로 변환해서 보내기.
// 필터, 서버에 작업을 실행하기전에, 먼저 검사한다.
// 유효성 체크.
@WebFilter(urlPatterns = {"/food/*"})
@Log4j2
public class LoginFoodFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        if(session.isNew()) {
            response.sendRedirect("/login");
            return;
        }
        if(session.getAttribute("loginInfo") == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Cookie findCookie = findCookie(request.getCookies(), "rememberMe");
        if(findCookie == null) {
            response.sendRedirect("/login");
            return;
        }

        String getUuid = findCookie.getValue();

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.getMemberWithUuidService(getUuid);

            if(memberDTO == null) {
                throw new Exception("쿠키값이 유효하지 않습니다.");
            }
            session.setAttribute("loginInfo", memberDTO);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/login");
        }

        if(session.getAttribute("loginInfo") != null) {
            MemberDTO memberDTO  = (MemberDTO) session.getAttribute("loginInfo");
            log.info("session.getAttribute(\"loginInfo\") memberDTO : " + memberDTO);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Cookie findCookie(Cookie[] cookies, String name) {
        Cookie findCookie = null;
        // 쿠키가 있는 경우
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // cookie.getName(): 전체 쿠키 목록 요소의 이름
                // name : 찾고자하는 쿠키 이름.
                if (cookie.getName().equals(name)) {
                    findCookie = cookie;
                    break;
                } //if
            } // for
        } // if
        return findCookie;
    } // method
}
