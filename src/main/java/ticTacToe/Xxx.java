package ticTacToe;

import java.util.Scanner;

public class Xxx {
    private static boolean czyStringToInt(String wejscie) {
        try {
            Integer.parseInt(wejscie);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String[][] tablica() {

        String[][] tab = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tab[i][j] = "" + (j + i * 3);
            }
        }
        return tab;
    }

    private static void wyswietl(String tab[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print("[" + tab[i][j] + "]");
            }
            System.out.println();
        }
    }

    private static Integer wyborCzymGramy() {

        System.out.println("Zagraj w kółko i krzyżyk\nKto ma zacząć?\nX wciśnij 1\nO wciśnij 2");
        return wybierzPole(1, 2);

    }

    private static Integer wybierzPole(int min, int max) {
        boolean czyWybralismyPole = false;
        Scanner scanner = new Scanner(System.in);
        while (!czyWybralismyPole) {
            String zmienna = scanner.nextLine();
            if (czyStringToInt(zmienna) && (Integer.parseInt(zmienna) >= min && Integer.parseInt(zmienna) <= max)) {
                czyWybralismyPole = true;
                return Integer.parseInt(zmienna);
            } else {
                System.out.println("podaj liczbe od " + min + " do " + max);
            }
        }
        System.out.println("O");
        return -1;
    }

    private static boolean warunekWygranej(String tab[][], String ruch) {
        if ((tab[0][0] == ruch && tab[0][1] == ruch && tab[0][2] == ruch) ||
                (tab[1][0] == ruch && tab[1][1] == ruch && tab[1][2] == ruch) ||
                (tab[2][0] == ruch && tab[2][1] == ruch && tab[2][2] == ruch) ||
                (tab[0][0] == ruch && tab[1][0] == ruch && tab[2][0] == ruch) ||
                (tab[0][1] == ruch && tab[1][1] == ruch && tab[2][1] == ruch) ||
                (tab[0][2] == ruch && tab[1][2] == ruch && tab[2][2] == ruch) ||
                (tab[0][0] == ruch && tab[1][1] == ruch && tab[2][2] == ruch) ||
                (tab[0][2] == ruch && tab[1][1] == ruch && tab[2][0] == ruch)
                ) {
            return true;
        }
        return false;

    }

    public static void gra() {
        boolean zwyciestwo = false;
        int nextRuch = 0;
        String ruch="";
        String gracz1 = "X";
        String gracz2 = "O";
        String tab[][] = tablica();

        if (wyborCzymGramy() == 2) {
            gracz1 = "O";
            gracz2 = "X";
        }
        wyswietl(tab);
        while (!zwyciestwo) {
            if (nextRuch % 2 == 0) {
                ruch = gracz1;
            } else {
                ruch = gracz2;
            }

            System.out.println("Ruch Gracza " + ruch+ "\nWybierz pole");
            int a = wybierzPole(0, 8);
            int x = a / 3;
            int y = a % 3;

            if (tab[x][y].equals("X") || tab[x][y].equals("O")) {
                System.out.println("Pole już zajęte, podaj inne pole");
            } else {
                nextRuch++;
                tab[x][y] = ruch;
                wyswietl(tab);
                zwyciestwo = warunekWygranej(tab, ruch);

                if (nextRuch == 9) {
                    System.out.println("Remis!!!!!!");
                    return;
                }
            }
        }
        if (zwyciestwo = true)
            System.out.println("Wygral Gracz " + ruch + "!!!!!!!!!!");

    }

    public static void main(String[] args) {
        gra();
    }
}
