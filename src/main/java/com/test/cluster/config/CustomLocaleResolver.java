package com.test.cluster.config;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import com.test.cluster.constants.ApplicationConstants;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

  List<Locale> locales = Arrays.asList(new Locale("en"));

  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    String headerLang = request.getHeader(ApplicationConstants.ACCEPT_LANGUAGE);
    return headerLang == null || headerLang.isEmpty() ? Locale.getDefault()
        : Locale.lookup(Locale.LanguageRange.parse(headerLang), locales);
  }

  @Bean
  public ResourceBundleMessageSource messageSource() {
    ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
    rs.setBasename(ApplicationConstants.MESSAGES);
    rs.setDefaultEncoding(ApplicationConstants.UTF_8);
    rs.setUseCodeAsDefaultMessage(true);
    return rs;
  }

}
