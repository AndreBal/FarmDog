package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Dog;

public interface DogDAO {
	List<Dog> readDogs();
	
	void writeDogs(ArrayList<Dog> dogs);

}
