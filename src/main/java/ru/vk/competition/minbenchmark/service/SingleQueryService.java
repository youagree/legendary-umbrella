package ru.vk.competition.minbenchmark.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.vk.competition.minbenchmark.dto.AddNewQueryDto;
import ru.vk.competition.minbenchmark.dto.AddNewQueryResultRequest;
import ru.vk.competition.minbenchmark.exception.AddNewQueryResultException;
import ru.vk.competition.minbenchmark.exception.BadRequestException;
import ru.vk.competition.minbenchmark.feign.SingleQueryFeign;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class SingleQueryService {
    private final SingleQueryFeign queryFeign;

    public static ConcurrentHashMap<Integer, AddNewQueryDto> singleQueryStorage = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, AddNewQueryResultRequest> resultStorage = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, AddNewQueryResultRequest> modifyResultStorage = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, AddNewQueryResultRequest> deleteResultStorage = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, AddNewQueryResultRequest> executeResultStorage = new ConcurrentHashMap<>();

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

    public void modifySingleQuery(Integer resultId, AddNewQueryDto addNewQueryDto) {
        AddNewQueryDto exist = singleQueryStorage.get(addNewQueryDto.getQueryId());
        if (exist != null) {
            singleQueryStorage.put(addNewQueryDto.getQueryId(), addNewQueryDto);
            //todo call feign
            // return result
            // change result in resultStorage
            //????
        } else {
            throw new RuntimeException("problem while modify single query result");
        }
    }

    public void addModifyResult(AddNewQueryResultRequest addNewQueryResultRequest) {
        AddNewQueryResultRequest exist = resultStorage.get(addNewQueryResultRequest.getResultId());
        if (exist != null) {
            exist.setResultId(addNewQueryResultRequest.getCode());
            resultStorage.put(addNewQueryResultRequest.getResultId(), addNewQueryResultRequest);
        } else {
            throw new AddNewQueryResultException("problem while modify result");
        }
    }

    public void addDeleteResult(AddNewQueryResultRequest addNewQueryResultRequest) {
//        singleQueryStorage.
        try {
            singleQueryStorage.remove(addNewQueryResultRequest.getResultId());
        } catch (NullPointerException e) {

        }

    }
}
