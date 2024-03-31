import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int sid;

    public Student(String name, int sid) {
        this.name = name;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "{" + "name : " + name
                + "; Roll no : " + sid + "}";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Student stud = (Student) obj;
        return sid == stud.sid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid);
    }

    @Override
    public int compareTo(Student obj) {
        return this.sid - obj.sid;
    }
}

public class SetAndObjects {
    public static void main(String[] args) {

        // Set<Student> stud = new LinkedHashSet<>();

        List<Student> stud = new ArrayList<>();

        stud.add(new Student("ABC", 33));
        stud.add(new Student("ABC", 18));
        stud.add(new Student("RTY", 65));
        stud.add(new Student("QWE", 9));

        System.out.println(stud);

        Student sr = new Student("PQR", 99);

        stud.remove(sr);

        System.out.println();

        Collections.sort(stud, new Comparator<Student>(){
            public int compare(Student s1, Student s2)
            {
                int x = s1.name.compareTo(s2.name);

                if(x == 0)
                {
                    return s1.sid - s2.sid;
                }
                return x;
            }
        });

        System.out.println(stud);

    }
}
