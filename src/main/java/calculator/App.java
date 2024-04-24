package calculator;

import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result;
        Calculator calculator = new Calculator(new ArrayDeque<>());

        aPoint:
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner 를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int a = typeCheck(sc);

            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner 를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int b = typeCheck(sc);

            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operation = operationCheck(sc);

            //계산한 후 내부적으로 저장한 후 결과값만 반환
            result = calculator.calculate(a, b, operation);

            //operation 같은 값을 찾아서 연산후 result 에 초기화
            System.out.printf("%d %c %d = %f\n", a, operation, b, result);
            //무한정 저장

            bPoint:
            while (true) {
                System.out.println("최근 연산 결과 삭제 re, 연산결과 조회 in, 종료 ex, 계속 아무키나 입력");
                String res = sc.nextLine();

                switch (res) {
                    case "re":
                        //최근 결과 삭제 & 비였으면 문자 출력
                        if (calculator.isBasketEmpty()) {
                            System.out.println("Basket is empty");
                        } else {
                            double reNum = calculator.removeResult();
                            System.out.println(reNum + "삭제되었습니다.");
                        }
                        break;
                    case "in": //결과 리스트
                        calculator.inquiryResults();
                        break;
                    case "ex": //종료
                        break aPoint;
                    default:// 아무키나 입력했을 때는 다시 계산
                        break bPoint;
                }
            }
        }
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
