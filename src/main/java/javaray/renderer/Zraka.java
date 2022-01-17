/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.renderer;

import javaray.math.Vektor3;
import javaray.math.Vektor4;

/**
 *
 * @author mraguzin
 */
public class Zraka {
    private final Vektor3 ishodiste;
    private final Vektor3 smjer;
    
    public Zraka(Vektor4 ishodiste, Vektor4 cilj)
    {
        this.ishodiste = ishodiste.perspektivnoDijeljenje();
        smjer = cilj.perspektivnoDijeljenje().minus(this.ishodiste);
    }
    
    public Zraka(Vektor4 ishodiste, Vektor3 smjer)
    {
        this.ishodiste = ishodiste.radijusvektor();
        this.smjer = smjer;
    }
    
    public Zraka(Vektor3 ishodiste, Vektor3 smjer)
    {
        this.ishodiste = ishodiste;
        this.smjer = smjer;
    }
    
    public Vektor3 dajIshodiste()
    {
        return ishodiste;
    }
    
    public Vektor3 dajSmjer()
    {
        return smjer;
    }
}
