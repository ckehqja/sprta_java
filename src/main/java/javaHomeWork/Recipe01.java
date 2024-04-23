package javaHomeWork;

import java.util.Scanner;

public class Recipe01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder recipe = new StringBuilder(1000);

        //StringBuilder에 제목을 먼저 받아서 입력을 한다
        System.out.println("요리 제목 >");
        recipe.append("[ ").append(sc.nextLine()).append(" ]\n");

        //별점을 입력 받기
        System.out.println("별점을 입력(5점 만점)>");
        //sc.nextFloat() 다음 nextLine에 생략되는 문제가 있어서 nextLine()으로 받아서 형변환 실행
        float star = Float.parseFloat(sc.nextLine());

        //퍼센트로 표현
        String starPercentage = String.format("%1.1f", star / 5 * 100);
        recipe.append("별점 : ").append(star).append(" (").append(starPercentage).append("%)").append("\n");

        String content;

        //요리 순서 매김
        int num = 1;
        //end가 입력될때까지 반복
        while (true) {
            System.out.print("요리 방법(end = 종료)>");
            content = sc.nextLine();
            //end를 입력받으면 종료
            if(content.equals("end")) break;
            recipe.append(num++).append(". ").append(content).append("\n");
        }
        System.out.println(recipe);
    }
}
