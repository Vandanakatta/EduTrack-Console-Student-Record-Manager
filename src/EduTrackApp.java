import java.util.Scanner;

public class EduTrackApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentRecordManager recordManager = new StudentRecordManager();

        while (true) {
            System.out.println("\n===== EduTrack Console =====");
            System.out.println("1. Register New Student");
            System.out.println("2. Display All Student Records");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Remove Student Record");
            System.out.println("5. Edit Student Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    System.out.print("Enter student ID: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter full name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    if (newAge <= 0) {
                        System.out.println("⚠ Age must be greater than 0.");
                        break;
                    }

                    System.out.print("Enter course name: ");
                    String newCourse = scanner.nextLine();

                    Student student = new Student(newId, newName, newAge, newCourse);
                    recordManager.registerStudent(student);
                    break;

                case 2:
                    recordManager.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    recordManager.findStudentById(searchId);
                    break;

                case 4:
                    System.out.print("Enter student ID to remove: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    recordManager.removeStudentRecord(deleteId);
                    break;

                case 5:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter updated full name: ");
                    String updatedName = scanner.nextLine();

                    System.out.print("Enter updated age: ");
                    int updatedAge = scanner.nextInt();
                    scanner.nextLine();

                    if (updatedAge <= 0) {
                        System.out.println("⚠ Age must be greater than 0.");
                        break;
                    }

                    System.out.print("Enter updated course name: ");
                    String updatedCourse = scanner.nextLine();

                    recordManager.modifyStudentDetails(updateId, updatedName, updatedAge, updatedCourse);
                    break;

                case 6:
                    System.out.println("Closing EduTrack Console...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}