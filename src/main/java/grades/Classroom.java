import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


class Classroom {


    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        int count = 0;
        for (Student student : students) {
            if (student != null) {
                sum += student.getAverageExamScore();
                count++;
            }
        }
        return (count > 0) ? (sum / count) : 0.0;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getFirstName().equals(firstName) &&
                    students[i].getLastName().equals(lastName)) {
                students[i] = null;
                break;
            }
        }
    }

    public Student[] getStudentsByScore() {
        Arrays.sort(students, (s1, s2) -> {
            if (s1 == null) return 1;
            if (s2 == null) return -1;
            int result = Double.compare(s2.getAverageExamScore(), s1.getAverageExamScore());
            if (result == 0) {
                result = s1.getLastName().compareTo(s2.getLastName());
                if (result == 0) {
                    return s1.getFirstName().compareTo(s2.getFirstName());
                }
            }
            return result;
        });

        return students;
    }

    public Map<Student, Character> getGradeBook() {
        Map<Student, Character> gradeBook = new HashMap<>();
        double[] examAverages = new double[students.length];
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                examAverages[i] = students[i].getAverageExamScore();
            }
        }
        Arrays.sort(examAverages);

        double upper10thPercentile = examAverages[(int) (0.9 * examAverages.length)];
        double upper30thPercentile = examAverages[(int) (0.7 * examAverages.length)];
        double upper50thPercentile = examAverages[(int) (0.5 * examAverages.length)];
        double lower11thPercentile = examAverages[(int) (0.1 * examAverages.length)];

        for (Student student : students) {
            if (student != null) {
                double average = student.getAverageExamScore();
                char grade;
                if (average >= upper10thPercentile) {
                    grade = 'A';
                } else if (average >= upper30thPercentile) {
                    grade = 'B';
                } else if (average >= upper50thPercentile) {
                    grade = 'C';
                } else if (average >= lower11thPercentile) {
                    grade = 'D';
                } else {
                    grade = 'F';
                }
                gradeBook.put(student, grade);
            }
        }

        return gradeBook;
    }
}




