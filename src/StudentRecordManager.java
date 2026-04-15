import java.sql.*;

public class StudentRecordManager {

    // 🔹 Register Student
    public void registerStudent(Student student) {
        String checkQuery = "SELECT id FROM students WHERE id = ?";
        String insertQuery = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBUtil.createConnection();
             PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {

            checkStmt.setInt(1, student.getStudentId());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("⚠ Student ID already exists. Try a different ID.");
                return;
            }

            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setInt(1, student.getStudentId());
                insertStmt.setString(2, student.getFullName());
                insertStmt.setInt(3, student.getAge());
                insertStmt.setString(4, student.getCourseName());

                int result = insertStmt.executeUpdate();

                if (result > 0) {
                    System.out.println("✅ Student record created successfully.");
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Error while adding student.");
            e.printStackTrace();
        }
    }

    // 🔹 Display All Students
    public void displayAllStudents() {
        String query = "SELECT * FROM students";

        try (Connection connection = DBUtil.createConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;

                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")
                );

                System.out.println(student);
            }

            if (!hasData) {
                System.out.println("ℹ No student records found.");
            }

        } catch (Exception e) {
            System.out.println("❌ Unable to fetch student records.");
            e.printStackTrace();
        }
    }

    // 🔹 Find Student
    public void findStudentById(int studentId) {
        String query = "SELECT * FROM students WHERE id = ?";

        try (Connection connection = DBUtil.createConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")
                );

                System.out.println(student);
            } else {
                System.out.println("⚠ No record found with given ID.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error while searching student.");
            e.printStackTrace();
        }
    }

    // 🔹 Update Student
    public void modifyStudentDetails(int studentId, String name, int age, String course) {
        String query = "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";

        try (Connection connection = DBUtil.createConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, course);
            stmt.setInt(4, studentId);

            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("✅ Student details updated.");
            } else {
                System.out.println("⚠ No matching student found.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error while updating record.");
            e.printStackTrace();
        }
    }

    // 🔹 Remove Student
    public void removeStudentRecord(int studentId) {
        String query = "DELETE FROM students WHERE id = ?";

        try (Connection connection = DBUtil.createConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, studentId);
            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("🗑 Student record deleted.");
            } else {
                System.out.println("⚠ Student not found.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error while deleting record.");
            e.printStackTrace();
        }
    }
}