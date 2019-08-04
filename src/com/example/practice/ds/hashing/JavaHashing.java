package com.example.practice.ds.hashing;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class JavaHashing {

    public static void main(String[] args){

        testNoHash();
        testWithHash();
        testMutableKeyProblem();
    }

    private static void testWithHash(){
        Set<Teacher> set = new HashSet<>();

        /** Teacher class overrides the hashcode method such that
         *  two equal object has same hash code, which means
         *  following objects have same hash code hence only
         *  one will be inserted in the set
         */
        Teacher s1 = new Teacher(1,"Balraj");
        Teacher s2 = new Teacher(1,"Balraj");

        set.add(s1);
        set.add(s2);
        System.out.println("Size of set is "+set.size());
        System.out.println("Set contents: "+set);
    }


    private static void testNoHash(){
        Set<Student> set = new HashSet<>();

        /** both of these objects are equal, but Student doesn't override
         * the hashcode method, which means every object will get a unique
         * hash code using the default implementation of hashcode method.
         * and because their hash code's are different,
         * they both will be added to the set.
         */
        Student s1 = new Student(1,"Balraj");
        Student s2 = new Student(1,"Balraj");

        set.add(s1);
        set.add(s2);
        System.out.println("Size of set is "+set.size());
        System.out.println("Set contents: "+set);
    }

    private static void testMutableKeyProblem(){

        System.out.println("---------- Testing mutable keys ---------------");
        Set<Teacher> set = new HashSet<>();
        Teacher s1 = new Teacher(1,"Balraj");
        set.add(s1);

        System.out.println("---------- Before modification ---------------");
        System.out.println("\n Set contains object : "+set.contains(s1));


        s1.setId(123);
        System.out.println("---------- After modification ---------------");
        System.out.println("\n Set contains object : "+set.contains(s1));
    }

}


class Student{
    Student(int rollNo, String name){
        this.rollNo = rollNo;
        this.name = name;
    }
    private int rollNo;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo &&
                name.equals(student.name);
    }
}

class Teacher{

    Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                name.equals(teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}