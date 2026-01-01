import java.util.ArrayList;

class Student {
    protected int studentID;
    protected String name;
    protected int level;
    protected ArrayList<Course> courses;
    private static int nextId = 1;

    public Student(String name, int level) {
        this.name = name;
        this.level = level;
        this.courses = new ArrayList<Course>;
        this.studentID = nextID;
        nextID++;
    
    public String getName() {
        return this.name;
    }
        
    public int getLevel() {
        return this.level;
    }

    public course getCourses() {
        return this.courses;
    }
    
    public int getID() {
        return this.studentID;
    }

    public setName (String name) {
        this.name = name;
    }

    public setLevel(int level) {
        this.level = level; 
    }
    
    public addCourse(Course course) {
        this.courses.add(course);
    }
}

class Course {
    protected int code;
    protected String name;
    protected ArrayList<Student> students;
    protectedi ArrayList<Assessment> exams;
    private static int nextCode = 10;

    public Course(name, exams) {
        this.name = name;
        this.
