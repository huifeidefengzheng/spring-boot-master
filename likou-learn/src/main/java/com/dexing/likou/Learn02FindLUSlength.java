package com.dexing.likou;

public class Learn02FindLUSlength {
    public static void main(String[] args) {

    }

    int res = 0;

    public int findLUSlength(String a, String b) {
        return a.equals(b)?Math.max(a.length(),b.length()):-1;
    }
}
