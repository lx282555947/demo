package lixin.queue;

import lixin.queue.bean.TestBean;

import java.util.Objects;
import java.util.concurrent.DelayQueue;
import java.util.function.Predicate;

public class TestDelayQueue implements Runnable{

    private static DelayQueue<TestBean> delayQueue;

    private static TestDelayQueue testDelayQueue;

    private boolean run = true;

    public void setRun(boolean run) {
        this.run = run;
    }

    private TestDelayQueue() {
    }

    public static TestDelayQueue getInstance() {
        if (testDelayQueue != null) {
            return testDelayQueue;
        }
        return new TestDelayQueue();
    }

    public static DelayQueue<TestBean> getDelayQueue() {
        if (delayQueue == null) {
            init();
        }
        return delayQueue;
    }

    private static synchronized void init() {
        delayQueue = new DelayQueue<>();
        delayQueue.offer(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() + 5000)
                .seq(1)
                .build());
        delayQueue.offer(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() - 5000)
                .seq(2)
                .build());
        delayQueue.offer(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() + 2000)
                .seq(3)
                .build());
        delayQueue.offer(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() + 4000)
                .seq(4)
                .build());
    }

    public synchronized void reInit() {
        this.run = false;
        delayQueue.clear();
        delayQueue.offer(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() + 1000)
                .seq(5)
                .build());
        delayQueue.offer(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() + 2000)
                .seq(6)
                .build());
        delayQueue.offer(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() + 3000)
                .seq(7)
                .build());
        delayQueue.offer(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() + 4000)
                .seq(8)
                .build());

    }

    public void execute() throws InterruptedException {
        System.out.println("paous");
        int i = 0;
        while (i < 60) {
//            TestBean take = delayQueue.take();
            TestBean take = delayQueue.poll();
            if (Objects.nonNull(take)) {
                System.out.println(take.getSeq());
            }
            System.out.println("hello");
            Thread.sleep(1000);
            i++;
        }
    }


    public static void remove(Predicate<TestBean> predicate) {
        DelayQueue<TestBean> delayQueue = getDelayQueue();
        delayQueue.removeIf(predicate);
    }

    public static void offerEle(TestBean obj) {
        delayQueue.offer(obj);
    }
    @Override
    public void run() {
        init();
        try {
            execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
