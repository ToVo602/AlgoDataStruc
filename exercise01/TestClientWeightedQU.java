public class TestClientWeightedQU {
    public static void main(String[] args) {
        int N = 10000;
        WeightedQU weightedQU = new WeightedQU(N);

        int evenNumberOfIntegersToGenerate = N; //this number has to be even or an IllegalArgumentException will be thrown
        int maximumValue = N - 1;
        String file = "integers.txt";

        IntegerFileGenerator intFile = new IntegerFileGenerator(evenNumberOfIntegersToGenerate, maximumValue, file);
        intFile.generateFile();

        int[] integersFromFile = new int[evenNumberOfIntegersToGenerate];
        In in = new In(file);

        for (int i = 0; i < evenNumberOfIntegersToGenerate; i++) {
            integersFromFile[i] = in.readInt();
        }

        int[] p = new int[evenNumberOfIntegersToGenerate / 2];
        int[] q = new int[evenNumberOfIntegersToGenerate / 2];

        for (int i = 0; i < evenNumberOfIntegersToGenerate / 2; i++) {
            p[i] = integersFromFile[1];
            q[i] = integersFromFile[(integersFromFile.length - 1) - i];
        }

        for (int i = 0; i < p.length; i++) {
            if(weightedQU.connected(p[i], q[i])){
                StdOut.println("Already connected: " + p[i] + " and " + q[i]);
            } else{
                weightedQU.union(p[i], q[i]);
                StdOut.println("Now " + p[i] + " and " + q[i] + " are connected.");
            }
        }





    }
}
