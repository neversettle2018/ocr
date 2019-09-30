package com.example.ocr.test;

import java.util.ArrayList;
import java.util.List;

public class HelloWorldAnonymousClasses {

    interface HelloWorld {
        List<String> greet( List<String> list);
    }

    interface Hello {
        String  greet( String a);
    }

    public static void main(String[] args) {



        HelloWorld helloWorld = (list) -> {
            list.add("list1");
            return list;
        };
        List<String> list= new ArrayList<>();
        List<String> greet = helloWorld.greet(list);
//        greet.forEach(System.out::println);
        greet.forEach(a -> System.out.println(a));

//        Hello hello = (a)->{
//            return a;
//        };
//
//
//        String a="a";
//        System.out.println(hello.greet(a));

    }

}
