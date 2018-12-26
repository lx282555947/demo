package com.lixin.google.task;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    private int number;

    public Task(int number) {
        this.number = number;
    }
    @Override
    public String call() throws Exception {
        System.out.println("分支线程" + this.number + "开始");
        Thread.sleep(1000 * 5);
        System.out.println("分支线程" + this.number + "结束");
        throw new RuntimeException("error");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
