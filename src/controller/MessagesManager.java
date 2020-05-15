package controller;

import java.util.ResourceBundle;


public class MessagesManager {
private final static MessagesManager instance = new MessagesManager();
	
	
	
	private ResourceBundle boundle = ResourceBundle.getBundle("resources.messages_en");
	
	public static MessagesManager getInstance () {
		return instance;
	}
	
	public String getValue (String key) {
		return boundle.getString(key);
	}


}
