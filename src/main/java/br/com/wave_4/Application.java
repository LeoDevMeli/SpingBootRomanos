package br.com.wave_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@SpringBootApplication
@RestController
class Convert_Romano {

    public static void main(String[] args) {
        SpringApplication.run(Convert_Romano.class, args);
    }

    @GetMapping("/convertRomano")
    public String converteRomano(@RequestParam(value = "algarismo", defaultValue = "Hello!") int convert) {
        return String.format("O número digitado convertido para romano é: %s",toRoman(convert));
    }

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();


    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String toRoman(int numberRoman) {
        int number =  map.floorKey(numberRoman);
        if ( number == numberRoman ) {
            return map.get(number);
        }
        return map.get(number) + toRoman(numberRoman-number);
    }
}
