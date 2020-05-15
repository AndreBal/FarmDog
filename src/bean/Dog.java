package bean;

public class Dog {
	private String name;
	private int age;
	private boolean isHealthy;
	private boolean isFed;
	private boolean isTrained;
	private String job;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isHealthy() {
		return isHealthy;
	}
	public void setHealthy(boolean isHealthy) {
		this.isHealthy = isHealthy;
	}
	public boolean isFed() {
		return isFed;
	}
	public void setFed(boolean isFed) {
		this.isFed = isFed;
	}
	public boolean isTrained() {
		return isTrained;
	}
	public void setTrained(boolean isTrained) {
		this.isTrained = isTrained;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (isFed ? 1231 : 1237);
		result = prime * result + (isHealthy ? 1231 : 1237);
		result = prime * result + (isTrained ? 1231 : 1237);
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (isFed != other.isFed)
			return false;
		if (isHealthy != other.isHealthy)
			return false;
		if (isTrained != other.isTrained)
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", isHealthy=" + isHealthy + ", isFed=" + isFed + ", isTrained="
				+ isTrained + ", job=" + job + "]";
	}
	
}
