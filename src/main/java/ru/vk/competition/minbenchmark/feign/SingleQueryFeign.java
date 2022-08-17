package ru.vk.competition.minbenchmark.feign;

import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vk.competition.minbenchmark.dto.AddNewQueryDto;

@FeignClient(name = "/api/single-query")
public interface SingleQueryFeign {

    @PostMapping(value = "/add-new-query")
    ResponseEntity<Void> addNewQuery(@RequestBody AddNewQueryDto addNewQueryDto);
}
