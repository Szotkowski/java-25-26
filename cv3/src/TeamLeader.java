public class TeamLeader extends Employee {
    private Employee[] teamMembers;
    private int numOfTeamMembers;

    public TeamLeader(String name, String surname, int maxNumOfTeamMembers) {
        super(name, surname, "Já řídím tým.");
        this.teamMembers = new Employee[maxNumOfTeamMembers];
        this.numOfTeamMembers = 0;
    }

    public boolean addTeamMember(Employee employee) {
        if (numOfTeamMembers < teamMembers.length) {
            teamMembers[numOfTeamMembers] = employee;
            numOfTeamMembers++;
            return true;
        }
        return false;
    }

    public static TeamLeader getTeamLeader(String name, String surname, String maxNumOfTeamMembersStr) {
        int maxMembers = Integer.parseInt(maxNumOfTeamMembersStr);
        return new TeamLeader(name, surname, maxMembers);
    }

    @Override
    public String getJobDescription() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.getJobDescription());
        sb.append("\n");
        sb.append("Vedu tyto lidi:\n");

        for (int i = 0; i < numOfTeamMembers; i++) {
            sb.append("- ").append(teamMembers[i].toString()).append("\n");
        }

        return sb.toString();
    }
}