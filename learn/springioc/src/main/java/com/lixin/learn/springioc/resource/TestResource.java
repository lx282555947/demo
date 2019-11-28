package com.lixin.learn.springioc.resource;

import com.alibaba.fastjson.JSON;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

public class TestResource {
    public static void main(String[] args) throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        String errorLog = "C:\\Users\\USER\\Desktop\\日志\\error.log";
        Resource resource = resourceLoader.getResource(errorLog);
        System.out.println(resource instanceof ClassPathResource);
        System.out.println(resource.exists());

        Resource file = resourceLoader.getResource("file:" + errorLog);
        System.out.println("==================");
        System.out.println(file instanceof UrlResource);
        System.out.println(file.exists());

        Resource httpResource = resourceLoader.getResource("http://www.baidu.com");
        System.out.println("==================");
        System.out.println(httpResource instanceof UrlResource);
        System.out.println(httpResource.exists());

        Resource application = resourceLoader.getResource(ResourceUtils.CLASSPATH_URL_PREFIX + "application.properties");
        System.out.println("==================");
        System.out.println(application instanceof ClassPathResource);
        System.out.println(application.exists());

        Resource xiegang = resourceLoader.getResource("/");
        System.out.println(xiegang.getURI().getPath());

        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        Resource error = fileSystemResourceLoader.getResource(errorLog);
        System.out.println(error.exists());

        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = pathMatchingResourcePatternResolver.getResources("classpath*:application.properties");
        System.out.println(JSON.toJSONString(resources));

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        Resource resource1 = applicationContext.getResource("file:" + errorLog);
        System.out.println(resource1.exists());


    }

}
