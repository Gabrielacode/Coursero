package com.garbi.coursero.utils;

import com.garbi.coursero.entity.Course;
import org.springframework.data.domain.Sort;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class SortConverter implements Formatter<Sort> {
    //We will create our custom formartter for our sort object to be passed in the request param
    //The standard syntax of the sort will be
    // property:direction for example name:asc
    @Override
    public Sort parse(String text, Locale locale) throws ParseException {
        //Here we want to parse form the sort exception
        //We will substring from the the last index
        var lastIndexOfColumn = text.lastIndexOf(':');
        if(lastIndexOfColumn == -1){
            //If there is no string we will  throw an exception
            throw new ParseException("No : found in string  for sort parameter",0);
        }
        //Then we will get the property name
        var propertyName = text.substring(0,lastIndexOfColumn);
        var propertyValue = text.substring(lastIndexOfColumn+1);
        //Lets the gets the direction
        Sort.Direction direction = switch (propertyValue.toLowerCase(locale)) {
            case "asc" -> Sort.Direction.ASC;
            case "desc" -> Sort.Direction.DESC;
            default -> Sort.Direction.ASC;
        };
        //We will now convert it to a Sort Object

        Sort sort = Sort.by(direction,propertyName);
        return sort;

    }

    @Override
    public String print(Sort object, Locale locale) {
        //For this we will just do the reverse and then we will convert the property name
        //The sortObject when printed will have a format =courseName: ASC
        //We will need to trim the text asfter and convert it to lowercase
        var sortString = object.toString();
        var indexOfColumn =sortString.lastIndexOf(':');
        if(indexOfColumn == -1){
            return "";
        }
        var directionSection = sortString.substring(indexOfColumn+1).trim().toLowerCase(locale);
        //Then we will replace the part
        String result  = sortString.substring(0, indexOfColumn).trim() + directionSection;
        return result;
    }
}
