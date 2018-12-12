package com.lixin.config;//package com.example.websocket.hello;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionConnectedEvent;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//import org.springframework.web.socket.messaging.SessionSubscribeEvent;
//import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;
//
//@Component
//public class WebsocketEventListener {
//
//    private static final Logger log = LoggerFactory.getLogger(WebsocketEventListener.class);
//
//    @EventListener
//    public void handleConnectListener(SessionConnectedEvent event) {
//        log.info("[ws-connected] socket connect: {}", event.getMessage());
//        // do someting ...
//    }
//
//    @EventListener
//    public void handleDisconnectListener(SessionDisconnectEvent event) {
//        log.info("[ws-disconnect] socket disconnect: {}", event.getMessage());
//        // do someting ...
//    }
//
//    @EventListener
//    public void handleSubscribeListener(SessionSubscribeEvent event) {
//        log.info("[ws-disconnect] socket subscribe: {}", event.getMessage());
//        // do someting ...
//    }
//    @EventListener
//    public void handleUnSubscribeListener(SessionUnsubscribeEvent event) {
//        log.info("[ws-disconnect] socket unsubscribe: {}", event.getMessage());
//        // do someting ...
//    }
//}
