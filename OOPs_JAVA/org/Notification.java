package org;
interface Notification {

    void smsNotification();

    default void count() {
        System.out.println("Inside default method count()");
    }

    static void config() {
        System.out.println("Inside static method config()");
    }
}