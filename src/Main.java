import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ipv4 ipv4 = new Ipv4();
        SubnetMask snm = new SubnetMask();
        ipv4.stringToInt();
        snm.stringToInt();
        ipv4.decToBin1();
        ipv4.decToBin2();
        ipv4.decToBin3();
        ipv4.decToBin4();
        snm.decToBin1();
        snm.decToBin2();
        snm.decToBin3();
        snm.decToBin4();
        ipv4.isValidated();
        ipv4.showResult();
        snm.showResultSub();

    }
}