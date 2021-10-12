package entities;

public class Employee {
	private Integer id;
	private String name;
	private Double salary;
	
	public Employee() {
	}
	
	public Employee(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getSalary() {
		return this.salary;
	}
	
	public void increaseSalary(Double percentage) {
		salary *= (1 + percentage/100);
	}
		
	@Override
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f%n", salary); 
	}
}
