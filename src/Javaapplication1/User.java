package Javaapplication1;

import java.util.ArrayList;


public class User {
	//Instant Variables
    private String name;
    private String email;
    private ArrayList<User> friendList;
    private ArrayList<Group> groupList;
    
	//Constructor
    public User(String name, String email){
        this.name = name;
        this.email = email;
        this.friendList = new ArrayList<User>();
        this.groupList = new ArrayList<Group>();
       
    }
    
    //Checks if a user is friend with this user 
    public boolean friendsWith(User user){
        if(this.friendList.contains(user)){
            return true;
        }  
        return (false);
    }
    //Adds a user on this user's friendList and vise versa
    public void addFriend(User user){
        if(this.equals(user)){
            System.out.println("You can't be friends with yourself.");
            return;
        }else if(this.friendsWith(user)){
            System.out.println("You are already friends with this user.");
            return;
        }
        this.friendList.add(user);
        user.friendList.add(this);
        System.out.println(this.name+" and "+user.name+" are now friends!");
    }
    
    //Adds a group on this user's groupList and adds this user on the group's member list
    public void addGroup(Group group){
        if(this.groupList.contains(group)){
            System.out.println("You are already member of this group.");
            return;
        }
        group.addMember(this);
        this.groupList.add(group);
        
        
    }
    //Finds the mutual friends between a user and this user
    public ArrayList<User> findMutualFriends(User user){
        ArrayList<User> mutualFriends = new ArrayList<User>();
        for(User friend: user.friendList){
            if(this.friendList.contains(friend)){
                mutualFriends.add(friend);
            }
        }
        return mutualFriends;
    }
    
    //Finds the suggested friends for this user
    public ArrayList<User> findSuggestedFriends(){
    	ArrayList<User> suggestedFriends = new ArrayList<User>();
    	for(User friend : friendList){
    		for(User f : friend.friendList){
    			//an den einai hdh filos me ton f  KAI den einai o eautos tou KAI den exei prostethei hdh stin suggested friends
    			if(!this.friendsWith(f)&&(!this.equals(f))&&(!suggestedFriends.contains(f))) {
    			suggestedFriends.add(f);
    			}
    		}
    	}
    	return suggestedFriends;
    }
    //Prints an ArrayList which contains users
    private void printList(ArrayList<User> list){
    	int i=0;
    	for(User u : list){
            System.out.println(++i+": "+u.getName());
        }
    	System.out.println("--------------------------------------");
    }
    //Prints the mutual friends between a user and this user
    public void printMutualFriends(User user){
        System.out.println("**************************************");
        System.out.println("Common friends of "+this.name+" and "+ user.name);
        System.out.println("**************************************");
        
        ArrayList<User> mfriends = new ArrayList<User>(this.findMutualFriends(user));
        printList(mfriends);
    }
    //Prints the suggested friends for this user
    public void printSuggestedFriends(){
        System.out.println("**************************************");
        System.out.println("Suggested friends for "+this.name);
        System.out.println("**************************************");
        
        ArrayList<User> sfriends = new ArrayList<User>(this.findSuggestedFriends());
        printList(sfriends);
    }
    
    //Prints the friend list of this user
    public void printFriendList(){
        System.out.println("************************");
        System.out.println("Friends of "+this.name);
        System.out.println("************************");
        printList(friendList);
    }
    //Prints the group list of this user
    public void printGroupList(){
    	System.out.println("*************************************");
    	System.out.println("Groups that "+this.name+" has enrolled");
    	System.out.println("*************************************");
    	
        for(Group g : groupList){
            System.out.println(g.getName());
        }
        System.out.println("-----------------------");
    }
    
    //Accessors
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public ArrayList<User> getFriendList(){
    	return friendList;
    }
    public ArrayList<Group> getGroupList(){
    	return groupList;
    }
    
    //Mutators
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    //Compares two type User objects
    public boolean equals(Object obj){ 
    	if (obj == this) {
    		return true;
		}
    	if (obj == null || obj.getClass() != this.getClass()) {
	    	return false;
	    }
	    User user = (User) obj;
	    return this.name.equals(user.name) && this.email.equals(user.email) && this.friendList.equals(user.friendList) && this.groupList.equals(user.groupList);
    }
    
    //Creates a post by this user
    public Post createPost(String string) {
	   return new Post(string,this);
	
   }

 

   

}

