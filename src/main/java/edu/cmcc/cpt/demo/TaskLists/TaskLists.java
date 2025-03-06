package edu.cmcc.cpt.demo.TaskLists;


public class TaskLists {

    private int list_id;
    private String list_name;
    private String created_at;
    private String updated_at;

    // Getters and Setters
    public int getList_id() { return list_id; }
    public void setList_id(int list_id) { this.list_id = list_id; }

    public String getList_name() { return list_name; }
    public void setList_name(String list_name) { this.list_name = list_name; }
    

    public String getCreated_at() { return created_at; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }
    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }
}
