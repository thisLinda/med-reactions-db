// localhost:8080/swagger-ui/index.html
package com.forlizzi.medication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MedDb {

    public static void main(String[] args) { SpringApplication.run(MedDb.class, args); }

}