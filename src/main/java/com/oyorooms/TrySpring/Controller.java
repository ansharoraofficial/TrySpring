package com.oyorooms.TrySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

@RestController
public class Controller {

    @Autowired
    RestApiManager restApiManager;

    @GetMapping("add_two")
    @Cacheable(value = "add_two", unless = "#result == null")
    public Integer addTwo(@RequestParam Integer x) {
        if (x == 5) return null;
        return x + 2;
    }

    @PostMapping("/generateBills")
    public void generateBills() {
        String url = "http://www.gnr8tr.online/fuel_receipt2";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        LocalDate localDate = LocalDate.of(2020, 1, 1);
        Integer i = 0;
        while (i < 5) {
            Random random = new Random();
            Double fuelPrice = 65 + (68 - 65) * random.nextDouble();
            String fuelRate = String.format("%.2f", fuelPrice);
            String date = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            map.put("vehicle_number", Arrays.asList("4717"));
            map.put("datepicker1", Arrays.asList(date));
            map.put("fuel_rate", Arrays.asList(fuelRate));
            map.put("citownvill", Arrays.asList("Gurgaon"));
            map.put("cities", Arrays.asList("1+SGM"));
            map.put("pay_mode", Arrays.asList("CASH"));
            map.put("amt_paid", Arrays.asList("2000"));
            map.put("fuel_type", Arrays.asList("DIESEL"));
//            map.put("fuel_type", Arrays.asList("PETROL"));
            map.put("email_id", Arrays.asList("iprabhjodh@gmail.com"));
            restApiManager.postWithForm(url, map, httpHeaders, String.class);
            localDate = localDate.plusDays(5);
            i++;
        }

    }

}