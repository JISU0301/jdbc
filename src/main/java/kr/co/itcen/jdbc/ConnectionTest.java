package kr.co.itcen.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		
		Connection connection = null;
		//1. JDBC DRIVER �ε�
		try {
			Class.forName("org.mariadb.jdbc.Driver");// Ŭ���� �ε��ϴ� �۾�
		
			//2. 연결하기
			
			String url = "jdbc:mariadb://192.168.1.77:3307/webdb?characterEncoding=utf8";
			DriverManager.getConnection(url,"webdb","webdb");
			
			System.out.println("연결 성공!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver" + e);
		}catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	
	}

