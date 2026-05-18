package atributoStatic;

public class MainClassroom {
    public static void main(String[] args) {
        Classroom student1 = new Classroom("María");
        Classroom student2 = new Classroom("Juan");

        student1.showInfo();
        student2.showInfo();

        Classroom.setSchoolName("Escuela 2");

        student1.showInfo();
        student2.showInfo();
    }
}
