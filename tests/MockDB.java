package tests;

public class MockDB {
    public Student mockStudent = new Student();
    public Professor mockProfessor = new Professor();
    public Admin mockAdmin = new Admin();

    public static final int userid = 101;
    public static final String username = "sanju";
    public static final String password = "12345";
    public static final String name = "Sanju";
    public static final int semister = 8;

    public DummyConstants() {
        createStudent(mockStudent);
        createProfessor(mockProfessor);
        createAdmin(mockAdmin);
    }

    private static void createStudent(Student student) {
        student.setStudentId(userid);
        student.setName(name);
        student.setSemester(semister);
    }

    private static void createProfessor(Professor professor) {
        professor.setName(name);
        professor.setUserName(username);
    }
}
