package com.bookcode.batch;

import com.bookcode.entity.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

public class CsvItemProcessor extends ValidatingItemProcessor<Person> {
    @Override
    public Person process(Person item) throws ValidationException {
        super.process(item);  //

        String address = item.getAddress();
        if("武汉".equals(address)){
            item.setAddress("湖北 武汉");
        }else{
            item.setAddress("非武汉 " + address);
        }
        return item;
    }
}
