package thisisjava.ch20.mysql.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결하기
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "java",
                    "mysql"
            );


            // 매개변수화된 SQL 문 작성
            String sql = "" + "INSERT INTO users (userid,username,userpassword,userage,useremail)" +
                    "VALUES (?,?,?,?,?)";

            // PreparedStatement 얻기 및 값 저장
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");
            pstmt.setString(2, "한겨울");
            pstmt.setString(3, "12345");
            pstmt.setInt(4, 25);
            pstmt.setString(5, "winter@mycompany.com");

            // SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 : " + rows);

            // PreaparedStatement 닫기
            pstmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
