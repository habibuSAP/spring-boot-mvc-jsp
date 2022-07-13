package com.demo.hplus.converters;

import com.demo.hplus.models.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String genderOption) {
        if(genderOption.equals("Male")){
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }
}
