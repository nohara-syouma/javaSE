import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Update {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		int param = 101;
        int param2 = 60;

		try {
			// load JDBC Driver
			Class.forName("org.postgresql.Driver");

			// confirm
			System.out.println(" --- before connection --- ");

			// database connect
			con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

			// confirm
			System.out.println(" --- after connection --- ");

			// SQL query string

			String sql = "UPDATE products\n" + "  SET product_id = ?\n" + "WHERE price = ?";

			// create statement
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, param);
			stmt.setInt(2, param2);

			// execute

			stmt.executeUpdate();

			// output

			System.out.println("更新しました");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
