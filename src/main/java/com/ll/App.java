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
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제?")) {
                actionRemove(cmd);
            } else if (cmd.startsWith("수정?")) {
                actionModify(cmd);
            } else {
                System.out.println("등록되지 않은 명령입니다. 다시 입력해주십시오");
            }


        }
    }

    void actionWrite() {
        //명언, 작가 입력
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String authorName = scanner.nextLine();
        lastId++;

        //명언객체 생성 및 list추가
        Quotation quotation = new Quotation(lastId, content, authorName);
        quotations.add(quotation);
        System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);

    }

    void actionList() {

        System.out.printf("번호 / 작가 / 명언\n");
        System.out.printf("---------\n");

        if (quotations.isEmpty())
            System.out.println("등록된 명언이 없습니다.");

        for (int i = quotations.size() - 1; i >= 0; i--) {
            System.out.printf("%d / %s / %s \n", quotations.get(i).id, quotations.get(i).authorName, quotations.get(i).content);
        }
    }

    void actionRemove(String cmd) {
        int id = getParamAsInt(cmd, "id", 0);

        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        } else if ((id <= lastId)&&(id>0)) {
            System.out.printf("%d번 명언을 삭제합니다.\n", id);
        } else {
            System.out.printf("id가 없습니다.\n");
        }

    }

    void actionModify(String cmd) {
        int id = getParamAsInt(cmd, "id", 0);

        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        } else if ((id <= lastId)&&(id>0)) {
            System.out.printf("%d번 명언을 수정합니다.\n", id);
        } else {
            System.out.printf("id가 없습니다.\n");
        }

    }

    int getParamAsInt(String cmd, String paramName, int defaultValue) {
        String[] cmdBits = cmd.split("\\?", 2); //'?'기준으로 2번만 분할
        String queryString = cmdBits[1]; //"?d이후내용"

        String[] queryStringBits = queryString.split("&");
        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];
            String[] queryParamStrBits = queryParamStr.split("=", 2);

            try {
                String _paramName = queryParamStrBits[0];
                String paramValue = queryParamStrBits[1];
                if (_paramName.equals(paramName)) {
                    return Integer.parseInt(paramValue);
                }
            } catch (Exception e) {
                return defaultValue;
            }
        }

        return defaultValue;
    }


}

