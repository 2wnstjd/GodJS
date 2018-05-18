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
		
			try {													// 실행중 에러가 날 것 같은 것을 넣어줌
				// 1. 드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");  // Class : 클래스의 클래스 , Static메소드(객체 생성하지 않아도 메소드 호출가능)
				// 2. DB와 연결하여 Connection 객체 얻기
				con = DriverManager.getConnection(url, user, password);    // 괄호의 첫번째는 url : DB주소, 두번째는 ID, 세번째는 PW
				// 3. SQL문 준비하기
				String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
				psmt = con.prepareStatement(sql);		// prepareStatement 인터페이스가 넘어옴
				psmt.setString(1, mem.getName());
				psmt.setString(2, mem.getAge());
				psmt.setString(3, mem.getTel());
				psmt.setString(4, mem.getMemnum());
				// 4. 실행하기
				int num = psmt.executeUpdate();		// sql의 update는 수정, 여기서 update는 변경하는거		// num에는 실행했을때의 row가 들어옴
				System.out.println(num);
				
				
			} catch (ClassNotFoundException e) {				// try 안의 예외는 catch로 잡아 처리 (보통 로그파일을 따로 만듦)
				System.out.println("클래스를 찾을 수 없습니다.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("SQL 실행중 문제가 발생하였습니다.");
				e.printStackTrace();
			}  finally {  			
				// 5. 연결 끊기
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

			try {													// 실행중 에러가 날 것 같은 것을 넣어줌
				// 1. 드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");  // Class : 클래스의 클래스 , Static메소드(객체 생성하지 않아도 메소드 호출가능)
				// 2. DB와 연결하여 Connection 객체 얻기
				con = DriverManager.getConnection(url, user, password);    // 괄호의 첫번째는 url : DB주소, 두번째는 ID, 세번째는 PW
				// 3. SQL문 준비하기
				String sql = "SELECT * FROM MEMBER WHERE MEMNUM=?";
				psmt = con.prepareStatement(sql);		// prepareStatement 인터페이스가 넘어옴
				psmt.setString(1, memnum);

				// 4. 실행하기
				rs = psmt.executeQuery();		// select는 다른 메소드 사용
				
				// 5. ResltSet 객체에서 데이터 꺼내기
					rs.next();
					String name = rs.getString(1);	//  테이블구조
					String age = rs.getString(2);
					String tel = rs.getString(3);
					String memnum2 = rs.getString(4);
					m = new Member(name,age,tel,memnum2);
			
				
			} catch (ClassNotFoundException e) {				// try 안의 예외는 catch로 잡아 처리 (보통 로그파일을 따로 만듦)
				System.out.println("클래스를 찾을 수 없습니다.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("SQL 실행중 문제가 발생하였습니다.");
				e.printStackTrace();
			}  finally {  			
				// 5. 연결 끊기
				try {
					if(rs != null) rs.close();  // if문을 써주면 좀더 안정적임
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
