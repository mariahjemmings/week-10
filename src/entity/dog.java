package entity;

public class dog {
	
	private int dogId;
	private String name;
	private String breed;
	private int age;
	
	
	public dog(int dogId, String name, String breed, int age) {
		this.dogId = dogId;
		this.name = name;
		this.breed = breed;
		this.age = age;
		
	}
	public dog () {}
	
	public int getDogId() {
		return dogId;
	}
	public void setDogId(int dogId) {
		this.dogId = dogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
