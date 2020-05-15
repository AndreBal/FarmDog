package dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import bean.Task;
import dao.TaskDAO;

public class TextTaskDAO implements TaskDAO{
	
	private final static String pathToTasks = ".\\data\\Tasks";
	
	public List<Task> readTasks(){
		
		List<Task> Tasks = new ArrayList<>();
		Path pathToFile = Paths.get(pathToTasks);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
			String line = br.readLine();
			while (line != null) {
				Task task = new Task(line);
				Tasks.add(task);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.err.println("Cannot read file Tasks.txt");
			e.printStackTrace();
		}

		return Tasks;
		
	}

}
