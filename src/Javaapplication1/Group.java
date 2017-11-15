package Javaapplication1;

import java.util.ArrayList;

public abstract class Group {
	//Instant Variables
    private String name;
    private String dscrpt;
    private ArrayList<User> members;
    private ArrayList<Post> wall;
 
    //Constructor
    public Group(String name, String dscrpt){
        this.name = name;
        this.dscrpt = dscrpt;
        this.members = new ArrayList<User>();
        this.wall = new ArrayList<Post>();
       
    }
    //Checks if the user is a member of this group
    public boolean isMember(User user){
        if(this.members.contains(user)){
            return true;
        }
        return false;
    }
    
    //Adds the user to this group
    public void addMember(User user){
        if(this.isMember(user)){
            System.out.println("This user is already a member.");
            return;
        }
        this.members.add(user);
    }
    
    //Prints all the members of this group
    public void printGroupMembers(){
    	System.out.println("*******************************");
    	System.out.println("Members of Group " +this.name);
    	System.out.println("*******************************");
        for(User m : members){
            System.out.println(m.getName());
        }
        System.out.println("-----------------------");
    }
     
    public abstract boolean canPost(User user);
    
    //Adds a post on this group
    public void addPost(Post post){
    	if(canPost(post.getUser())){
    		wall.add(post);
 		}
    }
    //Adds a reply on a post of this group
 	public void addReplyToPost(Post post,Post postReply){
 		if(canPost(postReply.getUser())){
 			post.setReply(postReply);
 		}
 	}
 	
 	//Prints all the posts of this group
 	public void printWall(){
 		System.out.println("Group "+this.name+" wall");
 		for(Post w : wall){
 			System.out.println(w);
 		}
 	}
 	
 	//Returns the Latest post of this group
    public Post getLatestPost(){
    	return wall.get(wall.size()-1);
    		
    }
    
    //Accessors
    public String getName(){
        return name;
    }
    public String getDscrpt(){
        return dscrpt;
    }
    
    //Mutators
    public void setName(String name){
        this.name = name;
    } 
    public void setDscrpt(String dscrpt){
        this.dscrpt = dscrpt;
    }
}

