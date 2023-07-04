package com.xujia.batch;

import com.xujia.entity.Person;
import org.springframework.batch.item.file.LineMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvLineMapper implements LineMapper<Person> {

    private static SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Person mapLine(String line, int lineNumber) throws Exception {
        String[] fields = line.split(",");
        Date dt = sdf.parse(fields[4]);
        return new Person(fields[0], Integer.valueOf(fields[1]), fields[2], fields[3], dt);
    }
}
