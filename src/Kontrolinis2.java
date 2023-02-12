import java.util.Scanner;

/*
2 laboratorinis darbas.
    Programos struktūrizacija (funkcijos)  Užduotis: Panaudoti šias funkcijas:
+   funkcija grąžinanti reikšmę be parametrų            double atimti()
+   funkcija grąžinanti reikšmę su parametrais        double sudeti(int sk1, int sk2)
+    funkcija negrąžinanti reikšmės be parametrų        void dalinti()
+   funkcija negrąžinanti reikšmės su parametrais        void dauginti(int sk1, int sk2)
+   funkcija su tuo pačiu pavadinimu tik skirtingu parametrų skaičiumi arba tipu
     Programavimo stilius (funkcijų dokumentacija(!), aiškūs kintamųjų ir funkcijų pavadinimai, atitraukimai...).
 */
public class Kontrolinis2 {
    public static void main(String[] args) {
        double d1;                     // vartotojo įvestas pirmas skaičius
        double d2;                     // vartotojo įvestas antras skaičius
        double sudetis, atimtis, formulesSkaiciavimas;
        int i = 0;    //  naudoja while
        int y = 0;      //  naudoja while
        String zenklas;                //vartotojo įvestas ženklas
        Scanner sk = new Scanner(System.in);
        Scanner sk2 = new Scanner(System.in);

        while (y != 1) {  // "y" reikalingas, kad patikrinti ar nori tęsti skaičiavimą
            System.out.println("Įveskite pirmą skaičių");
            d1 = sk.nextDouble();
            System.out.println("Įveskite antrą skaičių");
            d2 = sk.nextDouble();
            System.out.println("Įveskite veiksmą, galite įvesti šiuos veiksmus: \n\"+\"  \"-\"  \"*\"  \"/\" \"#\" " +
                    " \"&\" ");
            zenklas = sk2.nextLine();
            while (i != 1)  // reikalingas, kad patikrinti ar įvestas tinkamas ženklas (kodas iškarto žemiau)
                if (!"*".equals(zenklas) && !"/".equals(zenklas) && !"+".equals(zenklas) && !"-".equals(zenklas)
                        && !"#".equals(zenklas)&& !"&".equals(zenklas)) {
                    System.out.println("Įvestas netinkamas ženklas. Prašom pakartoti.");
                    zenklas = sk2.nextLine();
                } else {
                     i = 1;
                }
            switch (zenklas) {
                case "*":
                    System.out.print(d1 + " " + zenklas + " " + d2 + " = ");
                    dauginti(d1, d2);
                    break;
                case "/":
                    if (d2 == 0) {
                        System.out.println("Dalyba iš 0 negalima.");
                        break;
                    } else {
                        dalinti();
                        break;
                    }
                case "+":
                    sudetis = sudeti(d1, d2);
                    System.out.println(d1 + " " + zenklas + " " + d2 + " = " + sudetis);
                    break;
                case "-":
                    atimtis = atimti();
                    System.out.print(d1 + " " + zenklas + " " + d2 + " = ");
                    System.out.println(atimtis);
                    break;
                case "#":
                    sudetis = sudeti(d1, d2, 5);
                    System.out.println("Išmanusis sudėjimas: ");
                    System.out.println(d1 + " " + zenklas + " " + d2 + " = " + sudetis);
                    break;
// 2 laboratorinio darbo gynimas Papildyti 'Skaičiuotuvas' programą nauju funkcionalumu:
//Jeigu vartotojas įveda symbolį '&', rezultatus skaičiuoti ir išvesti pagal šią formulę:
// (sk2 + sk1) * sk2 + (sk2 - sk1) / sk1 * 101 = 58 < 100
//(sk2 + sk1) * sk2 + (sk2 - sk1) / sk1 * 102 = 100 == 100
// (sk2 + sk1) * sk2 + (sk2 - sk1) / sk1 * 199 = 127 > 100
// Reikalavimai:
// Sukurti funkciją grąžinančią rezultatą su parametrais
// double skaiciuotiFormule(double sk1, double sk2)

                case "&":
                    for (int z = 101; z < 200; z++) {
                        formulesSkaiciavimas = skaiciuotiFormule(d1,d2,z);
                        if (formulesSkaiciavimas < 100) {
                            spausdinti(d1,d2,z,formulesSkaiciavimas);
                            System.out.println(" < 100");
                        }
                        else if (formulesSkaiciavimas == 100) {
                            spausdinti(d1,d2,z,formulesSkaiciavimas);
                            System.out.println(" = 100");
                        }
                        else {
                            spausdinti(d1,d2,z,formulesSkaiciavimas);
                            System.out.println(" > 100");
                        }
                    }
                    break;
            }
            System.out.println("Ar norite tęsti skaičiavimą? Atsakykyte : \"taip\" arba \"ne\" ");
            zenklas = sk2.nextLine();
            if (zenklas.equals("ne")) {
                y = 1;
            } else if (zenklas.equals("taip")) {
                y = 0;
            } else {
                System.out.println("Netinkamas atsakymas");
                break;
            }
        }
        System.out.println("Darbas baigtas");
    }

