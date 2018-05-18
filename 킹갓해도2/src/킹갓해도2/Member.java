package 킹갓해도2;

public class Member {
	private String name;
	private int age;
	private String num;
	private int memnum;
//DTO클래스
	public Member(String name, int age, String num, int memnum) {
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

	public int getMemnum() {
		return memnum;
	}

	public void setMemnum(int memnum) {
		this.memnum = memnum;
	}

}
