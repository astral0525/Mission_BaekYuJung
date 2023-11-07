package com.ll;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {


    void run() {
        int lastId = 0;
        List<Quotation> quotations = new ArrayList<>();
        System.out.println("== 명언 앱==");

        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();


            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String authorName = scanner.nextLine();
                lastId++;

                Quotation quotation = new Quotation(lastId, content,authorName);
                quotations.add(quotation);


                System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);

            } else if (cmd.equals("목록")) {
                System.out.printf("번호 / 작가 / 명언\n");
                System.out.printf("---------\n");
                for(int i= quotations.size()-1; i>=0; i--){
                    System.out.printf("%d / %s / %s \n", quotations.get(i).id, quotations.get(i).authorName, quotations.get(i).content);
                }
                
            }


            //System.out.printf("입력하신 명령 : %s\n", cmd);
        }
    }
}

