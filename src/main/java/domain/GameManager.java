import components.*;
import java.util.Scanner;

public class GameManager {
    final String FOUR_BALL = "포볼(낫싱)";
    final String FORMAT_STRIKE = "%d스트라이크 ";
    final String FORMAT_BALL = "%d볼";
    final String WIN_MESSAGE = "3개의 숫자를 모두 맞혔습니다! 게임 종료";
    final String QUESTION_RESTART = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n";
    final String YES = "1";
    final String NO = "2";
    Scanner scanner;

    public void run(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }

        InputNumberHandler inputNumberHandler = new InputNumberHandler();
        NumberSetCreateHandler numberSetCreateHandler = new NumberSetCreateHandler();

        int[] input = inputNumberHandler.getNumberSet();
        int[] generated = numberSetCreateHandler.getNumberSet();

        if(input[0] == 0){
            run();
            return;
        }

        compareNumbers(input, generated);
    }

    private void compareNumbers(int[] input, int[] generated){
        boolean[] gameResult = new boolean[3];
        for(int i = 0; i < input.length; i++){
            gameResult[i] = input[i] == generated[i];
        }

        printResult(gameResult);
        if(isWin(gameResult)){
            decideToRestart();
            return;            
        }

        run();
    }

    private void printResult(boolean[] result){
        int strikeCount = 0, ballCount = 0;
        for(int i = 0; i < result.length; i++){
            if(result[i]){
                strikeCount++;
            }
            else{
                ballCount++;
            }
        }

        if(strikeCount == 0){
            System.out.print(FOUR_BALL);
            System.out.println();
            return;
        }

        System.out.printf(FORMAT_STRIKE, strikeCount);
        System.out.printf(FORMAT_BALL, ballCount);
        System.out.println();
    }

    private boolean isWin(boolean[] result){
        for(int i = 0; i < result.length; i++){
            if(!result[i]){
                return false;
            }
        }
        System.out.println(WIN_MESSAGE);
        return true;
    } 

    private void decideToRestart(){
        System.out.printf(QUESTION_RESTART, YES, NO);
        String answer = scanner.nextLine();

        if(answer.equals(YES)){
            run();
        }
        else if(answer.equals(NO)){

        }
        else{
            decideToRestart();
        }
    }
}
