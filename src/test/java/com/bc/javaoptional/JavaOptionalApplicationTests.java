package com.bc.javaoptional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JavaOptionalApplicationTests {

    @Test
    public void whenCreatesEmptyOption_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "Test";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }
}
