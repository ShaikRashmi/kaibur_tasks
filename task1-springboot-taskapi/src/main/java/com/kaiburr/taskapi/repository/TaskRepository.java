package com.kaiburr.taskapi.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.kaiburr.taskapi.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByNameContainingIgnoreCase(String name);
}
