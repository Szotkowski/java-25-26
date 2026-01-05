public class Employee {
    private String name;
    private String surname;
    private String jobDescription;

    public Employee(String name, String surname, String jobDescription) {
        this.name = name;
        this.surname = surname;
        this.jobDescription = jobDescription;
    }

    public String getJobDescription() {
        return this.jobDescription;
    }

    @Override
    public String toString() {
        return String.format("Jsem %s %s, %s.", this.name, this.surname, this.getJobDescription());
    }
}