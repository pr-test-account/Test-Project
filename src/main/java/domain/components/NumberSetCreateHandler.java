package components;

import java.util.Random;

public class NumberSetCreateHandler  {
    Random random;
    final int RANDOM_MIN = 1;
    final int RANDOM_MAX = 2;
    final int NUMBER_SET_SIZE = 3;
    int[] numberSet;

    public int[] getNumberSet(){
        generateNumberSet();
        return numberSet;
    }

    private void generateNumberSet(){
        random = new Random();
        numberSet = new int[NUMBER_SET_SIZE];
        for(int i = 0; i < numberSet.length; i++){
            numberSet[i] = createRandomNumber();
        }
    }

    private int createRandomNumber(){
        return random.nextInt(RANDOM_MAX) + RANDOM_MIN;
    }
}