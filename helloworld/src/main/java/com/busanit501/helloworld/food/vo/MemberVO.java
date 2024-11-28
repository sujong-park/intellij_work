package com.busanit501.helloworld.food.vo;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
}
