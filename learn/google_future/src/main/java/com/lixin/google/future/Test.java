package com.lixin.google.future;

import com.google.common.util.concurrent.*;
import com.lixin.google.task.Task;
import org.springframework.lang.Nullable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    private static ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(5);
    private static ListeningScheduledExecutorService executorService = MoreExecutors.listeningDecorator(pool2);
    public static void main(String[] args){
        System.out.println("主线程开始");
        Task task1 = new Task(1);
        Task task2 = new Task(2);
        ListenableScheduledFuture<String> schedule1 = executorService.schedule(task1, 0, TimeUnit.MILLISECONDS);
//        ListenableScheduledFuture<String> schedule2 = executorService.schedule(task2, 0, TimeUnit.MILLISECONDS);
        Futures.addCallback(schedule1, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println("回调成功");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("回调异常");
            }
        }, executorService);
//        pool2.schedule(futureTask1, 0, TimeUnit.MILLISECONDS);
//        pool2.schedule(futureTask2, 0, TimeUnit.MILLISECONDS);
        System.out.println("主线程结束");
    }

}
