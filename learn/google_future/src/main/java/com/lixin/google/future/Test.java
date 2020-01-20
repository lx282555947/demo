package com.lixin.google.future;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;
import com.lixin.google.task.Task;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.concurrent.*;

public class Test {
//    private static CountDownLatch countDownLatch = new CountDownLatch(2);
    private static ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
    private static ExecutorService pool2 = Executors.newFixedThreadPool(5);
    private static ListeningScheduledExecutorService executorService = MoreExecutors.listeningDecorator(pool);
    private static ListeningExecutorService executorService2 = MoreExecutors.listeningDecorator(pool2);
    public static void main(String[] args) throws InterruptedException, ExecutionException {
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
//        executorService.schedule(task2, 0, TimeUnit.MILLISECONDS);
        ListenableFuture<String> submit = executorService2.submit(task2);
        Futures.addCallback(submit, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println("回调成功");
//                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("回调异常");
//                countDownLatch.countDown();
            }
        }, executorService);
        List<ListenableFuture<String>> futures = Lists.newArrayList();
        futures.add(schedule1);
        futures.add(submit);
        ListenableFuture<List<String>> listListenableFuture = Futures.successfulAsList(futures);
        listListenableFuture.get();
//        countDownLatch.await();
//        pool2.schedule(futureTask1, 0, TimeUnit.MILLISECONDS);
//        pool2.schedule(futureTask2, 0, TimeUnit.MILLISECONDS);
        System.out.println("主线程结束");
    }

}
