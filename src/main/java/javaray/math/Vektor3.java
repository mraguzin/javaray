/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.math;

/**
 *
 * @author mraguzin
 */
//TODO: unit testovi za sve math komponente!
public class Vektor3 {
    private double x, y, z;
    
    public Vektor3()
    {
        
    }
    
    public Vektor3(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // TODO: poveži native C++ kod za sve ispod!
    public Vektor3 plus(Vektor3 v)
    {
        double a = x + v.x;
        double b = y + v.y;
        double c = z + v.z;
        
        return new Vektor3(a, b, c);
    }
    
    public Vektor3 minus(Vektor3 v)
    {
        double a = x - v.x;
        double b = y - v.y;
        double c = z - v.z;
        
        return new Vektor3(a, b, c);
    }
    
    public Vektor3 neg()
    {
        x = -x;
        y = -y;
        z = -z;
        
        return this;
    }
    
    public Vektor3 vp(Vektor3 drugi) // vektorski produkt
    {
        double a = y * drugi.z - z * drugi.y;
        double b = z * drugi.x - x * drugi.z;
        double c = x * drugi.y - y * drugi.x;
        
        return new Vektor3(a, b, c);
    }
    
    public double dot(Vektor3 drugi) // skalarni produkt
    {
        return (x * drugi.x + y * drugi.y + z * drugi.z);
    }
    
    public Vektor3 skaliraj(double skalar)
    {
        return new Vektor3(x * skalar, y * skalar, z * skalar);
    }
    
    public double L2()
    {
        return Math.sqrt(x * x + y * y + z * z);
    }
    
    public Vektor3 normiraj()
    {
        return skaliraj(1. / L2());
    }
    
    public double max()
    {
        return Math.max(Math.abs(x), Math.max(Math.abs(y), Math.abs(z)));
    }
    
    public double daj(int idx)
    {
        switch(idx) {
            case 0:
                return x;
                
            case 1:
                return y;
                
            case 2:
                return z;
        }
        
        return x;
    }
    
    
    public Vektor4 dajTocku()
    {
        return new Vektor4(x, y, z, 1);
    }
    
}
