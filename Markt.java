package projects.Markt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Markt {
    //1. Adım : Günleri içeren bir tane ArrayList oluşturun. (gunler)
    static ArrayList<String> gunler = new ArrayList<>(Arrays.asList("p.tesi", "salı", "carşamba", "perşembe", "cuma", "c.tesi", "pazar"));
    //2. Adım : Günlük kazançları ekleyeceğimiz bir tane ArrayList oluşturun. (gunlukKazanclar)
    static ArrayList<Double> gunlukKazanclar = new ArrayList<>();//2.adım
    Scanner scanner =new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Double> gkazanclar = gunlukKazanclar(gunler);
        System.out.println("\ngunluk kazanclar = " + gkazanclar);

        double ortKazanc =getOrtalamaKazanc(gkazanclar);
        System.out.println("ortalama Kazanc = " + ortKazanc);

        getOrtalamaninUstundeKazancGunleri(ortKazanc,gunler,gkazanclar);
        getOrtalamaninAltindaKazancGunleri(ortKazanc,gkazanclar);


    }

    private static void getOrtalamaninAltindaKazancGunleri(double ortKazanc, ArrayList<Double> gkazanclar) {
        ArrayList<String> gunler = new ArrayList<>(Arrays.asList("p.tesi", "salı", "carşamba", "perşembe", "cuma", "c.tesi", "pazar"));

        for (int i = 0,j=0; i < gunlukKazanclar.size(); i++,j++) {
            if (gunlukKazanclar.get(i)> ortKazanc ) {
                gunler.remove(gunler.get(j));
                j--;
            }
        }
        System.out.println("Ortalamanin Altinda Kazanc Gunleri::: : " + gunler);
    }

    private static void getOrtalamaninUstundeKazancGunleri(double ortKazanc, ArrayList<String> gunler, ArrayList<Double> gkazanclar) {

        for (int i = 0,j=0; i < gunlukKazanclar.size(); i++, j++) {
            if (gunlukKazanclar.get(i)< ortKazanc  ) {
                gunler.remove(gunler.get(j));
                j--;
            }
        }
        System.out.println("Ortalamanin Ustunde Kazanc Gunleri___ : " + gunler);

    }

    private static double getOrtalamaKazanc(ArrayList<Double> gkazanclar) {
        int toplam =0;
        int ortalamaKazanc=0;
        for (int i = 0; i < gkazanclar.size(); i++) {
            toplam+=gkazanclar.get(i);
        }
        ortalamaKazanc = toplam/gkazanclar.size();
        return ortalamaKazanc;
    }

    private static ArrayList<Double> gunlukKazanclar(ArrayList<String> gunler) {
        int i = 0;
        while (i < 7) {
            System.out.println(gunler.get(i) + "günü kazanci giriniz :\n");
            Scanner scan = new Scanner(System.in);
            double kazanc = scan.nextDouble();
            //int kazanc = (int) (Math.random() * 400 + 100);
            gunlukKazanclar.add(i, (double) kazanc);
            i++;
        }
        return gunlukKazanclar;

    }
}
