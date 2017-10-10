package com.dms.controller;

public class ErrCode {
  int code;
  String msg;
  String rightAnswer;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getRightAnswer() {
    // System.out.println("用到了get方法");
    return rightAnswer;
  }

  public void setRightAnswer(String rightAnswer) {
    this.rightAnswer = rightAnswer;
  }
}
