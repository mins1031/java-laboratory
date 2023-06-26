package java_lab.equals_hashcode.overoad_override;

public class OverloadTeam {
    private String name;
    private int membersCount;

    public OverloadTeam(String name, int membersCount) {
        this.name = name;
        this.membersCount = membersCount;
    }

    public String printName(String code) {
        return this.name + code;
    }

    public String printName(int code) {
        return this.name + code;
    }

    public String pringNameAndMemberCount() throws IllegalStateException {
        if (this.name == null) {
            throw new IllegalStateException();
        }
        return this.name + this.membersCount;
    }

    public String getName() {
        return name;
    }

    public int getMembersCount() {
        return membersCount;
    }
}
