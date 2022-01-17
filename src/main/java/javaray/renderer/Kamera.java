/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.renderer;

import javaray.math.Matrica3;
import javaray.math.Matrica4;
import javaray.math.Vektor3;
import javaray.math.Vektor4;

/**
 *
 * @author mraguzin
 */
public class Kamera {
    enum TipProjekcije
    {
        PERSP,
        ORTO
    }
    
    private Kamera.TipProjekcije projekcija;
    private Vektor3 x, y, z;
    private Vektor3 u, v, w;
    private Vektor4 pozicija0; // trenutna pozicija kamere
    private Vektor4 pozicija;
    private double hfov;
    private double d; // žarišna duljina kamere
    private double l, r, b, t;
    
    private int sirina, visina;
    
    public Kamera(Kamera.TipProjekcije projekcija,
            Vektor4 pozicija,
            Vektor3 desno,
            Vektor3 gore,
            Vektor3 iza,
            double hfov,
            int sirina,
            int visina)
    {
        this.projekcija = projekcija;
        this.pozicija = pozicija;
        this.x = desno;
        this.y = gore;
        this.z = iza;
        this.u = desno;
        this.v = gore;
        this.w = iza;
        this.sirina = sirina;
        this.visina = visina;
        postaviFOV(hfov);
        postaviGranice();
    }
    
    public void postaviGranice()
    {
        r = sirina / 2.0;
        l = -r;
        t = visina / 2.0;
        b = -t;
    }
    
    public void postaviFOV(double hfov)
    {
        this.hfov = hfov;
        
        d = (sirina / 2.0) / Math.tan(hfov / 2.0);
    }
    
    private void postaviDimenzije(int sirina, int visina)
    {
        this.sirina = sirina;
        this.visina = visina;
    }
    
    public void postaviDuljinu(double d)
    {
        this.d = d;
        
        hfov = Math.atan((sirina / 2.0) / d) * 2;
    }
    
    public void komponirajTransformaciju(Matrica4 matrica)
    {
        Matrica3 linearna = matrica.linearna();
        u = (linearna.mv(u)).normiraj();
        v = (linearna.mv(v)).normiraj();
        w = (linearna.mv(w)).normiraj();
        
        pozicija = pozicija.mv(matrica);
    }
    
    public void postaviTransformaciju(Matrica4 matrica)
    {
        Matrica3 linearna = matrica.linearna();
        u = (linearna.mv(x)).normiraj();
        v = (linearna.mv(y)).normiraj();
        w = (linearna.mv(z)).normiraj();
        
        pozicija = pozicija0.mv(matrica);
    }
    
    public void gledajU(Vektor4 cilj, Vektor3 gore)
    {
        w = cilj.minus(pozicija).radijusvektor();
        w.neg().normiraj();
        u = gore.vp(w).normiraj();
        v = w.vp(u).normiraj();
    }
    
    public Vektor4 dajPoziciju()
    {
        return pozicija;
    }
    
    public double dajDuljinu()
    {
        return d;
    }
    
    public int dajSirinu()
    {
        return sirina;
    }
    
    public int dajVisinu()
    {
        return visina;
    }
    
    public Vektor3 dajU()
    {
        return u;
    }
    
    public Vektor3 dajV()
    {
        return v;
    }
    
    public Vektor3 dajW()
    {
        return w;
    }
    
    public double dajL()
    {
        return l;
    }
    
    public double dajR()
    {
        return r;
    }
    
    public double dajB()
    {
        return b;
    }
    
    public double dajT()
    {
        return t;
    }
    
    public Kamera.TipProjekcije dajProjekciju()
    {
        return projekcija;
    }
    
}
