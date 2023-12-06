import java.util.Scanner;

public class Ipv4{

    Scanner ipv4 = new Scanner(System.in);
    String binResult1;
    String binResult2;
    String binResult3;
    String binResult4;
    int okt1Int;
    int okt2Int;
    int okt3Int;
    int okt4Int;
    boolean validated;
    String[] ipSplit;

    public void stringToInt() {
        System.out.println("IPv4 eingeben: ");
        String ip = ipv4.nextLine();
        ipSplit = ip.split("\\.");
        String okt1 = ipSplit[0];
        String okt2 = ipSplit[1];
        String okt3 = ipSplit[2];
        String okt4 = ipSplit[3];
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
        //binaryInt = Integer.parseInt(binaryString);

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

    public boolean isValidated() {
        int valSize = ipSplit.length;
        if (valSize != 4) {
            System.out.println("Ungültige Anzahl der Oktetten!");
            return false;
        }
        for(String octet : ipSplit){
            int value = Integer.parseInt(octet);
            if (value <0  || value >255){
                System.out.println("Ungültiger Wert in der IPv4!");
                return false;
            }
        }
        return true;
    }

    public void showResult() {
        if (isValidated()) {
            System.out.println("Die IPv4 hat 4 Oktetten");
            System.out.println("Deine IPv4: " + okt1Int + "." + okt2Int + "." + okt3Int + "." + okt4Int);
            System.out.println("Deine IPv4 in Binär umgewandelt: " + binResult1 + "." + binResult2 + "." + binResult3 + "." + binResult4);
        }
    }

}
