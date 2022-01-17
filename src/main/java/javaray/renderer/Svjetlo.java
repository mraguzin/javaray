/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.renderer;

import javaray.math.Matrica4;
import javaray.math.Vektor3;
import javaray.math.Vektor4;

/**
 *
 * @author mraguzin
 */
public class Svjetlo {
    private Vektor4 pozicija;
    private final RGB boja;
    private final Matrica4 transformacija = Matrica4.jedinicna();
    
    public Svjetlo(Vektor3 pozicija, RGB boja)
    {
        this.pozicija = pozicija.dajTocku();
        this.boja = boja;
    }
    
    public Vektor4 dajPoziciju()
    {
        return pozicija;
    }
    
    public RGB dajBoju()
    {
        return boja;
    }
    
    public void transformiraj()
    {
        pozicija = pozicija.mv(transformacija);
    }
}
