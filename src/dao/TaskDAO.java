package dao;

import java.util.List;

import bean.Task;

public interface TaskDAO {
	List<Task> readTasks();
}
