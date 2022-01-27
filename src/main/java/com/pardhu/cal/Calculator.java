package com.pardhu.cal;

public class Calculator {

  private static Calculator obj;

  public static Calculator getInstance() {
    if(obj==null){
      obj = new Calculator();
    }
    return obj;
  }

  public int add(String strNum) throws Exception {
    if(strNum.length()==0){
      return 0;
    }
    if(strNum.endsWith(",\n")){
      throw new Exception("Ending with new line");
    }
    String deli = ",";
    if(strNum.startsWith("//")) {
      if(strNum.contains("[")&&strNum.contains("]")) {
        while(strNum.contains("[")&&strNum.contains("]")){
          int startIndex = strNum.indexOf("[");
          int endIndex = strNum.indexOf("]");
          String temp = strNum.substring(0,startIndex);
          deli = strNum.substring(startIndex+1, endIndex);
          strNum = strNum.substring(endIndex+1).replaceAll("["+deli+"+]", ";");
          int startIndex1 = strNum.indexOf("[");
          int endIndex1 = strNum.lastIndexOf("]");
          strNum = temp + strNum.substring(startIndex1+1,endIndex1);
          deli = ";";
        }
      } else {
        deli = ""+strNum.charAt(2);
        strNum = strNum.substring(3);
      }
      strNum = strNum.substring(2);
    }
    strNum = strNum.replace("\n", deli);
    String[] numbersArray = strNum.split(deli);
    String negatives = "";
    int res = 0;
    for(String num: numbersArray){
      num = num.trim();
      if(num.length()>0){
        int x = Integer.parseInt(num);
        if(x<0){
          negatives += ", "+num;
        }
        res += x;
      }
    }
    if(negatives.length()>0) {
      throw new Exception("Negatives not allowed : "+negatives.substring(2));
    }
    return res;
  }
}
