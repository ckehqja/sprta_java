package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int a = typeCheck();
            System.out.print("두 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int b = typeCheck();

        //사용자에게 입력받은 값을 출력
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

    //사용자에게 0이상의 정수를 받는 메서드(음수일때 반복해서 값을 요청)
    static int typeCheck() {
        Scanner sc = new Scanner(System.in);
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