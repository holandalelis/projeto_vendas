package io.github.holandalelis;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public @interface AnimalConfiguration {

    @Bean(name="cachorro")
    public default Animal cachorro(){
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("Au Au");
            }
        };
    }
    }
    @Bean(name="gato")
    public Animal gato() {
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("MIAU");
            }
        };
    }
}
