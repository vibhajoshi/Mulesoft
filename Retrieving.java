import java.sql.*;

public class Retrieving {

	public static void main(String args[]) {

		try {

			Connection con = null; 		// Create Connection
			Statement stmt = null; 		//Declare Statement & Initialize with null

			con = DriverManager			//Connect to DataBase
					.getConnection("jdbc:sqlite:/C:\\Users\\Vibha V Joshi\\OneDrive\\Desktop\\Mulesoft\\test.db");
			System.out.println("Database Connection Successful !!");

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Movies");

			while (rs.next()) {

				String moviename = rs.getString("MovieName");

				String moviedirector = rs.getString("DirectorName");

				String maleLeadActor = rs.getString("ActorName");

				String femaleLeadActor = rs.getString("ActressName");

				Integer releaseYear = rs.getInt("YearOfRelease");
				

				System.out.println("Movie Name    : " + moviename);

				System.out.println("Director Name : " + moviedirector);

				System.out.println("Actor Name  : " + maleLeadActor);

				System.out.println("Actress Name : " + femaleLeadActor);

				System.out.println("Release Year  : " + releaseYear);
				
				System.out.println();

			}

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Data retrieval successful!!");
	}
}