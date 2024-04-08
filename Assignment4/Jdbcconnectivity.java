import java.sql.*;

public class Jdbcconnectivity {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Change according to your database configuration
        String username = ""; // Enter your Oracle database username
        String password = ""; // Enter your Oracle database password

        // Establishing connection to the Oracle database
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to Oracle database");

            // Taking input for patient ID
            int patientId = getPatientId();

            // Retrieving patient information from the database
            String query = "SELECT * FROM patients WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, patientId);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Printing patient information
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String problem = resultSet.getString("problem");
                    double bill = resultSet.getDouble("bill");

                    System.out.println("Patient ID: " + id);
                    System.out.println("Patient Name: " + name);
                    System.out.println("Patient Problem: " + problem);
                    System.out.println("Patient Bill: " + bill);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Connection to Oracle database failed.");
            e.printStackTrace();
        }
    }

    // Method to get patient ID from runtime input
    public static int getPatientId() {
        int patientId = 0;
        try {
            System.out.print("Enter patient ID: ");
            patientId = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid patient ID.");
            System.exit(1);
        }
        return patientId;
    }
}
