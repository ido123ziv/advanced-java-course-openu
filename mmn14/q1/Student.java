public class Student implements Comparable<Student>{
    private String name;
    private String id;
    private double grade;

    /**
     * Constructor for Student
     * @param n -> name of the student
     * @param sId -> id of the student
     * @param g -> grade of the student
     */
    public Student(String n, String sId, double g){
       this.id = sId;
       this.name = n;
       this.grade = g;
    }

    /**
     * the method compares two Students by their grades
     * @param o the object to be compared.
     * @return who has better grades
     */
    @Override
    public int compareTo(Student o) {
        return Double.compare(this.grade, o.grade);
    }

    /**
     * pretty print of the Student details
     * @return -> string representing the student
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", grade=" + grade +
                '}';
    }
}
