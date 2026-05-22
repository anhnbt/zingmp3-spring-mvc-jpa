package vn.codegym.zingmp3.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // Location (temp dir), maxFileSize, maxRequestSize, fileSizeThreshold
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
                "", 10485760, 10485760, 0); // Example: 10MB per file, 10MB per request
        registration.setMultipartConfig(multipartConfigElement);
    }
}