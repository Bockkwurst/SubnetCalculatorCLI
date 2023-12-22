//Import Scanner Class for User Inputs

import java.util.Scanner;

public class Ipv4 {

    //Declaring the Variables for this Class
    SubnetMask subnetMask = new SubnetMask();
    Scanner ipv4 = new Scanner(System.in);
    String binResult1;
    String binResult2;
    String binResult3;
    String binResult4;
    int okt1Int;
    int okt2Int;
    int okt3Int;
    int okt4Int;
    boolean validated = true;
    String[] ipSplit;


    //Method for splitting and converting the User Input String
    public void stringToInt() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter a IPv4: ");

            //User Input
            String ip = ipv4.nextLine();

            //Split the User Input into a String[] excluding the Point.
            ipSplit = ip.split("\\.");

            // Try to parse the Arrays into an Integer and return validInput as true
            try {
                String okt1 = ipSplit[0];
                String okt2 = ipSplit[1];
                String okt3 = ipSplit[2];
                String okt4 = ipSplit[3];
                okt1Int = Integer.parseInt(okt1);
                okt2Int = Integer.parseInt(okt2);
                okt3Int = Integer.parseInt(okt3);
                okt4Int = Integer.parseInt(okt4);

                validInput = true;

                //in Case of a NumberFormatException print an Error on the CLI,
                //return validated false first to start the loop again
                //then reset validated to true, to prepare for a possible correct Input
            } catch (NumberFormatException e) {
                System.out.println("Wrong Input! (xxx.xxx.xxx.xxx)");
                validated = false;
                validated = true;
            }
        }
    }

    // Method to fill the Strings up to 8 Bits
    private String fillTo8Bits(int result) {
        String binaryString = Integer.toBinaryString(result);
        int length = binaryString.length();

        while (length < 8) {
            binaryString = "0" + binaryString;
            length++;
        }
        //binaryInt = Integer.parseInt(binaryString);

        return binaryString;
    }

    //Call the fillTo8Bits Method for each octet
    public void decToBin1() {
        binResult1 = fillTo8Bits(okt1Int);
    }

    public void decToBin2() {
        binResult2 = fillTo8Bits(okt2Int);
    }

    public void decToBin3() {
        binResult3 = fillTo8Bits(okt3Int);
    }

    public void decToBin4() {
        binResult4 = fillTo8Bits(okt4Int);
    }

    //Validate the correct amount of octets.
    public boolean isValidated() {
        int valSize = ipSplit.length;
        if (valSize != 4) {
            System.out.println("Not the correct Number of octets!");
            return false;
        }
        for (String octet : ipSplit) {
            int value = Integer.parseInt(octet);
            if (value < 0 || value > 255 || !validated) {
                System.out.println("Not a valid IPv4!");
                return false;
            }
        }
        return true;
    }

    //Print the Result on the CLI
    public void showResult() {
        if (isValidated()) {
            System.out.println("\n========>The IPv4 is valid!<========\n");
            System.out.println("Your IPv4: " + okt1Int + "." + okt2Int + "." + okt3Int + "." + okt4Int);
            System.out.println("Your IPv4 converted to binary: " + binResult1 + "." + binResult2 + "." + binResult3 + "." + binResult4);
        }
    }

}