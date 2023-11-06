package com.ll;


import java.util.Scanner;

class App {
    void run() {
        while(true) {
            System.out.println("== 명언 앱==");
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();
            int n=0;


            if(cmd.equals("종료")){
                break;
            }
            else if(cmd.equals("등록")){
                System.out.print("명언 : ");
                String content = scanner.nextLine();


                System.out.print("작가 : ");
                String authorName = scanner.nextLine();
                n++;

                System.out.printf("%d번 명언이 등록되었습니다.\n", n);

                //System.out.printf("명언 : %s, 작가 : %s\n", content, authorName);

            }



            //System.out.printf("입력하신 명령 : %s\n", cmd);
        }
    }
}
