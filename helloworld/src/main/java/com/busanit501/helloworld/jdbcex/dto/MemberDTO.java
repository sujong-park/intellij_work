package com.busanit501.helloworld.jdbcex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MemberDTO {
    private Long userNo;
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
    private String userPhone;
    private LocalDate dueDate;
}
