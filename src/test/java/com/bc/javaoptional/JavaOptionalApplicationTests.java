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

    @Test
    public void whenOrElseGetWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "Kratos");
        assertEquals("Kratos", name);
    }

    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", defaultText);

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "Text present";

        System.out.println("Using orElseGet:");
        String defaultText
                = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Text present", defaultText);

        System.out.println("Using orElse:");
        //Método orElse é chamado se text for null ou não,
        //logo o método orElseGet é mais otimizado
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Text present", defaultText);
    }

    @Test
    public void whenOrElseThrowWorks_thenCorrect() {
        String nullName = null;
        assertThrows(IllegalArgumentException.class, () -> Optional.ofNullable(nullName).orElseThrow(
                IllegalArgumentException::new));
    }

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }
}
