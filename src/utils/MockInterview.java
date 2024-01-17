package utils;

import java.util.Random;

public class MockInterview {
    public static void main(String[] args) {
        String[] names=new String[]{
                "Ilyosbek Mamashukurov",
                "Muhammadumar",
                "Muhammadaziz Yo'ldoshev",
                "Ali Negmatov",
                "Muhammadaziz Ergashev",
                "Asadbek Abdinazarov",
                "Sharifboyev Abdurahmon",
                "Ahmadjonov Isfandiyor",
                "Suhrob Hosiljonov",
                "Jahongir Esanboyev",
                "Baxrombek Isamaxamatov",
                "Yusufbek Murodov",
                "Muhammadanasxon Madaminov",
                "Samandar Orifjonov",
                "Xusniddin Muhiddinov",
                "Salimov Qudratilla",
                "Javohir",
                "Rashidov Shohjahon",
                "Asadbek Isakulov",
                "Aslamov Doston"
        };


        Random rand=new Random();
        System.out.println(names[rand.nextInt(20)]);
    }
}
