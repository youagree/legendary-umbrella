package ru.vk.competition.minbenchmark.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.vk.competition.minbenchmark.filter.LogFilter;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private LogFilter logFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logFilter);
    }
}
