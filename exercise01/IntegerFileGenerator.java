public class IntegerFileGenerator {
    private int evenNumberOfIntegersWrittenToFile;
    private int maximumInt;
    private String filePath;

    public IntegerFileGenerator(int evenNumberOfIntegersWrittenToFile, int maximumInt, String filePath){
        if(evenNumberOfIntegersWrittenToFile % 2 != 0){
            throw new IllegalArgumentException("Number of Integers has to even");
        }
        this.evenNumberOfIntegersWrittenToFile = evenNumberOfIntegersWrittenToFile;
        this.maximumInt = maximumInt;
        this.filePath = filePath;

    }

    public void generateFile(){
        Out out = new Out(this.filePath);
        for (int i = 0; i < this.evenNumberOfIntegersWrittenToFile; i++) {
            int randomInt = (int) (Math.random() * (this.maximumInt + 1));
            out.println(randomInt);
        }
    }



}
