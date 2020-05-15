package dao;

import dao.impl.TextDogDAO;
import dao.impl.TextTaskDAO;

public class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();

	private final DogDAO textDogDAO = new TextDogDAO();
	private final TaskDAO textTaskDAO = new TextTaskDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return INSTANCE;
	}

	public DogDAO getDogDAO() {
		return textDogDAO;
	}

	public TaskDAO getTaskDAO() {
		return textTaskDAO;
	}

}
