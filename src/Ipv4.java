import java.util.Scanner;

public class Ipv4 extends Calc {

    Scanner ipv4 = new Scanner(System.in);
    int result1;
    int result2;
    int result3;
    int result4;
    int okt1Int;
    int okt2Int;
    int okt3Int;
    int okt4Int;
    int binaryInt;

    public void stringToInt() {
        System.out.println("IPv4 eingeben: ");
        String ip = ipv4.nextLine();
        String[] ipSplit = ip.split("\\.");
        String okt1 = ipSplit[0];
        String okt2 = ipSplit[1];
        String okt3 = ipSplit[2];
        String okt4 = ipSplit[3];
        System.out.println(okt1 + okt2 + okt3 + okt4);
        okt1Int = Integer.parseInt(okt1);
        okt2Int = Integer.parseInt(okt2);
        okt3Int = Integer.parseInt(okt3);
        okt4Int = Integer.parseInt(okt4);
    }

    private int fillTo8Bits(int result) {
        String binaryString = Integer.toBinaryString(result);
        int length =  binaryString.length();

        while (length <8){
            binaryString = "0" + binaryString;
            length++;
        }
        binaryInt = Integer.parseInt(binaryString);

        return binaryInt;
    }

    public void decToBin1() {
        result1 = 0;
        int multiplier = 1;
        do {
            int remainder = okt1Int % 2;
            result1 += remainder * multiplier;
            okt1Int = okt1Int / 2;
            multiplier *= 10;
        } while (okt1Int != 0);
        int binResult1 = fillTo8Bits(result1);
        System.out.println(binResult1);

    }

    public void decToBin2() {
        result2 = 0;
        int multiplier = 1;
        do {
            int remainder = okt2Int % 2;
            result2 += remainder * multiplier;
            okt2Int = okt2Int / 2;
            multiplier *= 10;
        } while (okt2Int != 0);
        int binResult2 = fillTo8Bits(result2);
        System.out.println(binResult2);
    }

    public void decToBin3() {
        result3 = 0;
        int multiplier = 1;
        do {
            int remainder = okt3Int % 2;
            result3 += remainder * multiplier;
            okt3Int = okt3Int / 2;
            multiplier *= 10;
        } while (okt3Int != 0);
        int binResult3 = fillTo8Bits(result3);
        System.out.println(binResult3);
    }

    public void decToBin4() {
        result4 = 0;
        int multiplier = 1;
        do {
            int remainder = okt4Int % 2;
            result4 += remainder * multiplier;
            okt4Int = okt4Int / 2;
            multiplier *= 10;
        } while (okt4Int != 0);
        int binResult4 = fillTo8Bits(result4);
        System.out.println(binResult4);
    }

}
