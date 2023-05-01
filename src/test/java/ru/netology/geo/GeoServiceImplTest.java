package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;



class GeoServiceImplTest {
    GeoService sut = new GeoServiceImpl();

    public static Stream<Arguments> metodSource() {
        return Stream.of(
                Arguments.of("127.0.0.1", new Location(null, null, null, 0).toString()),
                Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15).toString()),
                Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32).toString()),
                Arguments.of("172.0.0.0", new Location("Moscow", Country.RUSSIA, null, 0).toString())
        );
    }

    @ParameterizedTest
    @MethodSource ("metodSource")
    void byIpTest (String argument, String expected) {
        //act
        String result = sut.byIp(argument).toString();
        //Assert
        Assertions.assertEquals(expected,result);
    }
}