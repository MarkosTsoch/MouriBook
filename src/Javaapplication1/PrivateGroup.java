package Javaapplication1;

public class PrivateGroup extends Group {
	//Constructor
	public PrivateGroup(String name,String dscrpt){
		super(name, dscrpt);
		
	}
	
	public boolean canPost(User user){
		//Checks if the user is a member of this group
		if(isMember(user)){
			return true;
		}
		System.out.println("User "+user.getName()+" cannot post on Private Group "+this.getName());
		return false;
		
	}

}
