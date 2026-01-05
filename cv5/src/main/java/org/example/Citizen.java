package org.example;

import java.io.Serial;
import java.io.Serializable;

public class Citizen implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String name;
    private final String surname;
    private final String street;
    private final String postalCode;
    private final String city;

    public Citizen(String[] data) {
        if (data.length != 5) {
            throw new IllegalArgumentException("Očekáváno 5 prvků: jméno, příjmení, ulice, PSČ, město.");
        }
        this.name = data[0].trim();
        this.surname = data[1].trim();
        this.street = data[2].trim();
        this.postalCode = data[3].trim();
        this.city = data[4].trim();
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "jméno='" + name + '\'' +
                ", příjmení='" + surname + '\'' +
                ", ulice='" + street + '\'' +
                ", PSČ='" + postalCode + '\'' +
                ", město='" + city + '\'' +
                '}';
    }
}
