package com.myapplication.controller;

public class Operacao {
    public float calcularDelta(float a, float b, float c){
        float delta = (b * b) - (4 * a * c);
        return delta;
    }
    public float calcularRaiz1(float a, float b, float c){
        float delta = (b * b) - (4 * a * c);
        float x1 =(float) (-b + Math.sqrt(delta)) / (2 * a);
        return x1;
    }
    public float calcularRaiz2(float a, float b, float c){
        float delta = (b * b) - (4 * a * c);
        float x2 =(float) (-b - Math.sqrt(delta)) / (2 * a);
        return x2;
    }
}
