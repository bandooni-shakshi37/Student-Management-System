import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Student student = new Student(id, name, age, course, email);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== Student List =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    public void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();

        Student student = findStudent(id);

        if (student != null) {
            System.out.println("\nStudent Found:");
            student.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setEmail(email);

        System.out.println("Student updated successfully!");
    }

    public void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        Student student = findStudent(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private Student findStudent(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void start() {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using the Student Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}