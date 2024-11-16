package java_cote.programmers.level2;

public class SkillTree {

    public int solution(String skill, String[] skillTrees) {
        int result = 0;

        for (String tree : skillTrees) {
            String[] treeSkills = tree.split("");
            int count = countingMatchSkill(skill, treeSkills);

            if (count == -1) {
                continue;
            }

            result++;
        }

        return result;
    }

    private int countingMatchSkill(String skill, String[] treeSkills) {
        int count = 0;

        for (String treeSkill : treeSkills) {
            int skillIndex = skill.indexOf(treeSkill);
            if (skillIndex == -1) {
                continue;
            }

            if (count >= skill.length()) {
                break;
            }

            if (skillIndex > count) {
                count = -1;
                break;
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};
        SkillTree skillTree = new SkillTree();
        int solution = skillTree.solution(skill, skillTrees);
        System.out.println(solution);
    }
}
