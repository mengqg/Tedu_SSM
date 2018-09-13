package two_ems.emp;

public class Emp {
	private String id = "";
	private String name = "";
	private double salary = 0.00;
	private int age = 0;
	
	public String toString() {
		return "Employee [id=" + id + ", ename=" + name + ", salary=" + salary + ", age=" + age + "]";
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
