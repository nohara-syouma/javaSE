import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Update {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;

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

			String sql = "UPDATE products\n" + "  SET product_id = 101\n" + "WHERE price = 60";

			// create statement
			stmt = con.prepareStatement(sql);

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
