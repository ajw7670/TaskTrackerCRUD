package com.TaskTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Task Tracker API", version = "1.0", description = "API for managing tasks"))
public class TaskTrackerCRUD {
    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerCRUD.class, args);
    }
}
