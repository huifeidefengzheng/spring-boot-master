package com.dexing.od;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

class Student{
    private int id;
    private int higt;
    private int weight;

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHigt() {
        return higt;
    }

    public void setHigt(int higt) {
        this.higt = higt;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}