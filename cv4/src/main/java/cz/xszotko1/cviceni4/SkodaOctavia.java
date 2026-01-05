package cz.xszotko1.cviceni4;

public class SkodaOctavia extends Automobil {

    private final Palivo palivo;
    private final TypMotoru typMotoru;
    private final int pocetMist;

    public SkodaOctavia(Palivo palivo, TypMotoru typMotoru, int pocetMist) {
        this.palivo = palivo;
        this.typMotoru = typMotoru;
        this.pocetMist = pocetMist;
    }

    @Override
    public Palivo mujPalivo() {
        return palivo;
    }

    @Override
    public TypMotoru mujMotor() {
        return typMotoru;
    }

    @Override
    public int pocetMist() {
        return pocetMist;
    }

    @Override
    public String kdoJsem() {
        return "Skoda Octavia";
    }
}
