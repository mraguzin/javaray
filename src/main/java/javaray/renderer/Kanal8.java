/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.renderer;

/**
 *
 * @author mraguzin
 */
public class Kanal8 {
    private double broj;
    
    public Kanal8(double broj)
    {
        this.broj = broj;
    }
    
    public Kanal8(int broj)
    {
        this.broj = (double) broj / 255;
    }
    
    public Kanal8 mix(Kanal8 kanal)
    {
        double tmp = kanal.broj * broj;
        return new Kanal8(tmp);
    }
    
    public Kanal8 plus(Kanal8 kanal)
    {
        double tmp = kanal.broj + broj;
        return new Kanal8(tmp);
    }
    
    public Kanal8 minus(Kanal8 kanal)
    {
        double tmp = broj - kanal.broj;
        if (tmp < 0)
            return new Kanal8(0);
        
        return new Kanal8(tmp);
    }
    
    public double uRealan()
    {
        if (broj > 1.)
            return 1.;
        
        return broj;
    }
    
    public int uCjelobrojan()
    {
        if (broj > 1.)
            return 255;
        
        return (int)(broj * 255.);
    }
}
