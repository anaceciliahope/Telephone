package br.com.telefone.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("br.com.telefone")
public class TelephoneApplicantion {

    public static void main(String[] args) {
        SpringApplication.run(TelephoneApplicantion.class, args);

    }

}
