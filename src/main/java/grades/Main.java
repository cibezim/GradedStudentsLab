import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create students
        Student student1 = new Student("Julio", "Rodriques", new Double[]{85.0, 90.0, 88.0});
        Student student2 = new Student("Ki", "Chan", new Double[]{92.0, 87.0, 95.0});
        Student student3 = new Student("Andy", "Zhang", new Double[]{88.0, 97.0, 92.0});
        Student student4 = new Student("Bryan", "Smith", new Double[]{75.0, 99.0,91.0});
        Student student5 = new Student("Jordan", "Mitchell", new Double[]{88.0, 93.0, 97.0});
        Student student6 = new Student("Wyatt", "Hall", new Double[]{80.0, 86.0, 99.0});


        Student[] students = {student1, student2, student3, student4, student5};


        Classroom classroom = new Classroom(students);


        System.out.println("Classroom Average Exam Score: " + classroom.getAverageExamScore());
        System.out.println("Students by Score:");
        for (Student student : classroom.getStudentsByScore()) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }


        Student newStudent = new Student("Jordan", "Mitchell", new Double[]{75.0, 80.0, 78.0});
        classroom.addStudent(newStudent);


        classroom.removeStudent("Julio", "Rodrigues");


        System.out.println("Updated Classroom Average Exam Score: " + classroom.getAverageExamScore());
        System.out.println("Updated Students by Score:");
        for (Student student : classroom.getStudentsByScore()) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }


        System.out.println("Grade Book:");
        for (Map.Entry<Student, Character> entry : classroom.getGradeBook().entrySet()) {
            System.out.println(entry.getKey().getFirstName() + " " + entry.getKey().getLastName() + ": " + entry.getValue());
        }
    }
}