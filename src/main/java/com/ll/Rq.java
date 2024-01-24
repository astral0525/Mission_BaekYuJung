package com.ll;

import java.util.ArrayList;
import java.util.List;

public class Rq {
    String cmd;
    String action;
    String queryString;
    List<String> paramNames = new ArrayList<>();
    List<String> paramValues = new ArrayList<>();


    Rq(String cmd){ //생성자
        this.cmd = cmd;

        String[] cmdBits = cmd.split("\\?", 2);
        action = cmdBits[0].trim();
        queryString = cmdBits[1].trim();

        String[] queryStringBits = queryString.split("&");

        for(int i=0; i<queryStringBits.length; i++){
            String queryParamStr = queryStringBits[i];
            String[] queryParamStrBits = queryParamStr.split("=");

            try {
                String paramName = queryParamStrBits[0];
                String paramValue = queryParamStrBits[1];
                paramNames.add(paramName);
                paramValues.add(paramValue);
            }catch(Exception e){
            }
        }
    }

    String getAction(){
        return action;
    }

    public int getParamAsInt(String paramName, int defaultValue){
        int index = paramNames.indexOf(paramName);

        if(index == -1 ) return defaultValue;
        String paramValue = paramValues.get(index);

        try{
            return Integer.parseInt(paramValue);
        }catch(Exception e){
            return defaultValue;
        }

    }

}
