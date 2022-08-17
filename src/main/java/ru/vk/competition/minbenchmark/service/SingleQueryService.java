package ru.vk.competition.minbenchmark.service;

import org.springframework.stereotype.Service;
import ru.vk.competition.minbenchmark.dto.AddNewQueryDto;
import ru.vk.competition.minbenchmark.dto.AddNewQueryResultRequest;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class SingleQueryService {

    public static ConcurrentHashMap<Integer, AddNewQueryDto> singleQueryStorage = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, AddNewQueryResultRequest> resultStorage = new ConcurrentHashMap<>();

    public void addNewQueryResult(AddNewQueryResultRequest addNewQueryResultRequest) {
        resultStorage.put(addNewQueryResultRequest.getResultId(), addNewQueryResultRequest);
    }

    public void addNewQueryInStorage(Integer resultId, AddNewQueryDto addNewQueryDto) {
        resultStorage.get(resultId);

    }
}
