package 킹갓해도2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("1.가입  2.조회");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		if (choice == 1) {
			System.out.println("이름");
			String name = sc.next();
			System.out.println("나이");
			int age = sc.nextInt();
			System.out.println("전화");
			String phone = sc.next();
			System.out.println("멤넘");
			String memnum = sc.next();
			Member mem = new Member(name, age, phone, memnum);
			MemberDAO dao = new MemberDAO();
			dao.insert(mem);
			// 위의 4개를 맴버라는 클래스로 묶는다.
		} else if (choice == 2) {
			System.out.println("원하는 번호");
			String memnum = sc.next();
			MemberDAO dao = new MemberDAO();
			Member m = dao.selectOne(memnum);
			System.out.println("이름/나이/전화번호/고객번호");
			System.out.println(m.getName() + "/" + m.getAge() + "/" + m.getPhone() + "/" + m.getMemnum());
		}
	}

}