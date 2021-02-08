/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.lambda.lamdas;

/**
 *
 * @author Gustavo Mestra Garay <gmestra@asesoftware.com>
 */
public interface ByDefault {
    
    void mostrarNombre(String nombre);
    
    default String nameByDefault(String nombre){
        return nombre + " default";
    }
    
}
