package dao.impl;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import bean.Builder;
import bean.Dog;
import bean.DogBuilder;
import dao.DogDAO;

public class TextDogDAO implements DogDAO {

	private final static String pathToDogs = ".\\data\\Dogs";

	public List<Dog> readDogs() {

		List<Dog> Dogs = new ArrayList<>();
		Path pathToFile = Paths.get(pathToDogs);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
			String line = br.readLine();
			while (line != null) {
				Builder dogBuilder = new DogBuilder();
				String[] info = line.split("~~~");
				String name = info[0];
				dogBuilder.setName(name);
				int age = Integer.parseInt(info[1]);
				dogBuilder.setAge(age);
				boolean isHealthy = Boolean.parseBoolean(info[2]);
				dogBuilder.setHealthy(isHealthy);
				boolean isFed = Boolean.parseBoolean(info[3]);
				dogBuilder.setFed(isFed);
				boolean isTrained = Boolean.parseBoolean(info[4]);
				dogBuilder.setTrained(isTrained);
				String job = info[5];
				dogBuilder.setJob(job);
				Dog dog = dogBuilder.getDog();
				Dogs.add(dog);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.err.println("Cannot read file Dogs.txt");
			e.printStackTrace();
		}

		return Dogs;
	}

	public void writeDogs(ArrayList<Dog> dogs) {
		try (FileWriter writer = new FileWriter(pathToDogs, false);) {

			PrintWriter printWriter = new PrintWriter(writer);

			for (Dog dog : dogs) {
				String codedDog = dog.getName() + "~~~" + dog.getAge() + "~~~" + dog.isHealthy() + "~~~" + dog.isFed()
						+ "~~~" + dog.isTrained() + "~~~" + dog.getJob();
				printWriter.println(codedDog);
			}

		} catch (IOException e) {
			System.err.println("Cannot create file dogs.txt");
			e.printStackTrace();
		}
	}

}
