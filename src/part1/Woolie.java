package part1;

/*
@ASSESSME.USERID: dl9691, korg626
@ASSESSME.AUTHOR: Dora Lovric
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/

public class Woolie implements Runnable {


    private String name;
    private int crossingTime;
    private String startCity;
    private String destinationCity;

    

    public Woolie(String name, int crossingTime, String startCity, String destinationCity) {
        this.name = name;
        this.crossingTime = crossingTime;
        this.startCity = startCity;
        this.destinationCity = destinationCity;
    }



    @Override
    public void run() {
       System.out.println(name + " has arrived a the bridge at " + startCity + ".");
       try{
        Thread.sleep(1000);
        System.out.println(name + "is starting to cross.");
        for (int i = 1; i<= crossingTime; i++) {
            Thread.sleep(1000);
            System.out.println("\t" + name + ": " + i + " seconds.");
        }
        System.out.println(name + " arrives at" +destinationCity);
       }
       catch (InterruptedException e){
        System.out.println(name + "was interrupter while crossing the bridge.");
       }
    }

    public static void main(String[] args) {
        Woolie ahmed = new Woolie("Ahmed", 5, "COurtwald", "Glassdell");
        Woolie chris = new Woolie("Chris", 6, "Glassdell", "Glassdell");
        Woolie bruce = new Woolie("Bruce", 7, "COurtwald", "Glassdell");
        Woolie bobby = new Woolie("Bobby", 8, "Glassdell", "Glassdell");


        Thread ahmedThread = new Thread(ahmed);
        Thread chrisThread = new Thread(chris);
        Thread bruceThread = new Thread(bruce);
        Thread bobbyThread = new Thread(bobby);

        ahmedThread.start();
        chrisThread.start();
        bruceThread.start();
        bobbyThread.start();

        try{
            ahmedThread.join();
            chrisThread.join();
            bruceThread.join();
            bobbyThread.join();
        }
        catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("All wollies have crossed the brdge.");

    }

}