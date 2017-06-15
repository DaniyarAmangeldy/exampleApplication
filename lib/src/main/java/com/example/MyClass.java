package com.example;

public class MyClass {

    public static void main(String [] args){
        int a = 10;
        char b = 'a';
        String slovo = "hello";
        float f = (float) 1.2;
        double d;
        long l;
        boolean bool = false;
// asd

        /**
         *  Коммент пишеться сюда :)
         */
        if(bool){

        }else{

        }

        if(true)
            a = 15;


        System.out.print(a==10 ? "10" : "не 10");

        for(int i = 0;i<10;i++){
            System.out.println("Hello");
        }

        while(a>0){
            System.out.println("Hello");
            a--;
        }

        switch(a){
            case 0: {
                // TODO: Chto to ...
            }
                break;
            case 15:
                // TODO: Chto to ... na 15
                break;
            default:
                // TODO: Default chto to

        }

        firstFunction("hello");

        Person person = new Person(123,"name","lastName",17);
        person.setName("Name");
        Person.func();

        if(person.getAge()<18){
            System.out.print("<18");
        }

    }

    public static void firstFunction(String n){
        System.out.print(n);
    }

}
