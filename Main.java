import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {
    public static Entity[] generateRandomInput(long seed, int size){
        Random generatorKey = new Random(seed);
        Random generatorValue = new Random(seed);
        Entity[] randomInput = new Entity[size];
        
        for (int i = 0; i < size; i++) {
            randomInput[i] = new Entity( generatorKey.nextInt(999999999), generatorKey.nextInt(100));
        }

        return randomInput;
    }


    public static void main(String [] args) throws Exception{ 
        int[] sizesToTest = {10,100,1000,10000,100000};
        int[] setsToTest = {20000, 100000, 500000, 1000000, 5000000};
        int sizeInput = 21;

        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    
            for(int j = 0; j < 5; j++)
            {
                bufferedWriter.write("\nDIVISION: TESTING STARTING WITH "+sizesToTest[j] + " BUCKETS");
                for(int z = 0; z < 5; z++) {
                    bufferedWriter.write("\nTESTING STARTING WITH "+setsToTest[z] + " ENTITIES");
                    Entity[] randomInput = generateRandomInput(123, setsToTest[z]);
    
                    HashTableDivision hashTable = new HashTableDivision(sizesToTest[j]);
                    
                    long startTime = System.currentTimeMillis();
    
                    for (int i = 0; i < setsToTest[z]; i++) {
                        hashTable.insert(randomInput[i].key, randomInput[i].data);
                    }
                    long endTime = System.currentTimeMillis();
    
                    long elapsedTime = endTime - startTime;
                    bufferedWriter.write("\nInsert time passed: " + elapsedTime + " milliseconds");
                    
                    startTime = System.currentTimeMillis();
    
                    bufferedWriter.write("\ncolisions: " + hashTable.colisions);
                    bufferedWriter.write("\nget: "+ hashTable.get(336528454));
                    bufferedWriter.write("\nget: "+ hashTable.get(464181750));
                    bufferedWriter.write("\nget: "+ hashTable.get(647624789));
                    bufferedWriter.write("\nget: "+ hashTable.get(232933658));
                    bufferedWriter.write("\nget: "+ hashTable.get(553004783));
                    endTime = System.currentTimeMillis();
    
                    elapsedTime = endTime - startTime;
                    bufferedWriter.write("\nSearch time passed: " + elapsedTime + " milliseconds");
                }
                
            }
    
            for(int j = 0; j < 5; j++)
            {
                bufferedWriter.write("\nFOLDING: TESTING STARTING WITH "+sizesToTest[j] + " BUCKETS");
                for(int z = 0; z < 5; z++) {
                    bufferedWriter.write("\nTESTING STARTING WITH "+setsToTest[z] + " ENTITIES");
                    Entity[] randomInput = generateRandomInput(123, setsToTest[z]);
    
                    HashTableFolding hashTable = new HashTableFolding(sizesToTest[j]);
                    
                    long startTime = System.currentTimeMillis();
    
                    for (int i = 0; i < setsToTest[z]; i++) {
                        hashTable.insert(randomInput[i].key, randomInput[i].data);
                    }
                    long endTime = System.currentTimeMillis();
    
                    long elapsedTime = endTime - startTime;
                    bufferedWriter.write("\nInsert time passed: " + elapsedTime + " milliseconds");
                    
                    startTime = System.currentTimeMillis();
    
                    bufferedWriter.write("\ncolisions: " + hashTable.colisions);
                    bufferedWriter.write("\nget: "+ hashTable.get(336528454));
                    bufferedWriter.write("\nget: "+ hashTable.get(464181750));
                    bufferedWriter.write("\nget: "+ hashTable.get(647624789));
                    bufferedWriter.write("\nget: "+ hashTable.get(232933658));
                    bufferedWriter.write("\nget: "+ hashTable.get(553004783));
                    endTime = System.currentTimeMillis();
    
                    elapsedTime = endTime - startTime;
                    bufferedWriter.write("\nSearch time passed: " + elapsedTime + " milliseconds");
                }
                
            }
    
            for(int j = 0; j < 5; j++)
            {
                bufferedWriter.write("\nMULTIPLICATION: TESTING STARTING WITH "+sizesToTest[j] + " BUCKETS");
                for(int z = 0; z < 5; z++) {
                    bufferedWriter.write("\nTESTING STARTING WITH "+setsToTest[z] + " ENTITIES");
                    Entity[] randomInput = generateRandomInput(123, setsToTest[z]);
    
                    HashTableMultiplication hashTable = new HashTableMultiplication(sizesToTest[j]);
                    
                    long startTime = System.currentTimeMillis();
    
                    for (int i = 0; i < setsToTest[z]; i++) {
                        hashTable.insert(randomInput[i].key, randomInput[i].data);
                    }
                    long endTime = System.currentTimeMillis();
    
                    long elapsedTime = endTime - startTime;
                    bufferedWriter.write("\nInsert time passed: " + elapsedTime + " milliseconds");
                    
                    startTime = System.currentTimeMillis();
    
                    bufferedWriter.write("\ncolisions: " + hashTable.colisions);
                    bufferedWriter.write("\nget: "+ hashTable.get(336528454));
                    bufferedWriter.write("\nget: "+ hashTable.get(464181750));
                    bufferedWriter.write("\nget: "+ hashTable.get(647624789));
                    bufferedWriter.write("\nget: "+ hashTable.get(232933658));
                    bufferedWriter.write("\nget: "+ hashTable.get(553004783));
                    endTime = System.currentTimeMillis();
    
                    elapsedTime = endTime - startTime;
                    bufferedWriter.write("\nSearch time passed: " + elapsedTime + " milliseconds");
                }
                
            }
            bufferedWriter.close();
        } catch (Error e){
            e.printStackTrace();
        }
        

        

    }
}
