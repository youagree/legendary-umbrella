package ru.vk.competition.minbenchmark.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddNewQueryDto {
    private Integer queryId;
    private String query;
}
