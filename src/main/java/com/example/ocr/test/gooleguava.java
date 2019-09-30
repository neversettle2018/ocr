package com.example.ocr.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.List;

public class gooleguava {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = Lists.newArrayList(30, 20, 60, 80, 10);
        System.out.println( Ordering.natural().sortedCopy(numbers)); //10,20,30,60,80
        Ordering.natural().reverse().sortedCopy(numbers); //80,60,30,20,10
        Ordering.natural().min(numbers); //10
        Ordering.natural().max(numbers); //80
        ArrayList<Integer> integers = Lists.newArrayList(30, null, 20, 60, 80, null, 10);
        System.out.println(Ordering.natural().nullsLast().sortedCopy(integers)); //10, 20,30,60,80,null
        Ordering.natural().nullsFirst().sortedCopy(integers); //null,10,20,30,60,80


    }

}
