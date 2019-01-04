package com.lixin.config;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * 配置websocket连接基础路径
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*")
        //sockjs 可兼容所有的浏览器，若浏览器版本不支持websocket，则sockjs会做降级处理，变为轮训调用服务端的接口
//        .withSockJS()
        ;
    }

    /**
     * 拦截客户端发送给服务端的消息，并进行业务上的处理，客户端在连接、订阅、取消订阅、断开连接的时候会给服务端发送一条消息，因此可在用户建立连接，释放连接、订阅以及取消订阅的时候操作
     * accessor可以保存用户的信息，并向连接池进行注册，当服务端主动推送消息给服务端的时候，能够根据用户的key获取该连接的会话id，从而实现点对点的发送
     * 若不想在accessor中保存用户唯一表示码，则需要在订阅路径中加入表示用户的唯一标识码  例如/user/{customerId}/queue/..
     * @param registration
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(new ChannelInterceptorAdapter(){
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                System.out.println(JSON.toJSONString(accessor));
                String customerId = accessor.getFirstNativeHeader("customerId");
                //获取订阅路径
                String destination = accessor.getDestination();
                switch (accessor.getCommand()) {
                    case CONNECT:

                        break;
                    case DISCONNECT:

                        break;
                    case SUBSCRIBE:

                        break;
                }
                return message;
            }
        });
    }

    /**
     * 若在access中保存用户唯一标识码，则客户端订阅路径为：/user/queue/..
     * @param registry
     */
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.setInterceptors(new ChannelInterceptorAdapter(){
//            @Override
//            public Message<?> preSend(Message<?> message, MessageChannel channel) {
//                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
//                System.out.println("accessor:" + JSON.toJSONString(accessor));
//                System.out.println("message" + JSON.toJSONString(message));
//                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
//                    String token = accessor.getFirstNativeHeader("name");
//                    try {
////                        tokenValidate(token);
//                        if (token != null) {
//                            Principal principal = new PrincipalImpl(token);
//                            accessor.setUser(principal);
//                        }
//
//                    } catch (Exception e) {
////                        log.error(e.toString());
//                        return null;
//                    }
//                }
//                return message;
//            }
//        });
//    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //群发推送前缀为/test   点对点推送后缀为/queue
        registry.enableSimpleBroker("/test", "/queue"); // 推送消息前缀
        //点对点推送前缀为/user
        registry.setUserDestinationPrefix("/user");
        //客户端请求服务端的前缀为/app
        registry.setApplicationDestinationPrefixes("/app"); // 应用请求前缀
     }
}
