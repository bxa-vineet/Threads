package org;
public class Animal implements Notification {

    public void smsNotification() {
        System.out.println("Implementing smsNotification here");
    }
    
    void ageAndColor() {
        System.out.println("This is animal age and color ");
        
    }

    public static void main(String[] args) {

        System.out.println("Animal class main method");

        Animal a = new Animal();
        a.smsNotification();
        a.count();               // default method
        Notification.config();  // static method
        a.main();

        Cat c = new Cat(2, "Brown");
        c.ageAndColor();
        c.count();
        Animal c1 = new Cat();
        
    }

    private void main() {
        System.out.println("inside second main method");
    }
}

// ------------------ Cat Class ------------------

class Cat extends Animal{

    int age;
    String color;

    public Cat() {
        System.out.println("Inside No Args Constructor Of Cat");
    }

    public Cat(int age, String color) {
        this();   // must be first
        this.age = age;
        this.color = color;
        System.out.println("Inside 2 args constructor Of Cat");
    }

    void ageAndColor() {
        System.out.println("cat age " + age);
        System.out.println("cat color " + color);
    }
}

