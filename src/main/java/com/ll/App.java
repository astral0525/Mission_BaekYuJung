package com.ll;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    int lastId = 0;
    List<Quotation> quotations = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void run() {

        System.out.println("== 명언 앱==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                actionWrite();

            } else if (cmd.equals("목록")) {
                actionList();

            }else if(cmd.equals("삭제")){

           }


        }
    }

    void actionWrite(){
        //명언, 작가 입력
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String authorName = scanner.nextLine();
        lastId++;

        //명언객체 생성 및 list추가
        Quotation quotation = new Quotation(lastId, content,authorName);
        quotations.add(quotation);
        System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);

    }

    void actionList(){

        System.out.printf("번호 / 작가 / 명언\n");
        System.out.printf("---------\n");

        if(quotations.isEmpty())
            System.out.println("등록된 명언이 없습니다.");

        for(int i= quotations.size()-1; i>=0; i--){
            System.out.printf("%d / %s / %s \n", quotations.get(i).id, quotations.get(i).authorName, quotations.get(i).content);
        }
    }


}

