package com.planify.config;  // Make sure the package matches your project structure
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // This annotation marks this class as a source of bean definitions
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for /api/** endpoint from React running on port 3000
        registry.addMapping("/**")  // Change to match your API path
                .allowedOrigins("http://localhost:3000")  // React app's dev server URL
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
