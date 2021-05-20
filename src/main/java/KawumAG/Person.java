package KawumAG;

public class Person {
    public String Role;

    public Person(String role){
        Role = role;
    }

    public Person() {

    }

    public String getRole() { return Role;}

    public String setRole(String role) {
        Role = role;
        return role;
    }


    @Override
    public String toString() {
        return "Person{" +
                "Role='" + Role + '\'' +
                '}';
    }
}

