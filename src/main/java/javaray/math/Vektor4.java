/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.math;

/**
 *
 * @author mraguzin
 */
public class Vektor4 {
    private double x, y, z, w;
    
    public Vektor4()
    {
        
    }
    
    public Vektor4(double x, double y, double z, double w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    public Vektor4 plus(Vektor4 v)
    {
        return new Vektor4(x + v.x, y + v.y, z + v.z, w + v.w);
    }
    
    public Vektor4 minus(Vektor4 v)
    {
        return new Vektor4(x - v.x, y - v.y, z - v.z, w - v.w);
    }
    
    public Vektor4 neg()
    {
        return new Vektor4(-x, -y, -z, -w);
    }
    
    public double dot(Vektor4 v)
    {
        return (x * v.x + y * v.y + z * v.z + w * v.w);
    }
    
    public Vektor4 mv(Matrica4 mat)
    {
        double a = mat.daj(0,0) * x + mat.daj(0,1) * y + mat.daj(0,2) * z + 
                mat.daj(0,3) * w;
        
        double b = mat.daj(1,0) * x + mat.daj(1,1) * y + mat.daj(1,2) * z + 
                mat.daj(1,3) * w;
        
        double c = mat.daj(2,0) * x + mat.daj(2,1) * y + mat.daj(2,2) * z + 
                mat.daj(2,3) * w;
        
        double d = mat.daj(3,0) * x + mat.daj(3,1) * y + mat.daj(3,2) * z + 
                mat.daj(3,3) * w;
        
        return new Vektor4(a, b, c, d);        
    }
    
    public Vektor4 skaliraj(double skalar)
    {
        return new Vektor4(x * skalar, y * skalar, z * skalar, w * skalar);
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
                
            case 3:
                return w;
        }
        
        return x;
    }
    
    public double L2()
    {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }
    
    public Vektor3 radijusvektor()
    {
        return new Vektor3(x, y, z);
    }
    
    public Vektor3 perspektivnoDijeljenje()
    {
        if (w == 1.0)
            return new Vektor3(x, y, z);
        
        return new Vektor3(x / w, y / w, z / w);
    }
}
