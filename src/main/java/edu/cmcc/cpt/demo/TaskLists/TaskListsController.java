package edu.cmcc.cpt.demo.TaskLists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class TaskListsController {

    @Autowired
    private TaskListsRepository taskListsRepository;

    @GetMapping
    public List<TaskLists> getAllTaskLists() {
        return taskListsRepository.findAll();
    }

    @GetMapping("/{list_id}")
    public ResponseEntity<TaskLists> getTaskListsById(@PathVariable int list_id) {
        TaskLists taskLists = taskListsRepository.findById(list_id);
        return taskLists != null ? ResponseEntity.ok(taskLists) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createTaskLists(@RequestBody TaskLists taskLists) {
        taskListsRepository.save(taskLists);
        return ResponseEntity.ok("TaskLists created successfully.");
    }

    @PutMapping("/{list_id}")
    public ResponseEntity<String> updateTaskLists(@PathVariable int list_id, @RequestBody TaskLists taskLists) {
        int rowsAffected = taskListsRepository.update(list_id, taskLists);
        return rowsAffected > 0 ? ResponseEntity.ok("TaskLists updated.") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{list_id}")
    public ResponseEntity<String> deleteTaskLists(@PathVariable int list_id) {
        int rowsAffected = taskListsRepository.deleteById(list_id);
        return rowsAffected > 0 ? ResponseEntity.ok("TaskLists deleted.") : ResponseEntity.notFound().build();
    }

}