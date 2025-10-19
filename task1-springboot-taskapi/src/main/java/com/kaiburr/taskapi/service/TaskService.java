package com.kaiburr.taskapi.service;

import com.kaiburr.taskapi.model.*;
import com.kaiburr.taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo) { this.repo = repo; }

    public List<Task> getAll() { return repo.findAll(); }
    public Optional<Task> getById(String id) { return repo.findById(id); }
    public Task createOrUpdate(Task task) { return repo.save(task); }
    public void delete(String id) { repo.deleteById(id); }
    public List<Task> findByName(String name) { return repo.findByNameContainingIgnoreCase(name); }

    public Task executeTask(String id) throws Exception {
        Task task = repo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        String cmd = task.getCommand();
        // Basic safety check
        String low = cmd.toLowerCase();
        if (low.contains("rm ") || low.contains("rm-") || low.contains("sudo") || low.contains("shutdown"))
            throw new RuntimeException("Unsafe command");
        Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",cmd});
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) { output.append(line).append("\n"); }
        TaskExecution exec = new TaskExecution(new Date(), new Date(), output.toString());
        if (task.getTaskExecutions() == null) task.setTaskExecutions(new ArrayList<>());
        task.getTaskExecutions().add(exec);
        return repo.save(task);
    }
}
