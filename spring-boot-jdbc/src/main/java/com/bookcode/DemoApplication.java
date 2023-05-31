package com.bookcode;

import com.bookcode.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        log.info("Create tables....");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, firstName VARCHAR(255), lastName VARCHAR(255))");

        List<Object[]> list = Stream.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        list.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        jdbcTemplate.batchUpdate("INSERT INTO customers(firstName, lastName) values(?, ?)", list);

        log.info("Querying for customer records where firstName='John':");
        jdbcTemplate.query("SELECT id , firstName, lastName from customers WHERE firstName = ?",
                new Object[]{"John"},
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName")))
                .forEach(customer -> log.info(customer.toString()));

    }
}
