public class Main {
    public static void main(String[] args) {
        System.out.println("Creating Group!");
        SortedGroup<Student> sg = new SortedGroup<Student>();
        Student s1 = new Student("Ido", "000000001", 98);
        Student s2 = new Student("Ziv", "000000002", 97);
        Student s3 = new Student("IdoZiv", "000000003", 96);
        Student s4 = new Student("Shalom", "000000004", 95);
        Student s5 = new Student("IdoShalom", "000000005", 98);
        Student s6 = new Student("ShalomZiv", "000000006", 94);
        System.out.println("Testing adding");
        sg.add(s1);
        sg.add(s2);
        sg.add(s3);
        sg.add(s4);
        sg.add(s5);
        sg.add(s6);
        System.out.println("SortedGroup: \n" + sg);
        System.out.println("Testing Removal");
        sg.remove(s4);
        sg.remove(s6);
        System.out.println("SortedGroup: \n" + sg);

        System.out.println("Adding some more");
        sg.add(new Student("aIdo", "000000011", 58));
        sg.add(new Student("aZiv", "000000012", 57));
        sg.add(new Student("aIdoZiv", "000000013", 56));
        sg.add(new Student("aShalom", "000000014", 55));
        sg.add(new Student("aIdoShalom", "000000015", 58));
        sg.add(new Student("aShalomZiv", "000000016", 54));
        System.out.println("SortedGroup: \n" + sg);

        System.out.println("Testing Reduce");
        SortedGroup<Student> passing = Reduce.reduce(sg, new Student("Test", "99999999", 60));
        System.out.println(passing);
    }


}