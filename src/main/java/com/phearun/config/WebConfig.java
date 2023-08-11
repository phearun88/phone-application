/**
 * Author : PhearunPhin
 * Date : 8/3/2023
 */

package com.phearun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow CORS for all endpoints
                .allowedOrigins("*")    // Allow requests from any origin (replace with your specific origin if needed)
                .allowedMethods("GET") // Allow specific HTTP methods  //, "POST", "PUT", "DELETE", "OPTIONS"
                .allowedHeaders("*");   // Allow all headers in the request
    }
}
