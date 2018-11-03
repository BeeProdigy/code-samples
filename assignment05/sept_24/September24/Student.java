public class Student extends Person{
    private int sid;
    private String course;
    private String teacherName;

    public Student(String fName, String lName, int studentId,
                   String in_course, String in_teacherName){
        super(fName, lName);
        sid = studentId;
        course = in_course;
        teacherName = in_teacherName;
        
        
    }

        public static void main(String[] argv){
        Student student = new Student("Alessandro", "Bran", 1,
                "Programming 211", "Stephani Brendanus");

        System.out.println("First name: " + student.getFirstName());
        System.out.println("Last name: " + student.getLastName());
    }
}
