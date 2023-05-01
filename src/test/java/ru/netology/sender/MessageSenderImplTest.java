package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {


    @Test
    void send_Russia() {
        //arrange
        LocalizationService localizationService = new LocalizationServiceImpl();
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.anyString()))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("1", "2");
        String expected = "Добро пожаловать";
        //act
        String preferences = messageSender.send(testMap);
        //assert
        Assertions.assertEquals(expected,preferences);
    }

    @Test
    void send_USA() {
        //arrange
        LocalizationService localizationService = new LocalizationServiceImpl();
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.anyString()))
                .thenReturn(new Location("Moscow", Country.USA, null, 0));
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("1", "2");
        String expected = "Welcome";
        //act
        String preferences = messageSender.send(testMap);
        //assert
        Assertions.assertEquals(expected,preferences);
    }
}