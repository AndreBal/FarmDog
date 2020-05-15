package bean;

public interface Builder {
	Dog getDog();

	void setName(String name);

	void setAge(int age);

	void setHealthy(boolean isHealthy);

	void setFed(boolean isFed);

	void setTrained(boolean isTrained);

	void setJob(String job);

}
