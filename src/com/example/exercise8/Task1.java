package com.example.exercise8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Salary{
    double salaryToPay(double hours, double rate);
    default double salaryForOvertime(double overtime, double rate){
        return 5;
    }
    static int bonus(int yearsOfExperience){
        if(yearsOfExperience>3){
            return 90;
        }else{
            return 0;
        }
    }
}

public class Task1 {
    String surnameLusajo56288;
    String nameLusajo56288;
    String streetLusajo56288;
    String zipCodeLusajo56288;
    String cityLusajo56288;

    public void initialize() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Getting Info about the person");
        System.out.println("Enter your surname");
        surnameLusajo56288 = br.readLine();
        System.out.println("Enter your first name");
        nameLusajo56288 = br.readLine();
        System.out.println("Enter street");
        streetLusajo56288 = br.readLine();
        System.out.println("Enter your zip code");
        zipCodeLusajo56288 = br.readLine();
        System.out.println("Enter city");
        cityLusajo56288 = br.readLine();

    }

    public void print() {
        System.out.println("Displaying information");
        System.out.println("       ");
        System.out.println("Surname:" + surnameLusajo56288);
        System.out.println("First name:" + nameLusajo56288);
        System.out.println("Street:" + streetLusajo56288);
        System.out.println("Zip code:" + zipCodeLusajo56288);
        System.out.println("City:" + cityLusajo56288);
    }
}

class Staff extends Task1 implements Salary{
    String educationLusajo56288;
    String positionLusajo56288;

    public void initialize1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initialize();
        System.out.println("Enter your education");
        educationLusajo56288 = br.readLine();
        System.out.println("Enter your position");
        positionLusajo56288 = br.readLine();
    }


    public void print1() {
        print();
        System.out.println("Education:" + educationLusajo56288);
        System.out.println("Position:" + positionLusajo56288);
    }

    @Override
    public double salaryToPay(double hours, double rate) {
        return hours*rate;
    }

    @Override
    public double salaryForOvertime(double overtime, double rate) {
        return overtime * (3 * rate);
    }
}

class Payment{
    public static void main(String[] args) throws IOException{
        Staff worker = new Staff();

        double salary = worker.salaryToPay(150,25);
        System.out.println("Salary received by the worker is: " + salary);
        double overtimeSalary = worker.salaryForOvertime(7,40 );
        System.out.println("Salary for Overtime received by the worker is: " + overtimeSalary);
        int extra = Salary.bonus(4);
        System.out.println("Bonus provided is: " + extra);
    }
}