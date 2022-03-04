package com.example.calendar;

public class UserList {
	private Node head;
	
	public UserList(){
		
	}
	
	public void addUser(User user) {
		if(head == null) {
			head = new Node(user);
		}
		else {
			Node curr = head;
			
			while(curr.getNext()!= null) {
				curr = curr.getNext();
			}
			curr.setNext(new Node(user));
		}
	}
	//If false, same email exists
	public boolean checkEmail(String email) {
		boolean check = true;
		
		Node curr = head;
		
		while(curr!=null && check) {
			if(curr.getData().getEmail().equals(email)) {
				check = false;
			}
			else {
				curr = curr.getNext();
			}
		}
		return check;
	}
	
	//If false, same username exists
	public boolean checkUsername(String username) {
		boolean check = true;
		
		Node curr = head;
		
		while(curr!=null && check) {
			if(curr.getData().getUserName().equals(username)) {
				check = false;
			}
			else {
				curr = curr.getNext();
			}
		}
		return check;
	}
}
