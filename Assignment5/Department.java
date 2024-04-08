import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    // Database connection parameters
    private static final String url = "jdbc:mysql://localhost:3306/departments"; // Change according to your database configuration
    private static final String username = "your_username"; // Enter your database username
    private static final String password = "your_password"; // Enter your database password

    public static void main(String[] args) {
        // Creating Department objects
        Department department1 = new Department(1, "IT");
        Department department2 = new Department(2, "HR");

        // Storing Department objects in the database
        storeDepartment(department1);
        storeDepartment(department2);
    }

    // Method to store Department object in the database
    public static void storeDepartment(Department department) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO department (id, name) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, department.getId());
                preparedStatement.setString(2, department.getName());
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Department stored successfully: " + department.getName());
                } else {
                    System.out.println("Failed to store department: " + department.getName());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
