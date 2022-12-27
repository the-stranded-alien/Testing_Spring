package org.springframework.samples.petclinic.yannylaurel.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.yannylaurel.HearingInterpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource("classpath:laurel.properties")
@ActiveProfiles("laurel-properties")
@SpringJUnitConfig(classes = PropertiesLaurelTest.TestConfig.class)
public class PropertiesLaurelTest {
    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.yannylaurel")
    static class TestConfig {

    }

    @Autowired
    HearingInterpreter hearingInterpreter;
    @Test
    void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();
        assertEquals("LAUrel", word);
    }
}
