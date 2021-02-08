/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.lambda.lamdas;

/**
 *
 * @author gmestra
 */
public class Lamda {
    
    public static void main(String[] args) {
        
       // clase anonima
        MiNombre mi = new MiNombre() {
            @Override
            public String miNombre() {
                return "tavo";
            }
        };
        System.out.println(mi.miNombre());
        
        MiNombre nom = () -> "Gustavo";
        System.out.println(nom.miNombre());
        
        Sumar suma = (a, b) -> a +b;
        System.out.println(suma.suma(2, 3));
    }
    
}
