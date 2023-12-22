//Importing Scanner Class for User Inputs
import java.util.Scanner;

public class SubnetMask {
    //Declaring variables for this Class
    Scanner mask = new Scanner(System.in);
    String binResult1;
    String binResult2;
    String binResult3;
    String binResult4;
    int okt1Int;
    int okt2Int;
    int okt3Int;
    int okt4Int;
    boolean validatedSub;
    String[] snmSplit;


    //Method for splitting and converting the User Input String to an Integer
    public void stringToInt() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter a Subnetmask: ");

            //User Input
            String snm = mask.nextLine();

            //Check the User Input for a valid Subnetmask
            if (snm.equals("128.0.0.0") || snm.equals("192.0.0.0") ||
                    snm.equals("255.0.0.0") || snm.equals("255.128.0.0") ||
                    snm.equals("255.192.0.0") || snm.equals("255.224.0.0") ||
                    snm.equals("255.240.0.0") || snm.equals("255.248.0.0") ||
                    snm.equals("255.252.0.0") || snm.equals("255.254.0.0") ||
                    snm.equals("255.255.0.0") || snm.equals("255.255.128.0") ||
                    snm.equals("255.255.192.0") || snm.equals("255.255.224.0") ||
                    snm.equals("255.255.240.0") || snm.equals("255.255.248.0") ||
                    snm.equals("255.255.252.0") || snm.equals("255.255.254.0") ||
                    snm.equals("255.255.255.0") || snm.equals("255.255.255.128") ||
                    snm.equals("255.255.255.192") || snm.equals("255.255.255.224") ||
                    snm.equals("255.255.255.240") || snm.equals("255.255.255.248") ||
                    snm.equals("255.255.255.252")) {
                System.out.println("Valid Subnetmask");
            } else {
                System.out.println("Not a valid Subnetmask");
            }
            //Splitting the String in four parts. Excluding the Points.
            snmSplit = snm.split("\\.");

            //Try to parse the String[] into an Integer and return validInput as true.
            try {
                String okt1 = snmSplit[0];
                String okt2 = snmSplit[1];
                String okt3 = snmSplit[2];
                String okt4 = snmSplit[3];
                okt1Int = Integer.parseInt(okt1);
                okt2Int = Integer.parseInt(okt2);
                okt3Int = Integer.parseInt(okt3);
                okt4Int = Integer.parseInt(okt4);


                //System.out.println("okt1Int: " + okt1Int);  // Hinzugefügt
                //System.out.println("okt2Int: " + okt2Int);  // Hinzugefügt
                //System.out.println("okt3Int: " + okt3Int);  // Hinzugefügt
                //System.out.println("okt4Int: " + okt4Int);  // Hinzugefügt
                validInput = true;
                //When parsing is not possible due to a NumberFormatException, print this Error on the CLI and return validatedSub as false.
            } catch (NumberFormatException e) {
                System.out.println("Wrong Input! (xxx.xxx.xxx.xxx)");
                validatedSub = false;
            }
        }
    }

    //Method to Fill (if necessary) the Integers to 8 bits
    private String fillTo8Bits(int result) {
        String binaryString = Integer.toBinaryString(result);
        int length = binaryString.length();

        // While the bits are less than 8, put a 0 on the start of the String and return binaryString when the String is 8 bits.
        while (length < 8) {
            binaryString = "0" + binaryString;
            length++;
        }
        return binaryString;
    }

    //Calling the Method for filling up for each octet.
    public void decToBin1() {
        binResult1 = fillTo8Bits(okt1Int);
        //System.out.println("binResult1: " + binResult1);
    }

    public void decToBin2() {
        binResult2 = fillTo8Bits(okt2Int);
        //System.out.println("binResult2: " + binResult2);
    }

    public void decToBin3() {
        binResult3 = fillTo8Bits(okt3Int);
        //System.out.println("binResult3: " + binResult3);
    }

    public void decToBin4() {
        binResult4 = fillTo8Bits(okt4Int);
        //System.out.println("binResult4: " + binResult4);
    }

    //Validating the correct amount of octets.
    public boolean isValidatedSub() {
        int valSize = snmSplit.length;
        if (valSize != 4) {
            System.out.println("Not the correct Number of octets!");
            return false;
        }
        return true;
    }

    //If isvalidatedSub returns true, print the Result on the CLI
    public void showResultSub() {
        if (isValidatedSub()) {
            System.out.println("\n========>The Subnetmask is Valid!<========\n");
            System.out.println("Your Subnetmask: " + okt1Int + "." + okt2Int + "." + okt3Int + "." + okt4Int);
            System.out.println("Your Subnetmask converted to binary: " + binResult1 + "." + binResult2 + "." + binResult3 + "." + binResult4);
        }
    }
}