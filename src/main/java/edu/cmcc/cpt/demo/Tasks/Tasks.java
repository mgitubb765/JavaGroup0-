package edu.cmcc.cpt.demo.Tasks;

 public class Tasks {

    private int task_id;
    private int list_id;
    private String task_name;
    private String due_date;
    private String priority;
    private String status;
    private String created_at;
    private String updated_at;

    // Getters and Setters
    public int getTask_id() { return task_id; }
    public void setTask_id(int task_id) { this.task_id = task_id; }

    public int getList_id() { return list_id; }
    public void setList_id(int list_id) { this.list_id = list_id; }

    public String getTask_name() { return task_name; }
    public void setTask_name(String task_name) { this.task_name = task_name; }

    public String getDue_date() { return due_date; }
    public void setDue_date(String due_date) { this.due_date = due_date; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreated_at() { return created_at; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }
    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }


 }