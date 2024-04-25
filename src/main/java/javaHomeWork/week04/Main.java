package javaHomeWork.week04;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean calculateEnded = false;
        // 구현 2.
        while(!calculateEnded){
            try {
                calculateEnded = CalculatorApp.start();
            } catch (BadInputException e) {
                e.getMessage();
            }
        }
    }
}