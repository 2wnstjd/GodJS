package 킹갓해도2;

public class Member {
	private String name;
	private int age;
	private String num;
	private String memnum;
//DTO클래스
	public Member(String name, int age, String num, String memnum) {
		super();
		this.name = name;
		this.age = age;
		this.num = num;
		this.memnum = memnum;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMemnum() {
		return memnum;
	}

	public void setMemnum(String memnum) {
		this.memnum = memnum;
	}

}
