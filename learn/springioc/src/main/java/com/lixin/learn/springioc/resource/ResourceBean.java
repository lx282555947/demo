package com.lixin.learn.springioc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceBean {
    @Autowired
    private ResourceLoader resourceLoader;

    public boolean getFile() {
        String errorLog = "C:\\Users\\USER\\Desktop\\日志\\error.log";
        Resource resource = resourceLoader.getResource("file:" + errorLog);
        System.out.println(resource);
        return resource.exists();
    }
}
