package bean;

public class DogBuilder implements Builder {
	
	private Dog dog = new Dog();
	
	public Dog getDog() {
		return dog;
	}

	public void setName(String name) {
		dog.setName(name);
		
	}

	public void setAge(int age) {
		dog.setAge(age);
	}

	public void setHealthy(boolean isHealthy) {
		dog.setHealthy(isHealthy);
	}

	public void setFed(boolean isFed) {
		dog.setFed(isFed);
	}

	public void setTrained(boolean isTrained) {
		dog.setTrained(isTrained);
	}

	public void setJob(String job) {
		dog.setJob(job);
	}

}
