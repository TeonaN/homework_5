package homework;

import java.io.*;
import java.util.*;



class Galaxy {
    private Scanner scan = new Scanner(System.in);
    private String name;
    private int diametre;
    private int temp;
    private String planetName;
    private int speed;


    public void star() {
        while (true) {
            try {
                File file = new File("Data.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                PrintWriter writer = new PrintWriter(new FileWriter(file, true));

                System.out.println("შექმენით ვარსკვლავი ");
                System.out.println("გასათიშად დააჭირეთ 1,გაგრძელების შემთხვევაში ნებისმიერს");
                String a = scan.next();
                if (a.equals("1")) {
                    break;
                }
                System.out.print("სახელი: ");
                writer.write("ვარსკვლავის სახელი ");
                name = scan.next();
                writer.println(name);
                System.out.print("დიამეტრი: ");
                writer.write("ვარსკვლავის დიამეტრი ");
                diametre = scan.nextInt();
                writer.println(diametre);
                System.out.print("ტემპერატურა: ");
                writer.write("ვარსკვლავის ტემპერატურა ");
                temp = scan.nextInt();
                writer.println(temp);


                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void planet() {
        while (true) {
            try {
                File file = new File("Data.txt");

                PrintWriter writer = new PrintWriter(new FileWriter(file, true));


                System.out.println("შექმენით პლანეტა");
                System.out.println("გასათიშად დააჭირეთ 2,გაგრძელების შემთხვევაში ნებისმიერს");
                String a = scan.next();
                if (a.equals("2")) {
                    break;
                }
                System.out.print("პლანეტის სახელი: ");
                planetName = scan.next();
                System.out.print("ვარსკვლავი, რომლის გარშემო ტრიალებს: ");
                writer.write("ვარსკვლავი, რომლის გარშემო ტრიალებს ");

                String starName = scan.next();
                writer.println(starName);
                if (starName.equals(name)) {

                    writer.write("პლანეტის სახელი ");
                    writer.println(planetName);
                    System.out.print("რა სიჩქარით გადაადგილდება სივრცეში: ");
                    speed = scan.nextInt();
                    writer.write("რა სიჩქარით გადაადგილდება სივრცეში ");
                    writer.println(speed);
                } else {
                    System.out.println("ვარსკვლავი არ არსებობს");
                }

                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }




    public void seeGalaxy() {

        System.out.println("დაათვალიერეთ გალაქტიკა");
        System.out.println("გალაქტიკის დასათვალიერებლად დააჭირეთ 3");
        String b = scan.next();
        if (b.equals("3")) {

            try {
                FileReader fr = new FileReader("Data.txt");
                BufferedReader br = new BufferedReader(fr);
                String str;
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
                br.close();
            } catch (IOException ex) {
                System.out.println("ds");
            }
        }
    }

    public void planetData() {
        System.out.println(name + "-ის " + "გარშემო ტრიალებს");
        System.out.println(speed + "-ით " + "გადაადგილდება სივრცეში");
    }


    public void callPlanet() {
        String hh = scan.nextLine();
        System.out.print("გამოიძახეთ პლანეტა. ჩაწერეთ მისი სახელი: ");
        String plName = scan.nextLine();
        if (plName.equals(planetName)) {
            planetData();
        } else {
            System.out.println("პლანეტა არ არსებობს");
        }

    }
}
