package java_lab.equals_hashcode.overoad_override;

public class OverrideChildTeam extends OverloadTeam {
    private String childName;

    public OverrideChildTeam(String name, int membersCount, String childName) {
        super(name, membersCount);
        this.childName = childName;
    }

    @Override
    public String pringNameAndMemberCount() throws Exception {
        if (this.childName == null) {
            throw new Exception();
        }
        return getName() + getMembersCount() + this.childName;
    }
}
