package javaHomeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Recipe02 {
    public static <Stirng> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("저장할 자료구조명을 입력합니다. (List / Set / Map)");
        String dataStructure = sc.nextLine();

        switch (dataStructure) {
            case "List" -> {
                ArrayList<String> list = new ArrayList<>();
                System.out.println("제목 입력>");
                list.add("[ ((List)) " + sc.nextLine() + " ]");
                int num = 1;
                String content;
                while (true) {
                    System.out.println("내용 입력 (종료:end) >");
                    content = sc.nextLine();
                    if (content.equals("end")) break;
                    list.add(num++ + ". " + content);
                }
                ;
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            }
            case "Set" -> {
                LinkedHashSet<Stirng> set = new LinkedHashSet<>();
                System.out.println("제목 입력 >");
                set.add((Stirng) ("[ ((Set)) " + sc.nextLine() + " ]"));
                String content;
                int num = 1;
                while (true) {
                    System.out.println("내용 입력 (종료:end) >");
                    content = sc.nextLine();
                    if (content.equals("end")) break;
                    set.add((Stirng) (num++ + ". " + content));
                }
                for (Stirng s : set) {
                    System.out.println(s);
                }
            }
            case "Map" -> {
                HashMap<Integer, String> map = new HashMap<>();
                System.out.println("제목 입력 > ");
                int num = 1;

                map.put(num++, sc.nextLine());
                String content;
                while (true) {
                    System.out.println("내용 입력 (종료:end) >");
                    content = sc.nextLine();
                    if (content.equals("end")) break;
                    map.put(num++, content);
                }
                for (Integer key : map.keySet()) {
                    System.out.println(key + ". " + map.get(key));
                }
            }
            default -> System.out.println("잘못된 입력!!!!!!!!");
        }
    }
}

