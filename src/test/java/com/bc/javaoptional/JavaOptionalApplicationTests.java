package com.bc.javaoptional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

//  Quando se espera valores nulos pode-se usar o Nullable em vez de of
    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "Test";
        Optional<String> opt = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
    }

    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }

    @Test
    public void givenOptional_whenIsPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("Test");
        assertTrue(opt.isPresent());

        opt = Optional.ofNullable(null);
        assertFalse(opt.isPresent());
    }

    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
//        Sem optional
//        String name = "Test";
//
//        if (name != null){
//            System.out.println(name.length());
//        }

//      Com optional
        Optional<String> opt = Optional.ofNullable("Test");
        opt.ifPresent(s -> System.out.println(s.length()));
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("Kratos");
        assertEquals("Kratos", name);
    }
}
