package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();

        City city = new City("Victoria", "British Columbia");
        cityList.add(city);

        assertEquals(2, cityList.countCities());

        cityList.delete(mockCity());

        assertEquals(1, cityList.countCities());
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
    }
}
