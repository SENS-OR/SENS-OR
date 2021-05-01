package cs3337;

import java.lang.*;
import java.util.*;

public class Authentication {
	//private properties
	private Map<String, String> users = new HashMap<>();
	
	private void FillMap() {
		users.put("robin", "romero");
		users.put("uchenna", "onuigbo");
		users.put("mazel", "fernandez");
		users.put("elton", "lin");
	}
	
	//constructor
	public Authentication() {
		FillMap();
	}
	
	//public methods
	public boolean Authenticate(String user, String pw) {
		
		if(users.get(user) == pw) {
			return true;
		}
		return false;
	}
}
