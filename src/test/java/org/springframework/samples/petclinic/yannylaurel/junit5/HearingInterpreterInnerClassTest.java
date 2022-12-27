package org.springframework.samples.petclinic.yannylaurel.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.yannylaurel.BaseConfig;
import org.springframework.samples.petclinic.yannylaurel.HearingInterpreter;
import org.springframework.samples.petclinic.yannylaurel.HearingInterpreterTest;
import org.springframework.samples.petclinic.yannylaurel.LaurelWordProducer;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = HearingInterpreterInnerClassTest.TestConfig.class)
class HearingInterpreterInnerClassTest {

    @Configuration
    static class TestConfig {
        @Bean
        HearingInterpreter hearingInterpreter() {
            return new HearingInterpreter(new LaurelWordProducer());
        }
    }
    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();
        assertEquals("Laurel", word);
    }
}