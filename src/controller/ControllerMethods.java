package controller;

import java.util.List;

import bean.Dog;
import bean.Task;

public class ControllerMethods {
	public static void getStatus(List<Task> tasks, MessagesManager messagesManager) {
		Task nextTask = null;
		for (Task t : tasks) {
			if (nextTask == null && !t.isStatus()) {
				nextTask = t;
			}
			System.out.printf(messagesManager.getValue("task"), t.getName(), t.isStatus());
		}
		if (nextTask == null) {
			System.out.println(messagesManager.getValue("allTasksComplete"));
		} else {
			System.out.printf(messagesManager.getValue("nextTask"), nextTask.getName());
		}

	}

	public static void feed(Task task, List<Dog> dogs, MessagesManager messagesManager) {
		int puppyFood = 0;
		int grownFood = 0;
		int elderlyFood = 0;
		for (Dog d : dogs) {
			if (d.getAge() < 2 && !d.isFed()) {
				puppyFood++;
				d.setFed(true);
			} else if (d.getAge() < 8 && !d.isFed()) {
				grownFood++;
				d.setFed(true);
			} else if (d.getAge() > 7 && !d.isFed()) {
				elderlyFood++;
				d.setFed(true);
			}
			
		}
		task.setStatus(true);
		System.out.printf(messagesManager.getValue("feeding"), puppyFood, grownFood, elderlyFood);

	}

	public static void vet(Task task, List<Dog> dogs, MessagesManager messagesManager) {
		int sickDogs = 0;
		for (Dog d : dogs) {
			if (!d.isHealthy()) {
				sickDogs++;
				d.setHealthy(true);
			}
		}
		task.setStatus(true);
		System.out.printf(messagesManager.getValue("vet"), sickDogs);
		
	}

	public static void cleaning(Task task, MessagesManager messagesManager) {
		task.setStatus(true);
		System.out.println(messagesManager.getValue("cleaning"));
		
	}

	public static void dogJobs(Task task, List<Dog> dogs, MessagesManager messagesManager) {
		int untrained = 0;
		int trained = 0;
		int elderly = 0;
		for (Dog d : dogs) {
			d.setFed(false);
			if (d.getAge() > 7) {
				elderly++;
			} else if (d.isTrained()) {
				trained++;
			} else  {
				untrained++;
			}
			
		}
		task.setStatus(true);
		System.out.printf(messagesManager.getValue("jobs"), untrained, trained, elderly);
		
	}

}
