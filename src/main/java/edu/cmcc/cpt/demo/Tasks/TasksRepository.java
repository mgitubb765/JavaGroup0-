package edu.cmcc.cpt.demo.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TasksRepository {
    

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Tasks> findAll() {
        String sql = "SELECT * FROM tasks";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Tasks.class));
    }

    public Tasks findById(int task_id){
        String sql = "SELECT * FROM tasks WHERE task_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Tasks.class), task_id);
    }

    public int save(Tasks tasks){
        String sql = "INSERT INTO tasks (task_name, task_status, task_priority, task_due_date, task_created_at, task_updated_at) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, tasks.getTask_name(), tasks.getStatus(), tasks.getPriority(), tasks.getDue_date(), tasks.getCreated_at(), tasks.getUpdated_at());
    }

    public int update(int task_id, Tasks tasks){
        String sql = "UPDATE tasks SET task_name = ?, task_status = ?, task_priority = ?, task_due_date = ?, task_created_at = ?, task_updated_at = ? WHERE task_id = ?";
        return jdbcTemplate.update(sql, tasks.getTask_name(), tasks.getStatus(), tasks.getPriority(), tasks.getDue_date(), tasks.getCreated_at(), tasks.getUpdated_at());
    }

    public int deleteById(int task_id){
        String sql = "DELETE FROM tasks WHERE task_id = ?";
        return jdbcTemplate.update(sql, task_id);
    }


}