   static double skaiciuotiFormule(double sk1, double sk2, int z){
      double skaiciavimoRezultatas = (sk2 + sk1) * sk2 + (sk2 - sk1) / sk1 * z;
      return skaiciavimoRezultatas;
    }
    static void spausdinti(double d1,double d2,int z,double fsk){
        System.out.print( "("+ d2 +" + " + d1+")" + " * " + d2 + " + " + "("+d2+" - " +d1+")" +
                " / "+d1+ " * " + z + " = " + fsk);
       // System.err.println("AAAA");
    }
    /** funkcija sudeda du skaičius
     *
     * @param x
     * @param y
     * @return
     */
    static double sudeti(double x, double y) {  //  funkcija grąžinanti reikšmę su parametrais
        double z = x + y;
        return z;
    }
    /** Funkcija prie dviejų skaičių sudėties prideda 5
     *
     * @param x
     * @param y
     * @param j
     * @return
     */
    static double sudeti(double x, double y, double j) {  //  funkcija grąžinanti reikšmę su parametrais
        double z = x + y + j;
        return z;
    }
    /** funkcija sudaugina du skaičius
     *
     * @param x
     * @param y
     */
    static void dauginti(double x, double y) {  //  funkcija negrąžinanti reikšmės su parametrais
        double z = x * y;
        System.out.println(z);
    }

    /** funkcija atima du skaičius
     *
     * @return
     *  d1 vartotojo įvestas pirmas skaičius
     *   d2 vartotojo įvestas antras skaičius
     */
    static double atimti() {                      //funkcija grąžinanti reikšmę be parametrų
        double d1;
        double d2;
        double atimimas;
        Scanner skm = new Scanner(System.in);
        System.out.println("Kadangi norite atimti, prašome dar kartą įveskite pirmą skaičių");
        d1 = skm.nextDouble();
        System.out.println("Dar kartą įveskite antrą skaičių");
        d2 = skm.nextDouble();
        atimimas = d1 - d2;
        return atimimas;
    }

    /** funkcija dalina du skaičius
     *
     *  d1 vartotojo įvestas pirmas skaičius
     *  d2 vartotojo įvestas antras skaičius
     */
    static void dalinti() {                    //funkcija negrąžinanti reikšmės be parametrų
        double d1;
        double d2;
        double atimimas;
        Scanner skm = new Scanner(System.in);
        System.out.println("Kadangi norite dalinti, prašome dar kartą įveskite pirmą skaičių");
        d1 = skm.nextDouble();
        System.out.println("Dar kartą įveskite antrą skaičių");
        d2 = skm.nextDouble();
        atimimas = d1 / d2;
        System.out.print(d1 + " " + "/" + " " + d2 + " = ");
        System.out.println(atimimas);
    }

}
