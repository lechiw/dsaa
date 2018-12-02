package com.liw.common.swagger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * @Description: (用一句话描述该文件做什么)
 * @author: zhuchunlan
 * @date: 2018/3/15 13:49
 * <p>
 * Copyright 2010-2018 TimaNetworks Inc. All rights reserved.
 */
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig {

    private String title = "";

    private String description = "";

    private String basePackage = "com.liw";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
