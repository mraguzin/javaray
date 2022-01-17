/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.renderer;

import java.util.List;
import javaray.math.Matrica4;
import javaray.math.Vektor3;

/**
 *
 * @author mraguzin
 */
public abstract class Objekt {
    protected Vektor3 sjeciste;
    
    public Matrica4 transformacija = Matrica4.jedinicna();
    
    public abstract void transformiraj();
    public abstract RGB sjencaj(List<Svjetlo> svjetla);
    public abstract boolean presijeciZraku(Zraka zraka, Double t,
            int presjecenTrokut, Vektor3 potencijalnoSjeciste);
    
    
}
