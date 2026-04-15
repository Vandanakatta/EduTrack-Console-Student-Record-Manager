public class Student {

    private int studentId;
    private String fullName;
    private int age;
    private String courseName;

    public Student(int studentId, String fullName, int age, String courseName) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.courseName = courseName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student ID : " + studentId + "\n" +
                "Name       : " + fullName + "\n" +
                "Age        : " + age + "\n" +
                "Course     : " + courseName + "\n" +
                "--------------------------";
    }
}
