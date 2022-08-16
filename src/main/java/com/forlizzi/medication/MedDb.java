// localhost:8080/swagger-ui/index.html
package com.forlizzi.medication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class MedDb {

    public static void main(String[] args) { SpringApplication.run(MedDb.class, args); }

}