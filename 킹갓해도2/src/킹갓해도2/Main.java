package ŷ���ص�2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("1.����  2.��ȸ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		if (choice == 1) {
			System.out.println("�̸�");
			String name = sc.next();
			System.out.println("����");
			int age = sc.nextInt();
			System.out.println("��ȭ");
			String phone = sc.next();
			System.out.println("���");
			String memnum = sc.next();
			Member mem = new Member(name, age, phone, memnum);
			MemberDAO dao = new MemberDAO();
			dao.insert(mem);
			// ���� 4���� �ɹ���� Ŭ������ ���´�.
		} else if (choice == 2) {
			System.out.println("���ϴ� ��ȣ");
			String memnum = sc.next();
			MemberDAO dao = new MemberDAO();
			Member m = dao.selectOne(memnum);
			System.out.println("�̸�/����/��ȭ��ȣ/����ȣ");
			System.out.println(m.getName() + "/" + m.getAge() + "/" + m.getPhone() + "/" + m.getMemnum());
		}
	}

}