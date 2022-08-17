package ru.vk.competition.minbenchmark.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetAllSingleQueriesDto {
    private List<AddNewQueryDto> querysList;
}
