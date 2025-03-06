package edu.cmcc.cpt.demo.TaskLists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskListsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TaskLists> findAll() {
        String sql = "SELECT * FROM taskLists";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TaskLists.class));
    }

    public TaskLists findById(int list_id) {
        String sql = "SELECT * FROM taskLists WHERE list_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(TaskLists.class), list_id);
    }

    public int save(TaskLists taskLists) {
        String sql = "INSERT INTO taskLists (list_name, created_at, updated_at) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, taskLists.getList_name(), taskLists.getCreated_at(), taskLists.getUpdated_at());
    }

    public int update(int list_id, TaskLists taskLists) {
        String sql = "UPDATE taskLists SET list_name = ?, created_at = ?, updated_at = ? WHERE list_id = ?";
        return jdbcTemplate.update(sql, taskLists.getList_name(), taskLists.getCreated_at(), taskLists.getUpdated_at(), list_id);
    }

    public int deleteById(int list_id) {
        String sql = "DELETE FROM taskLists WHERE list_id = ?";
        return jdbcTemplate.update(sql, list_id);
    }

    public List<TaskLists> findByListName(String list_name) {
        String sql = "SELECT * FROM taskLists WHERE list_name = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TaskLists.class), list_name);
    }

}
