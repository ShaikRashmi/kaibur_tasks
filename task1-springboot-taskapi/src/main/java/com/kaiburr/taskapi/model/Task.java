package com.kaiburr.taskapi.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String name;
    private String owner;
    private String command;
    private List<TaskExecution> taskExecutions;

    public Task() {}

    public Task(String id, String name, String owner, String command, List<TaskExecution> taskExecutions) {
        this.id = id; this.name = name; this.owner = owner; this.command = command; this.taskExecutions = taskExecutions;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public String getCommand() { return command; }
    public void setCommand(String command) { this.command = command; }
    public java.util.List<TaskExecution> getTaskExecutions() { return taskExecutions; }
    public void setTaskExecutions(java.util.List<TaskExecution> taskExecutions) { this.taskExecutions = taskExecutions; }
}
