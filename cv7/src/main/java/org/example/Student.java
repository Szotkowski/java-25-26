package org.example;

import java.util.Objects;

public record Student(String UID, String prijmeni, String jmeno) implements Comparable<Student> {

    @Override
    public String toString() {
        return UID + ";" + prijmeni + ";" + jmeno;
    }

    @Override
    public int compareTo(Student other) {
        return this.prijmeni.compareToIgnoreCase(other.prijmeni);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student s)) return false;
        return UID.equals(s.UID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UID);
    }
}
