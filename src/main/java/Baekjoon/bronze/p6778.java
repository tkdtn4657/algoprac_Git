package Baekjoon.bronze;

import java.io.*;

public class p6778 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int antena = Integer.parseInt(br.readLine());
        int eyes = Integer.parseInt(br.readLine());

        isTroyMartian(antena, eyes);
        isVladSaturnian(antena, eyes);
        isGraemeMercurian(antena, eyes);

    }

    static void isTroyMartian(int antena, int eyes) {
        if (antena >= 3 && eyes <= 4) {
            System.out.println("TroyMartian");
        }
    }

    static void isVladSaturnian(int antena, int eyes) {
        if (antena <= 6 && eyes >= 2) {
            System.out.println("VladSaturnian");
        }
    }

    static void isGraemeMercurian(int antena, int eyes) {
        if (antena <= 2 && eyes <= 3) {
            System.out.println("GraemeMercurian");
        }
    }
}
