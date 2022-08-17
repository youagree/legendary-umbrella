package ru.vk.competition.minbenchmark.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.vk.competition.minbenchmark.dto.AddNewQueryDto;
import ru.vk.competition.minbenchmark.dto.AddNewQueryResultRequest;
import ru.vk.competition.minbenchmark.exception.BadRequestException;
import ru.vk.competition.minbenchmark.feign.SingleQueryFeign;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class SingleQueryService {

    private final SingleQueryFeign queryFeign;

    public static ConcurrentHashMap<Integer, AddNewQueryDto> singleQueryStorage = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, AddNewQueryResultRequest> resultStorage = new ConcurrentHashMap<>();

    public void addNewQueryResult(AddNewQueryResultRequest addNewQueryResultRequest) {
        resultStorage.put(addNewQueryResultRequest.getResultId(), addNewQueryResultRequest);
    }

    public void addNewQueryInStorage(Integer resultId, AddNewQueryDto addNewQueryDto) {
        AddNewQueryResultRequest addNewQueryResultRequest = resultStorage.get(resultId);

        /// TODO: 17.08.2022 НЕПОНЯТНО, потом переделать
        ResponseEntity<Void> responseEntity = queryFeign.addNewQuery(addNewQueryDto);
        checkResponse(responseEntity, addNewQueryResultRequest,
                new BadRequestException("Результат не совпадает"));
    }


    @SneakyThrows
    private void checkResponse(ResponseEntity responseEntity, AddNewQueryResultRequest expectedResult, Exception e) {
        int actualStatusCode = responseEntity.getStatusCode().value();

        if (actualStatusCode != expectedResult.getCode()) {
            throw e;
        }
    }
}
