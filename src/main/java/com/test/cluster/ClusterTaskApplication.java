package com.test.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.test.*"})
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories({"com.test.*"})
@SpringBootApplication
public class ClusterTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClusterTaskApplication.class, args);
  }

}
