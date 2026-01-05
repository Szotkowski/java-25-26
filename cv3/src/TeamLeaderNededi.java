public class TeamLeaderNededi {
    private Employee employeeData;

    private Employee[] teamMembers;
    private int numOfTeamMembers;

    public TeamLeaderNededi(String name, String surname, int maxNumOfTeamMembers) {
        this.employeeData = new Employee(name, surname, "Já řídím tým (verze s kompozicí).");
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

    @Override
    public String toString() {
        return this.employeeData.toString();
    }
}