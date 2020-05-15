package controller;

import java.util.List;
import java.util.Scanner;

import bean.Dog;
import bean.Task;
import dao.DAOFactory;
import dao.DogDAO;
import dao.TaskDAO;

public class Controller {

	public static void main(String[] args) {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DogDAO dogDAO = daoFactory.getDogDAO();
		List<Dog> dogs = dogDAO.readDogs();
		TaskDAO taskDAO = daoFactory.getTaskDAO();
		List<Task> tasks = taskDAO.readTasks();

		MessagesManager messagesManager = MessagesManager.getInstance();

		System.out.println(messagesManager.getValue("morning"));
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		while (!command.equals("exit")) {
			switch (command.toLowerCase()) {
			case "help":
				System.out.println(messagesManager.getValue("help"));
				command = sc.nextLine();
				break;
			case "status":
				System.out.printf(messagesManager.getValue("dogStats"), dogs.size());
				ControllerMethods.getStatus(tasks, messagesManager);
				command = sc.nextLine();
				break;
			case "tasks":
				System.out.println(messagesManager.getValue("tasks"));
				command = sc.nextLine();
				break;
			case "morning feed":
				ControllerMethods.feed(tasks.get(0), dogs, messagesManager);
				command = sc.nextLine();
				break;
			case "vet":
				ControllerMethods.vet(tasks.get(1), dogs, messagesManager);
				command = sc.nextLine();
				break;
			case "cleaning":
				ControllerMethods.cleaning(tasks.get(2), messagesManager);
				command = sc.nextLine();
				break;
			case "jobs":
				ControllerMethods.dogJobs(tasks.get(3), dogs, messagesManager);
				command = sc.nextLine();
				break;
			case "evening feed":
				ControllerMethods.feed(tasks.get(4), dogs, messagesManager);
				command = sc.nextLine();
				break;
			default:
				System.out.println(messagesManager.getValue("wrongCommand"));
				command = sc.nextLine();
				break;
			}

		}
		sc.close();
	}

}
