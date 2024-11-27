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

public class FoodDTO {
    private Long fno;
    private String foodName;
    private LocalDate dueDate;
    private boolean finished;

}
