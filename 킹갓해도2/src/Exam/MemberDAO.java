package Exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exam.Member;

public class MemberDAO {

	public static void main(String[] args) {
		public void insert(Member mem) {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test";
			String password = "test";
			Connection con = null;
			PreparedStatement psmt = null;
		
			try {													// ������ ������ �� �� ���� ���� �־���
				// 1. ����̹� �ε�
				Class.forName("oracle.jdbc.driver.OracleDriver");  // Class : Ŭ������ Ŭ���� , Static�޼ҵ�(��ü �������� �ʾƵ� �޼ҵ� ȣ�Ⱑ��)
				// 2. DB�� �����Ͽ� Connection ��ü ���
				con = DriverManager.getConnection(url, user, password);    // ��ȣ�� ù��°�� url : DB�ּ�, �ι�°�� ID, ����°�� PW
				// 3. SQL�� �غ��ϱ�
				String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
				psmt = con.prepareStatement(sql);		// prepareStatement �������̽��� �Ѿ��
				psmt.setString(1, mem.getName());
				psmt.setString(2, mem.getAge());
				psmt.setString(3, mem.getTel());
				psmt.setString(4, mem.getMemnum());
				// 4. �����ϱ�
				int num = psmt.executeUpdate();		// sql�� update�� ����, ���⼭ update�� �����ϴ°�		// num���� ������������ row�� ����
				System.out.println(num);
				
				
			} catch (ClassNotFoundException e) {				// try ���� ���ܴ� catch�� ��� ó�� (���� �α������� ���� ����)
				System.out.println("Ŭ������ ã�� �� �����ϴ�.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("SQL ������ ������ �߻��Ͽ����ϴ�.");
				e.printStackTrace();
			}  finally {  			
				// 5. ���� ����
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public Member selectOne(String memnum) {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test";
			String password = "test";
			Connection con = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			Member m = null;

			try {													// ������ ������ �� �� ���� ���� �־���
				// 1. ����̹� �ε�
				Class.forName("oracle.jdbc.driver.OracleDriver");  // Class : Ŭ������ Ŭ���� , Static�޼ҵ�(��ü �������� �ʾƵ� �޼ҵ� ȣ�Ⱑ��)
				// 2. DB�� �����Ͽ� Connection ��ü ���
				con = DriverManager.getConnection(url, user, password);    // ��ȣ�� ù��°�� url : DB�ּ�, �ι�°�� ID, ����°�� PW
				// 3. SQL�� �غ��ϱ�
				String sql = "SELECT * FROM MEMBER WHERE MEMNUM=?";
				psmt = con.prepareStatement(sql);		// prepareStatement �������̽��� �Ѿ��
				psmt.setString(1, memnum);

				// 4. �����ϱ�
				rs = psmt.executeQuery();		// select�� �ٸ� �޼ҵ� ���
				
				// 5. ResltSet ��ü���� ������ ������
					rs.next();
					String name = rs.getString(1);	//  ���̺���
					String age = rs.getString(2);
					String tel = rs.getString(3);
					String memnum2 = rs.getString(4);
					m = new Member(name,age,tel,memnum2);
			
				
			} catch (ClassNotFoundException e) {				// try ���� ���ܴ� catch�� ��� ó�� (���� �α������� ���� ����)
				System.out.println("Ŭ������ ã�� �� �����ϴ�.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("SQL ������ ������ �߻��Ͽ����ϴ�.");
				e.printStackTrace();
			}  finally {  			
				// 5. ���� ����
				try {
					if(rs != null) rs.close();  // if���� ���ָ� ���� ��������
					if(rs != null) psmt.close();
					if(rs != null) con.close();
					
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

			return m;
		}
	}

}
