package part2;

/*
@ASSESSME.USERID: userID
@ASSESSME.AUTHOR: author, list of authors
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/


public class Bridge {
    private boolean isOccupied = false;

    public synchronized void enterBridge (String name){
        while (isOccupied) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(name + " was interrupted while waiting to enter the bridge");
        }
    }
    isOccupied = true;
    System.out.println(name + " is entering the bridge.");
}

    public synchronized void leaveBridge (String name){
        isOccupied = false;
        System.out.println(name + " is leaving the bridge.");
        notifyAll();
    }
}