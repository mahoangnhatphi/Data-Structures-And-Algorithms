/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import util.Util;

/**
 *
 * @author Phi
 */
public class Student {
    private String code;
    private String name;
    private int age;
    private double score;

    public Student(String code, String name, int age, double score) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-25s|%-5d|%-6.2f|", code, name, age, score);
    }
    
    public static Student inputStudent() {
        String code = Util.getString("Input student code: ");
        String name = Util.getString("Input student name: ");
        int age = Util.getInt("Input student age: ", "Please input age is an integer");
        double score = Util.getDouble("Input student score: ", "Please input score is an real number");
        return new Student(code, name, age, score);
    }
}
