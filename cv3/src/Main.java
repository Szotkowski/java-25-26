public class Main {
    public static void main(String[] args) {
        Employee dev1 = new Employee("Pavel", "Novák", "programátor");
        Employee dev2 = new Employee("Jana", "Svobodová", "testera");
        Employee admin = new Employee("Karel", "Dvořák", "administrátor");

        System.out.println("--- Testování třídy TeamLeader (dědičnost) ---");

        TeamLeader leader = new TeamLeader("Veronika", "Černá", 3);

        leader.addTeamMember(dev1);
        leader.addTeamMember(dev2);

        System.out.println("Přidání admina: " + leader.addTeamMember(admin));

        Employee dev3 = new Employee("Eva", "Malá", "programátorka");
        System.out.println("Přidání dev3 (plný tým): " + leader.addTeamMember(dev3));

        System.out.println("\nInformace o vedoucím:");
        System.out.println(leader.toString());

        System.out.println("--- Testování statické metody ---");
        TeamLeader staticLeader = TeamLeader.getTeamLeader("Petr", "Král", "5");
        System.out.println(staticLeader.toString());
    }
}