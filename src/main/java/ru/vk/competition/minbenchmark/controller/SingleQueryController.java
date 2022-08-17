package ru.vk.competition.minbenchmark.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vk.competition.minbenchmark.dto.AddNewQueryDto;
import ru.vk.competition.minbenchmark.dto.AddNewQueryResultRequest;
import ru.vk.competition.minbenchmark.dto.GetAllSingleQueriesDto;
import ru.vk.competition.minbenchmark.service.SingleQueryService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/single-query")
@RequiredArgsConstructor
public class SingleQueryController {

    private final SingleQueryService singleQueryService;

    @GetMapping("/add-new-query-result")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addNewQueryResult(@RequestBody AddNewQueryResultRequest addNewQueryResultRequest) {
        //todo code 400 or 202
        return;
    }

    @PostMapping("/add-new-query")
    public void addNewQuery(@RequestParam Integer resultId,
                            @RequestBody AddNewQueryDto addNewQueryDto) {
        // TODO: 400 or 201
        return;
    }

    @PostMapping("/add-modify-result")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addModifyResult(@RequestBody AddNewQueryResultRequest addNewQueryResultRequest) {
        singleQueryService.addModifyResult(addNewQueryResultRequest);
    }

    @PutMapping("/modify-single-query")
    public void modifySingleQuery(@RequestParam Integer resultId,
                                  @RequestBody AddNewQueryDto addNewQueryDto) {
        singleQueryService.modifySingleQuery(resultId, addNewQueryDto);
    }

    @PostMapping("/add-delete-result")
    public void addDeleteResult(@RequestBody AddNewQueryResultRequest addNewQueryResultRequest) {
       singleQueryService.addDeleteResult(addNewQueryResultRequest);
    }

    @DeleteMapping("/delete-single-query-by-id/{id}")
    public void deleteSingleQueryById(@PathVariable Integer id, @RequestParam Integer resultId) {
        return;
    }

    @PostMapping("/add-execute-result")
    public void addExecuteResult(@RequestBody AddNewQueryResultRequest addNewQueryResultRequest) {

    }

    @GetMapping("/execute-single-query-by-id/{id}")
    public void executeSingleQueryById(@PathVariable Integer id, @RequestParam Integer resultId){

    }

    @PostMapping("/add-get-single-query-by-id-result")
    public void addGetSingleQueryByIdResult(@RequestBody AddNewQueryResultRequest addNewQueryResultRequest) {
        return;
    }

    @GetMapping("/get-single-query-by-id/{id}")
    public AddNewQueryDto getSingleQueryById(@PathVariable Integer id, @RequestParam Integer resultId) {
        return new AddNewQueryDto();
    }

    @GetMapping("/get-all-single-queries")
    public GetAllSingleQueriesDto getAllSingleQueries() {
        return null;
    }

}