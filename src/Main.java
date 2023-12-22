public class Main {

    public static void main(String[] args) {
        //Declaring a continueInput boolean
        boolean continueInput = true;

        //Calling the Ipv4 and the SubnetMask Class
        Ipv4 ipv4 = new Ipv4();
        SubnetMask snm = new SubnetMask();
        //Calling the stringToInt method in the Ipv4 Class
        ipv4.stringToInt();

        //While isValidated in the Ipv4 Class is true and continueInput is true, continue the code to get the
        //SubnetMask Input
        while (ipv4.isValidated() && continueInput) {
            snm.stringToInt();

            //If isValidatedSub in the SubnetMask Class returns true, call the binaries of the Subnetmask and the Ipv4
            if (snm.isValidatedSub()) {

                ipv4.decToBin1();
                ipv4.decToBin2();
                ipv4.decToBin3();
                ipv4.decToBin4();

                snm.decToBin1();
                snm.decToBin2();
                snm.decToBin3();
                snm.decToBin4();

                ipv4.showResult();
                snm.showResultSub();

                //Calculate the NetID
                int netId1 = ipv4.okt1Int & snm.okt1Int;
                int netId2 = ipv4.okt2Int & snm.okt2Int;
                int netId3 = ipv4.okt3Int & snm.okt3Int;
                int netId4 = ipv4.okt4Int & snm.okt4Int;


                //Calculate the Broadcast Address
                int invertedMask1 = ~snm.okt1Int & 0xff;
                int invertedMask2 = ~snm.okt2Int & 0xff;
                int invertedMask3 = ~snm.okt3Int & 0xff;
                int invertedMask4 = ~snm.okt4Int & 0xff;

                int broadcast1 = netId1 | invertedMask1;
                int broadcast2 = netId2 | invertedMask2;
                int broadcast3 = netId3 | invertedMask3;
                int broadcast4 = netId4 | invertedMask4;

                //Print the result on the CLI
                System.out.println("\n========>Net ID<========\n" + netId1 + "." + netId2 + "." + netId3 + "." + netId4);
                System.out.println("\n========>Broadcast<========\n" + broadcast1 + "." + broadcast2 + "." + broadcast3 + "." + broadcast4);

                //printing the Host Range on the CLI (netId + 1 for the first posible IP and broadcast - 1 for the last possible IP)
                System.out.println("\n========>Host Range<========\n" + (netId1 + 1) + "." + (netId2 + 1) + "." + (netId3 + 1) + "." + (netId4 + 1) +
                        "\nto " + (broadcast1 - 1) + "." + (broadcast2 - 1) + "." + (broadcast3 - 1) + "." + (broadcast4 - 1));

                //set the continueInput on false to stop the loop
                continueInput = false;

            }
        }
    }
}