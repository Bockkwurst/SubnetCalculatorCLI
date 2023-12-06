import java.util.Scanner;
import java.util.ArrayList;
public class SubnetMask{

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

   public void ipvalidate() {
       Ipv4 ipv4 = new Ipv4();
       ipv4.isValidated();
       if (ipv4.validated) {

       } else {
           System.exit(0);
       }
   }


    public void stringToInt() {
        System.out.println("Subnetmaske eingeben: ");
        String snm = mask.nextLine();
        snmSplit = snm.split("\\.");
        String okt1 = snmSplit[0];
        String okt2 = snmSplit[1];
        String okt3 = snmSplit[2];
        String okt4 = snmSplit[3];
        okt1Int = Integer.parseInt(okt1);
        okt2Int = Integer.parseInt(okt2);
        okt3Int = Integer.parseInt(okt3);
        okt4Int = Integer.parseInt(okt4);
    }


    private String fillTo8Bits(int result) {
        String binaryString = Integer.toBinaryString(result);
        int length = binaryString.length();

        while (length < 8) {
            binaryString = "0" + binaryString;
            length++;
        }
        return binaryString;
    }

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

    public boolean isValidatedSub() {
        int valSize = snmSplit.length;
        if (valSize != 4) {
            System.out.println("Ungültige Anzahl der Oktetten!");
            return false;
        }
        for(String octet : snmSplit){
            int value = Integer.parseInt(octet);
            if (value <0  || value >255){
                System.out.println("Ungültiger Wert in der Subnetmask!");
                return false;
            }
        }
        return true;
    }

    public void showResultSub() {
        if (isValidatedSub()) {
            System.out.println("Die Subnetmask hat 4 Oktetten");
            System.out.println("Deine Subnetmask: " + okt1Int + "." + okt2Int + "." + okt3Int + "." + okt4Int);
            System.out.println("Deine Subnetmask in Binär umgewandelt: " + binResult1 + "." + binResult2 + "." + binResult3 + "." + binResult4);
        }
    }

}