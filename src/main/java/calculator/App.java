package calculator;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class App {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result;
        Stack basket = new Stack<Integer>();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int a = typeCheck(sc);

            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int b = typeCheck(sc);

            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operation = operationCheck(sc);

            //operation 같은 값을 찾아서 연산후 result에 초기화
            result = calculate(operation, a, b);
            System.out.printf("%d %c %d = %d\n", a, operation, b, result);
            //무한정 저장
            basket.push(result);

            //컬렉션 출력
            printBasket(basket);

            //최근 결과 삭제
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            removeBasket(sc, basket);

            //exit 입력 시 반복문 중단
            if (extracted(sc)) break;
        }

    }

    //컬렉션 출력
    private static void printBasket(Stack basket) {
        System.out.print("basket = ");
        for (Object o : basket) System.out.print(o + ", ");
        System.out.println();
    }

    //삭제 여부
    private static void removeBasket(Scanner sc, Stack basket) {
        String remove = sc.nextLine();
        if (remove.equals("remove")) {
            int removeNum = (int)basket.pop();
            System.out.println(removeNum + " 삭제되었습니다.");
        } else System.out.println("삭제되지 않았습니다.");
    }

    //exit 입력 시 반복문 중단
    private static boolean extracted(Scanner sc) {
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        String exit;
        exit = sc.nextLine();
        return exit.equals("exit");
    }

    //결과를 배열에 저장 & 10개 이상 시 오래된 결과를 지우고 새로운 결과를 끝으로
//    private static void getCount(int[] intArr , int result) {
//        if (count >= 10) {
//            for (int i = 0; i < 9; i++) {
//                intArr[i] = intArr[i+1];
//            }
//            intArr[9] = result;
//            count++;
//        } else {
//            intArr[count++] = result;
//        }
//    }

    //switch문을 사용해서 사칙연산중 하나를 골라 연산
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

    //입력받은 값을 사칙연상중 하나 확인하고 반환
    private static char operationCheck(Scanner sc) {
        boolean isOperation = false;
        char operations;
        do {
            System.out.println("사칙연산 중 하나를 입력해주세요(-, +, *, /");
            operations = sc.nextLine().charAt(0); //sc.next() 인한 스킵현상으로 변경
            if(operations == '+' || operations == '-' || operations == '*' || operations == '/') {
                isOperation = true;
            }
        } while (!isOperation);
        return operations;
    }

    //사용자에게 0이상의 정수를 받는 메서드(음수일때 반복해서 값을 요청)
    // 숫자 타입이 아닌 예외 발생시 다시 요청
    static int typeCheck(Scanner sc) {
        int a = -1;
        do {
            try {
                a = parseInt(sc.nextLine());//sc,nextInt() 인한 스킵현상으로 변경
            } catch (NumberFormatException e) {
                System.out.println("0을 포함한 양수를 입력해 주세요");
                continue;
            }
            if (a < 0) {
                System.out.println("0을 포함한 양수를 입력해 주세요");
            }
        } while (a < 0);
        return a;
    }
}