package com.yakdmt.numbers.util;

import com.yakdmt.numbers.converters.EnglishConverter;

import java.util.Locale;

/**
 * Created by yakdmt on 03/10/15.
 */
public class Converter {

    private static class InstanceHolder {
        public static Converter instance = new Converter();
    }

    private Converter() {

    }

    public static Converter getInstance() {
        return InstanceHolder.instance;
    }

    public String convertToText(long number, Locale pLocale) {
        //TODO choose one of the supported languages according to locale
        //
        // use other converters' implementation here

        //return english translation by default
        return EnglishConverter.convert(number);
    }

    public String convertToText(long number) {
        return convertToText(number, Locale.getDefault());
    }


}
