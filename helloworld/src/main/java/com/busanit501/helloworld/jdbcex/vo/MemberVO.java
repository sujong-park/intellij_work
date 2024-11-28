package com.busanit501.helloworld.jdbcex.vo;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
