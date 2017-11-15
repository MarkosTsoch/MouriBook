package Javaapplication1;

import java.util.Date;

public class Post {
	//Instant Variables
	private String text;
	private User user;
	private Post reply;
	private Date date;
	
	//Constructor
	public Post(String text,User user){
		this.text = text;
		this.user = user;
		this.reply = null;
		this.date = new Date();	
	}
	
	//Accessors
	public String getText(){
        return text;
    }
	public User getUser(){
		return user;
	}
	public Post getReply(){
		return reply;
	}
	public Date getDate(){
		return date;
	}
	
	//Mutators
	public void setText(String text){
		this.text = text;
	}
	public void setUser(User user){
		this.user = user;
	}
	public void setReply(Post reply){
		this.reply = reply;
	}
	
	//Converts a type Post object in to a String
	public String toString(){
		Post reply;
		String s = new String("| "+date.toString()+" | "+user.getName()+" : "+text);
		reply = this.reply;
		while( reply != null){
			s = s+("\n -> | "+reply.date+" | "+reply.user.getName()+" : "+reply.text);
			reply = reply.getReply();
		}
		return s;
	}
}
