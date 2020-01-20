package com.lixin.rocketmq2.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
//        String topicName = null;
//        for (int i = 0; i < 100; i++) {
            //Create a message instance, specifying topic, tag and message body.
//            if (i % 2 == 0) {
//                topicName = "ZHANGSAN";
//            }else {
//                topicName = "topictest";
//            }
//            Message msg = new Message(topicName /* Topic */,
//                    "TagA" /* Tag */,
//                    ("Hello RocketMQ " +
//                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
//            );
//            //Call send message to deliver message to one of brokers.
//            SendResult sendResult = producer.send(msg);
//            System.out.printf("%s%n", sendResult);
//        }
        int count = 1;
        String topicName = null;
        while (true) {
            Thread.sleep(1000);
            if (count % 2 == 0) {
                topicName = "lixin";
            }else {
                topicName = "topictest";
            }
            Message msg = new Message(topicName /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            count).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
            count++;
        }
        //Shut down once the producer instance is not longer in use.
//        producer.shutdown();
    }
}
