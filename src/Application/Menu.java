package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.Dogdao;
import entity.dog;

public class Menu {
	private Dogdao dogdao = new Dogdao ();
	
	private dog dog;
	private Scanner kb = new Scanner(System.in);
	
	private List<String> menuOptions = Arrays.asList("Display Dogs", "Display a Dog", "Create a Dog", "Delete a Dog", "Update a Dog");
	
	public void start () throws SQLException {
		
	String selection = "";
	
	do {
		printMenu();
		selection = kb.nextLine();
		
		try {
		
		if (selection.equals("1")) {
			displayDogs();}
			
		else if (selection.equals("2")) {
			displayDog();
		}
		
		else if (selection.equals("3")) {
			createDog();}
		
		else if (selection.equals("4")) {
			deleteDog();}
	
		else if (selection.equals("5")) {
			updateDog();}
		
		}catch (SQLException e) {
			
			e.printStackTrace();}
		}
	while (!selection.equals(-1));
		
			
		}
	
		
		
	private void printMenu() {
		System.out.println("Please select an option");
		for (int i=0; i < menuOptions.size(); i++) {
			System.out.println(i+1 + ".)" + menuOptions.get(i));
		}
	}
	
	private void displayDogs() throws SQLException {
		
		List <dog> dogs = dogdao.getDogs();
		for (dog dog: dogs) {
			System.out.println("\n Dog ID: "+ dog.getDogId() +  "\n Name: " + dog.getName()+ " " + "\n Breed: " + dog.getBreed() + " "+ "\n Age: "+ dog.getAge());}
			}
		
	
	
	private void displayDog() throws SQLException {
		
		System.out.println("Please enter ID number");
		int id = Integer.parseInt(kb.nextLine());
		dog dog = dogdao.getdogbyid(id);
		System.out.println("\n Dog ID: "+ dog.getDogId() +  "\n Name: " + dog.getName()+ " " + "\n Breed: " + dog.getBreed() + " "+ "\n Age: "+ dog.getAge());
		
		
	}
	
	private void createDog() throws SQLException {
		System.out.println("Please enter the dog's ID");
		int id = Integer.parseInt(kb.nextLine());
		System.out.println("What is the dog's name?");
		String name = kb.nextLine();
		System.out.println("What is the dog's breed?");
		String breed = kb.nextLine();
		System.out.println("What is the dog's age?");
		int age = Integer.parseInt(kb.nextLine());
				
		dogdao.createdog(id, name, breed, age);
		
		
	}
	
	private void deleteDog() throws SQLException {
		System.out.println("What is the dog's ID number?");
		int id = Integer.parseInt(kb.nextLine());
		dogdao.deletedogbyid(id);
	}
	private void updateDog() throws SQLException {
		System.out.println("Please enter the dog's ID");
		int id = Integer.parseInt(kb.nextLine());
		System.out.println("What do you want to update the dog's name to?");
		String name = kb.nextLine();
		System.out.println("What do you want to update the dog's breed to?");
		String breed = kb.nextLine();
		System.out.println("What do you want to update the dog's age to?");
		int age = Integer.parseInt(kb.nextLine());
				
		dogdao.updateadog(id, name, breed, age);

}}
