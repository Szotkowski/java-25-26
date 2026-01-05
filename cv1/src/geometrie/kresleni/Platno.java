package geometrie.kresleni;

import geometrie.utvary.Kruh;

public class Platno {
    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        Kruh mujKruh = new Kruh(10, 5, 3);

        System.out.println(mujKruh.getPolomer());
        System.out.println(mujKruh.obvod());
        System.out.println(mujKruh.obvodInt());

        mujKruh.setPolomer(25);

        System.out.println(mujKruh.getPolomer());
        System.out.println(mujKruh.obvod());
        System.out.println(mujKruh.obvodInt());

        Platno platno = new Platno();
        int cislo1 = 43;
        int cislo2 = 128;
        int vetsiCislo = platno.max(cislo1, cislo2);

        System.out.print(vetsiCislo);
    }
}
