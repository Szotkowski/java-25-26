package cz.xszotko1.cviceni4;

public class Main {
    public static void printInfo(Info info) {
        System.out.println(info.kdoJsem());
    }

    public static void main(String[] args) {
        Info mojeAuto = new SkodaOctavia(Palivo.NAFTA, TypMotoru.CTYRTAKT, 5);
        printInfo(mojeAuto);
    }
}
