package java_lab.equals_hashcode.hashcode_problem;

import java.util.Objects;

public class HashTeam {

    private String city;
    private String department;

    public HashTeam(String city, String department) {
        this.city = city;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTeam hashTeam = (HashTeam) o;
        return Objects.equals(city, hashTeam.city) && Objects.equals(department, hashTeam.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, department);
    }
}
