package com.lixin.config;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @Description: 导入apollo配置
 */
@Component
public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
//    @EventListener
//    public void event(ApplicationEnvironmentPreparedEvent event) {
//        ConfigurableEnvironment environment = event.getEnvironment();
//        Assert.isInstanceOf(ConfigurableEnvironment.class, environment);
//        MutablePropertySources sources = environment.getPropertySources();
//        System.out.println(sources);
////        PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("apollo-config", ConfigProvider.getProp());
////        sources.addFirst(propertiesPropertySource);
//    }

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        Assert.isInstanceOf(ConfigurableEnvironment.class, environment);
        MutablePropertySources sources = environment.getPropertySources();
        System.out.println(sources);
    }
}
