package Javaapplication1;

import java.util.ArrayList;

public class OpenGroup extends Group {
	//Constructor
	public OpenGroup(String name,String dscrpt){
		super(name, dscrpt);
		
	}
	
	public boolean canPost(User user){
		//Checks if the user is a member of this group
		if(isMember(user)){
			return true;
		}
		//Checks if user's friends are members of this group
		ArrayList<User> fl = new ArrayList<User>(user.getFriendList());  
		for(int i=0; i<fl.size(); i++){
			if(isMember(fl.get(i))){
				return true;
			}
		}
		System.out.println("User "+user.getName()+" cannot post on Open Group "+this.getName());
		return false;
	}
	
	

}
