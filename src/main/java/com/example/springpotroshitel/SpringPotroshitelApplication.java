package com.example.springpotroshitel;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.Quoter;

public class SpringPotroshitelApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(Quoter.class).sayQuote();
    }
}
