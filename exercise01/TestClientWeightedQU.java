public class TestClientWeightedQU {
    public static void main(String[] args) {
        //Initialisation of data structure
        int N = 10000;
        WeightedQU weightedQU = new WeightedQU(N);

        //N * 2 randomly generated numbers from 0 to N-1 for p[] and q[] each with N elements written to a txt-file
        int numberOfIntegersToGenerate = N * 2;
        int maximumValue = N - 1;
        String file = "integers.txt";
        IntegerFileGenerator intFile = new IntegerFileGenerator(numberOfIntegersToGenerate, maximumValue, file);
        intFile.generateFile();

        //reading in the file with integers into an array
        int[] integersFromFile = new int[numberOfIntegersToGenerate];
        In in = new In(file);
        for (int i = 0; i < numberOfIntegersToGenerate; i++) {
            integersFromFile[i] = in.readInt();
        }

        //Initialisation of p[] and q[] and filling them with read in integers from array
        int[] p = new int[N];
        int[] q = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = integersFromFile[i];
            q[i] = integersFromFile[(integersFromFile.length - 1) - i];
        }

        //Using the Weighted Quick Union
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
