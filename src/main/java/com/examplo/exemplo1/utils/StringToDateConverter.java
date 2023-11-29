package com.examplo.exemplo1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

  private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  public Date convert(String source) {
    try {
      return dateFormat.parse(source);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Invalid date format");
    }
  }
}
