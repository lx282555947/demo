package com.lixin.rocketmq.scan;

import com.lixin.rocketmq.annotation.MQListener;
import com.lixin.rocketmq.annotation.MQService;
import com.lixin.rocketmq.bean.RocketMqBean;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class AnotationScan implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private static Map<String, RocketMqBean> rocketMqBeanMap = new HashMap<>();
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    private void init() {
        //获取所有添加了MQService注解的类
        Map<String, Object> beansWithMQService = applicationContext.getBeansWithAnnotation(MQService.class);
        Set<Map.Entry<String, Object>> entries = beansWithMQService.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            Object classObejct = entry.getValue();
            Method[] declaredMethods = classObejct.getClass().getDeclaredMethods();
            for (Method method : declaredMethods) {
                MQListener annotation = method.getAnnotation(MQListener.class);
                if (annotation == null) continue;
                RocketMqBean bean = RocketMqBean.builder()
                        .topic(annotation.topic())
                        .tag(annotation.tag())
                        .target(classObejct)
                        .method(method)
                        .build();
                rocketMqBeanMap.put(annotation.topic().name(), bean);

            }
        }
    }

    public Map<String,RocketMqBean> getRocketMqBeanMap() {
        return rocketMqBeanMap;
    }
}
