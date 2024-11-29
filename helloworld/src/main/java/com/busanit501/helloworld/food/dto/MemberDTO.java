package com.busanit501.helloworld.food.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
