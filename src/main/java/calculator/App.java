package calculator;

import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result;
        //추가 삭제에는 Array 보다는 Linked가 더유리하무로 수정
        var arithCal = new ArithmeticCalculator<Double>(new LinkedList<>());
        var circleCal = new CircleCalculator(new LinkedList<>());

        aPoint:
        while (true) {
            System.out.println("원의 넓이 1, 사칙연산 2 입력>");
            String in = sc.nextLine();

            if (in.equals("1")) {
                circleArea(sc, circleCal);
            } else if (in.equals("2")) {
                arithmetic(sc, arithCal);
            }

            bPoint:
            while (true) {
                System.out.println("삭제 (사칙연산 re, 원 cre), 조회 in, 조건 조회 (over, under), 종료 ex, 계속 아무키나 입력");
                String res = sc.nextLine();

                switch (res) {
                    case "re"-> {                        //최근 결과 삭제 & 비였으면 문자 출력
                        if (arithCal.isBasketEmpty()) {
                            System.out.println("Basket is empty");
                        } else {
                            double reNum = arithCal.removeResult();
                            System.out.println(reNum + "삭제되었습니다.");
                        }
                    }
                    case "cre"-> {
                        //최근 결과 삭제 & 비였으면 문자 출력
                        if (circleCal.isBasketEmpty()) {
                            System.out.println("CircleBasketEmpty is empty");
                        } else {
                            double reNum = circleCal.removeResult();
                            System.out.println(reNum + "삭제되었습니다.");
                        }
                    }
                    case "in"-> {//결과 리스트
                        arithCal.inquiryResults();
                        circleCal.inquiryResults();
                    }
                    case "over"-> {
                        System.out.println("얼마 이상 결과값을 찾습니까?");
                        double over = typeCheck(sc);
                        arithCal.overStream(over);
                    }
                    case "under"-> {
                        System.out.println("얼마 이하 결과값을 찾습니까?");
                        double over = typeCheck(sc);
                        arithCal.underStream(over);
                    }
                    case "ex"-> {
                        //종료
                        break aPoint;
                    }
                    default-> {
                        // 아무키나 입력했을 때는 다시 계산
                        break bPoint;
                    }
                }
            }
        }
    }

    private static void arithmetic(Scanner sc, ArithmeticCalculator<Double> arithCal) {
        double result;
        //사칙 연산

        System.out.print("첫 번째 숫자를 입력하세요: ");
        // Scanner 를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        double a = typeCheck(sc);

        System.out.print("두 번째 숫자를 입력하세요: ");
        // Scanner 를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        double b = typeCheck(sc);

        // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operation = operationCheck(sc);

        //계산한 후 내부적으로 저장한 후 결과값만 반환
        result = arithCal.calculate(a, b, operation);

        //operation 같은 값을 찾아서 연산후 result 에 초기화
        System.out.printf("%f %c %f = %f\n", a, operation, b, result);
        //무한정 저장
    }

    private static void circleArea(Scanner sc, CircleCalculator circleCal) {
        //원 넓이
        //반지름을 입력받고
        System.out.print("반지름을 입력하세요: ");
        double radius = typeCheck(sc);

        //넓이를 계산하고 calculator 내부적으로 저장
        double area = circleCal.calculate(radius);
        System.out.println("area = " + area);
    }

    //입력받은 값을 사칙연상중 하나 확인하고 반환
    private static char operationCheck(Scanner sc) {
        boolean isOperation = false;
        char operations;
        do {
            System.out.println("사칙연산 중 하나를 입력해주세요(-, +, *, /, %)");
            operations = sc.nextLine().charAt(0); //sc.next() 인한 스킵현상으로 변경
            boolean isOperationList = operations == '+' || operations == '-' || operations == '*' || operations == '/' || operations == '%';

            if (isOperationList) {
                isOperation = true;
            }
        } while (!isOperation);
        return operations;
    }

    //사용자에게 0이상의 정수를 받는 메서드(음수일때 반복해서 값을 요청)
    // 숫자 타입이 아닌 예외 발생시 다시 요청
    static double typeCheck(Scanner sc) {
        double a = -1;
        do {
            try {
                a = parseDouble(sc.nextLine());//sc,nextInt() 인한 스킵현상으로 변경
            } catch (NumberFormatException e) {
                System.out.println("0을 포함한 양수, 실수를 입력해 주세요");
                continue;
            }
            if (a < 0) {
                System.out.println("0을 포함한 양수, 실수를 입력해 주세요");
            }
        } while (a < 0);
        return a;
    }
}
