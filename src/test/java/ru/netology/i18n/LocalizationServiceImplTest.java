package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    LocalizationService sut = new LocalizationServiceImpl();
    public static Stream<Arguments> metodSource() {
        return Stream.of(
                Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome")
        );
    }

    @ParameterizedTest
    @MethodSource("metodSource")
    void localeTest (Country arguments, String expected) {
        //act
        String result = sut.locale(arguments);
        //Assert
        Assertions.assertEquals(expected,result);

    }

}