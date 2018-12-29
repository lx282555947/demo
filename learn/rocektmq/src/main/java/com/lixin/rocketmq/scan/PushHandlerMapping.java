package com.lixin.rocketmq.scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiezhenqiang on 2017/7/11.
 */
@Component
public class PushHandlerMapping implements ApplicationContextAware {

    private ApplicationContext applicationContext;

//    private Set<PushTopicBean> topicBeans = new ConcurrentHashSet<>();
//
//    private Set<MQHandleMappingBean> methodBeans = new ConcurrentHashSet<>();

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }
    @PostConstruct
    public void scanObject(){

//        Map<String, Object> annotationMap = applicationContext.getBeansWithAnnotation(Topic.class);
//        logger.info("annotationMap:{}",annotationMap);
//        Set<Map.Entry<String, Object>> entries = annotationMap.entrySet();

//        for(Map.Entry<String, Object> entry : entries){
//            Object obj = entry.getValue();
//            if(obj instanceof PushHandlerAware){
//                Topic topic = obj.getClass().getAnnotation(Topic.class);
//                PushTopicBean pushTopicBean = new PushTopicBean();
//                pushTopicBean.setTags(topic.tags());
//                String topicName = ConfigProvider.get(topic.topic(), topic.topic());
//                logger.info("获取topicName:{}",topicName);
//                pushTopicBean.setTopicName(topicName);
//                pushTopicBean.setPushHandler((PushHandlerAware) obj);
//                topicBeans.add(pushTopicBean);
//            }
//        }
//
//        Map<String, MessageListenerConcurrently> map = applicationContext.getBeansOfType(MessageListenerConcurrently.class);
//        Set<Map.Entry<String, MessageListenerConcurrently>> entrySet = map.entrySet();
//        for(Map.Entry<String, MessageListenerConcurrently> entry : entrySet){
//            logger.info("监听器名字:{}",entry.getKey());
//            MessageListenerConcurrently value = entry.getValue();
//            if(!"abstractMessageListener".equals(entry.getKey())) {
//                if (value instanceof AbstractMessageListener) {
//                    AbstractMessageListener listener = (AbstractMessageListener) value;
//                    Set<String> listenerTopic = listener.getListenerTopic();
//                    for(String topic : listenerTopic){
//                        PushHandlerAware handler = listener.getHandler(topic);
//                        PushTopicBean pushTopicBean = new PushTopicBean();
//                        pushTopicBean.setPushHandler(handler);
//                        pushTopicBean.setTopicName(topic);
//                        pushTopicBean.setTags("*");
//                        topicBeans.add(pushTopicBean);
//                    }
//                }
//            }
//        }
//
//        Map<String, Object> mqHandleMap = applicationContext.getBeansWithAnnotation(MQService.class);
//        for(Map.Entry<String, Object> entry : mqHandleMap.entrySet()){
//
//            Object value = entry.getValue();
//            Method[] declaredMethods = value.getClass().getDeclaredMethods();
//            for(Method method : declaredMethods){
//                MQHandle mqHandle = method.getAnnotation(MQHandle.class);
//                if (mqHandle == null) continue;
//                MQHandleMappingBean mqHandleMappingBean = new MQHandleMappingBean();
//                mqHandleMappingBean.setMethod(method);
//                mqHandleMappingBean.setObj(value);
//                mqHandleMappingBean.setTopicName(ConfigProvider.get(mqHandle.topic(),mqHandle.topic()));
//                mqHandleMappingBean.setTags(mqHandle.tags());
//                methodBeans.add(mqHandleMappingBean);
//            }
//        }

    }

//    public Set<PushTopicBean> getTopicBeans(){
//        return topicBeans;
//    }
//
//    public Set<MQHandleMappingBean> getMethodBeans() {
//        return methodBeans;
//    }
}
