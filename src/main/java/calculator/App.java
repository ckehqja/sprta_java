package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result;
        Deque<Integer> basket = new ArrayDeque<>();

        try {
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

                System.out.println("최근 연산 결과 삭제 re, 연산결과 조회 in, 종료 ex, 계속 아무키나 입력");
                String res = sc.nextLine();

                switch (res) {
                    case "re" -> {
                        Integer reNum = basket.pop();
                        System.out.println(reNum + "삭제되었습니다.");
                    }
                    case "in" -> {
                        System.out.print("basket = [ ");
                        for (Integer i : basket) {
                            System.out.print(i + ", ");
                            System.out.println(" ] ");
                        }
                    }
                    case "ex" -> {
                        throw new Exception("exit");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("종료합니다.");
        }

//            //최근 결과 삭제
//            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
//            removeBasket(sc, basket);
//
//            //컬렉션 출력
//            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
//            inquiryPrint(sc, basket);
//
//
//            //exit 입력 시 반복문 중단
//            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
//            if (exitMethod(sc)) break;

    }

    //컬렉션 출력
    private static void inquiryPrint(Scanner sc, Deque<Integer> basket) {
        String inquiry = sc.nextLine();
        if (inquiry.equals("inquiry")) printBasket(basket);
    }

    //컬렉션 출력
    private static void printBasket(Deque<Integer> basket) {
        System.out.print("basket = ");
        for (Object o : basket) System.out.print(o + ", ");
        System.out.println();
    }

    //삭제 여부
    private static void removeBasket(Scanner sc, Deque<Integer> basket) {
        String remove = sc.nextLine();
        if (remove.equals("remove")) {
            int removeNum = basket.pop();
            System.out.println(removeNum + " 삭제되었습니다.");
        } else System.out.println("삭제되지 않았습니다.");
    }

    //exit 입력 시 반복문 중단
    private static boolean exitMethod(Scanner sc) {
        String exit;
        exit = sc.nextLine();
        return exit.equals("exit");
    }

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
            if (operations == '+' || operations == '-' || operations == '*' || operations == '/') {
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