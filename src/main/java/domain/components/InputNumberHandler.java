package components;

import java.util.Scanner;

public class InputNumberHandler {
    final int NUMBER_SET_SIZE = 3;
    final String PLEASE_INPUT_MESSAGE = "숫자를 입력해주세요: ";
    final String PLEASE_RE_ENTER = "다시 입력하시기 바랍니다.";
    int[] numberSet = new int[NUMBER_SET_SIZE];
    boolean isValid;
    
    public int[] getNumberSet(){
        isValid = inputNumber();
        return numberSet;
    }

    private boolean inputNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(PLEASE_INPUT_MESSAGE);
        String input = scanner.nextLine();

        if(isValidNumbers(input)){
            saveNumbers(input);
            return true;
        }

        System.out.println(PLEASE_RE_ENTER);
        return false;
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
