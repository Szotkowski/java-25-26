package cz.xszotko1.cviceni4;

public abstract class Automobil implements Info, MotoroveVozidlo {

    @Override
    public String kdoJsem() {
        return "Automobil";
    }

    public abstract int pocetMist();

    public static String naCoJezdi(MotoroveVozidlo m) {
        return m.mujPalivo().name();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MotoroveVozidlo)) return false;

        MotoroveVozidlo m = (MotoroveVozidlo) obj;

        return this.mujMotor() == m.mujMotor()
                && this.mujPalivo() == m.mujPalivo();
    }

    public static MotoroveVozidlo getVozidlo() {
        return new MotoroveVozidlo() {
            @Override
            public Palivo mujPalivo() {
                return Palivo.NAFTA;
            }

            @Override
            public TypMotoru mujMotor() {
                return TypMotoru.DVOUTAKT;
            }
        };
    }
}
