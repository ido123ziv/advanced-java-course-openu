public class Student implements Comparable<Student>{
    private String name;
    private String id;
    private double grade;

    public Student(String n, String sId, double g){
       this.id = sId;
       this.name = n;
       this.grade = g;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.grade, o.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", grade=" + grade +
                '}';
    }
}
