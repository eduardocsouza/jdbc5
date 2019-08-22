package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Programa {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
			try {
				conn = DB.getConnection();
				st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?");
				
				st.setInt(1, 5);
				
				int linhas = st.executeUpdate();
				System.out.println("Alinhas alterada: " + linhas);
			}
			catch(SQLException e) {
				e.printStackTrace();				
			}
			finally {
				DB.closeStatement(st);
				DB.closeConnetion();
			}
	}	
}
