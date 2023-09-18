import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScoresString() {
        StringBuilder scores = new StringBuilder("Exam Scores:\n");
        for (int i = 0; i < examScores.size(); i++) {
            scores.append("\tExam ").append(i + 1).append(" -> ").append(examScores.get(i)).append("\n");
        }
        return scores.toString();
    }

    public double getAverageExamScore() {
        if (examScores.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Double score : examScores) {
            sum += score;
        }
        return sum / examScores.size();
    }

    @Override
    public String toString() {
        return "Student Name: " + firstName + " " + lastName + "\n" +
                "> Average Score: " + getAverageExamScore() + "\n" +
                getExamScoresString();
    }
}