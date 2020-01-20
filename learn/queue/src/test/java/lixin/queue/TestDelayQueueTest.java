package lixin.queue;

import lixin.queue.bean.TestBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDelayQueueTest {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);


    @Test
    public void execute() throws InterruptedException {

        TestDelayQueue instance = TestDelayQueue.getInstance();

        Thread thread = new Thread(instance);
        thread.start();
//        Thread.sleep(3000);
        TestDelayQueue.remove(p -> p.getSeq() == 4);
        TestDelayQueue.offerEle(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() - 5000)
                .seq(5)
                .build());
        TestDelayQueue.offerEle(TestBean.builder()
                .executeTimestamp(System.currentTimeMillis() - 13000)
                .seq(6)
                .build());
        while (true) {

        }
    }

    @Test
    public void test() throws InterruptedException {
        TestDelayQueue instance = TestDelayQueue.getInstance();
        instance.execute();
    }
}