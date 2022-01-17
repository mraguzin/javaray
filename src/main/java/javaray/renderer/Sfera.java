/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.renderer;

import java.util.List;
import javaray.math.Vektor3;

/**
 *
 * @author mraguzin
 */
public class Sfera extends Objekt {
    private final double R; // radijus
    private final double reciprocR;
    private final Vektor3 kd = new Vektor3(1, 0, 0);
    
    public Sfera(double radijus)
    {
        R = radijus;
        reciprocR = 1. / R;
    }

    @Override
    public void transformiraj() {
        // nema posla za sferu
    }

    @Override
    public RGB sjencaj(List<Svjetlo> svjetla) {
        Vektor3 c = new Vektor3(transformacija.daj(0, 3), 
        transformacija.daj(1, 3), transformacija.daj(2, 3));
        Vektor3 normala = sjeciste.minus(c).skaliraj(reciprocR);
        Kanal8 r = new Kanal8(0);
        Kanal8 g = new Kanal8(0);
        Kanal8 b = new Kanal8(0);
        
        for (var svjetlo : svjetla) {
            Vektor3 l = svjetlo.dajPoziciju().radijusvektor().minus(sjeciste).normiraj();
            double m = Math.max(0, normala.dot(l));
            r = r.plus(new Kanal8(kd.daj(0) * svjetlo.dajBoju().dajR().uRealan() * m));
            g = g.plus(new Kanal8(kd.daj(1) * svjetlo.dajBoju().dajG().uRealan() * m));
            b = b.plus(new Kanal8(kd.daj(2) * svjetlo.dajBoju().dajB().uRealan() * m));
        }
        
        return new RGB(r, g, b);
    }

    @Override
    public boolean presijeciZraku(Zraka zraka, Double t, int presjecenTrokut, Vektor3 potencijalnoSjeciste) {
        Vektor3 c = new Vektor3(transformacija.daj(0, 3),
        transformacija.daj(1, 3), transformacija.daj(2, 3));
        Vektor3 e = zraka.dajIshodiste();
        Vektor3 d = zraka.dajSmjer();
        Vektor3 u = e.minus(c);
        double D = Math.pow(d.dot(u), 2.0) - d.dot(d) * (u.dot(u) - R * R);
        
        if (D < 0)
            return false;
        
        double t1 = -(d.dot(u) - Math.signum(d.dot(u)) * Math.sqrt(D)) / d.dot(d);
        sjeciste = e.plus(d.skaliraj(t1));
        t = t1;
        
        return true;
    }
    
}
