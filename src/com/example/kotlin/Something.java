package com.example.kotlin;

import java.util.Enumeration;

public class Something {
    public static void main(String[] args){
        /* Accessing companion object vs object of kotlin class */
        // Companion
        Temp.Companion.foo();

        // Object
        Temp.Holder.INSTANCE.foo();
    }
}
