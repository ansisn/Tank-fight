package com.hspjy.Thread;

public class cpuNums {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cupNum  = runtime.availableProcessors();
        System.out.println(cupNum);
    }
}
