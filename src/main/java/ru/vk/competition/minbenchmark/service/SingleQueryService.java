package ru.vk.competition.minbenchmark.service;

import org.springframework.stereotype.Service;
import ru.vk.competition.minbenchmark.dto.AddNewQueryResultRequest;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class SingleQueryService {

    public static ConcurrentHashMap<Integer, String> singleQueryStorage = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, AddNewQueryResultRequest> resultStorage = new ConcurrentHashMap<>();


}
