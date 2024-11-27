package com.busanit501.helloworld.jdbcex.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MemberVO {
    private Long userNo;
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
    private String userPhone;
    private LocalDate dueDate;
}
