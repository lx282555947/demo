package com.lixin.rocketmq.bean;

import com.lixin.rocketmq.enums.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.rocketmq.common.message.MessageExt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RocketMqBean {
    private Topic topic;
    private String tag;
    private Object target;
    private Method method;

    public boolean invoke(MessageExt messageExt) {
        //huoqu canshu
        Parameter[] parameters = this.method.getParameters();
        try {
            Boolean invoke = (Boolean) method.invoke(this.target, messageExt);
            return invoke;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }

}
