package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result;

        System.out.print("첫 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int a = typeCheck(sc);

        System.out.print("두 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int b = typeCheck(sc);

        // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operation = operationCheck(sc);

        //사용자에게 입력받은 값을 출력
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("operation = " + operation);

        //operation 같은 값을 찾아서 연산후 result에 초기화
        result = calculate(operation, a, b);
        System.out.println("result = " + result);

    }

    private static int calculate(char operation, int a, int b) {
        int result;
        result = switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
        return result;
    }

    private static char operationCheck(Scanner sc) {
        boolean isOperation = false;
        char operations;
        do {
            System.out.println("사칙연산 중 하나를 입력해주세요(-, +, *, /");
            operations = sc.next().charAt(0);
            if(operations == '+' || operations == '-' || operations == '*' || operations == '/') {
                isOperation = true;
            }
        } while (!isOperation);
        return operations;
    }

    //사용자에게 0이상의 정수를 받는 메서드(음수일때 반복해서 값을 요청)
    static int typeCheck(Scanner sc) {
        int a;
        do {
            a = sc.nextInt();
            if (a < 0) {
                System.out.println("0을 포함한 양수를 입력해 주세요");
            }
        } while (a < 0);
        return a;
    }
}