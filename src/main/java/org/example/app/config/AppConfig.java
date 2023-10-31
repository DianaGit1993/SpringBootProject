package org.example.app.config;

import org.example.app.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig implements WebMvcConfigurer {

    // == Bean methods ==

    // Decides which locale should be used
    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    // == Public methods ==
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Adds a view controller, no controller needed to be declared for HOME view
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // Registers the LocaleChangeInterceptor (for automatic localising)
        registry.addInterceptor(new LocaleChangeInterceptor());
    }

}
