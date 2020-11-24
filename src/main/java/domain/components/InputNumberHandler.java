package components;

import java.util.Scanner;

public class InputNumberHandler {
    final int NUMBER_SET_SIZE = 3;
    int[] numberSet = new int[NUMBER_SET_SIZE];
    
    public int[] getNumberSet(){
        return numberSet;
    }

    public void inputNumber(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        if(isValidNumbers(input)){
            saveNumbers(input);
        }
    }

    private boolean isValidNumbers(String input){
        return isNotNull(input) && isFitLength(input) && isTrueNumbers(input);
    }

    private boolean isNotNull(String input){
        return !input.isEmpty();
    }

    private boolean isFitLength(String input){
        return input.length() == NUMBER_SET_SIZE;
    }

    private boolean isTrueNumbers(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    private void saveNumbers(String input){
        for(int i = 0; i < input.length(); i++){
            numberSet[i] = Character.getNumericValue(input.charAt(i));
        }
    }
}
