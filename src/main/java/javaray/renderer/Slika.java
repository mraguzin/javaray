/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.renderer;

import javaray.math.Vektor3;

/**
 *
 * @author mraguzin
 */
public class Slika {
    private final int sirina;
    private final int visina;
    private RGB fb[]; // konačni framebuffer
    
    public Slika(int sirina, int visina)
    {
        fb = new RGB[sirina * visina];
        this.sirina = sirina;
        this.visina = visina;
    }
    
    public RGB[] uzmiSliku()
    {
        return fb;
    }
    
    public int dajSirinu()
    {
        return sirina;
    }
    
    public int dajVisinu()
    {
        return visina;
    }
    
    public void raytrace(Kamera kamera, Scena scena)
    {
        scena.transformirajObjekte();
        
        for (int i = 0; i < kamera.dajSirinu(); ++i) {
            for (int j = 0; j < kamera.dajVisinu(); ++j) {
                double u = kamera.dajL() + i + 0.5;
                double v = kamera.dajB() + j + 0.5;
                
                Vektor3 smjer, o;
                smjer = o = new Vektor3(0,0,0);
                switch (kamera.dajProjekciju()) {
                    case ORTO:
                        o = kamera.dajPoziciju().radijusvektor().plus(
                                 kamera.dajU().skaliraj(u).plus(kamera.dajV().skaliraj(v)));
                        break;
                        
                    case PERSP:
                        o = kamera.dajPoziciju().radijusvektor();
                        smjer = kamera.dajU().skaliraj(u).plus(kamera.dajV().skaliraj(v))
                                .minus(kamera.dajW().skaliraj(kamera.dajDuljinu()));
                        break;
                }
                
                Zraka zraka = new Zraka(o, smjer);
                double najmanji = Double.POSITIVE_INFINITY;
                Vektor3 potencijalnoSjeciste = new Vektor3(0,0,0), sjeciste;
                int presjecenTrokut = -1;
                Objekt najblizi = null;
                
                double t = Double.POSITIVE_INFINITY;
                for (Objekt objekt : scena.dajObjekte()) {
                    if (!objekt.presijeciZraku(zraka, t, presjecenTrokut, potencijalnoSjeciste))
                        continue;
                    
                    if (t < najmanji && t > 0) {
                        najmanji = t;
                        najblizi = objekt;
                        sjeciste = potencijalnoSjeciste;
                    }
                }
                
                RGB piksel;
                if (najblizi == null) {
                    smjer = smjer.normiraj();
                    Kanal8 tmp0 = new Kanal8((smjer.daj(0)+1)/2. * 0.4);
                    Kanal8 tmp1 = new Kanal8((smjer.daj(1)+1)/2. * 0.5);
                    Kanal8 tmp2 = new Kanal8((smjer.daj(2)+1)/2.);
                    piksel = new RGB(tmp0, tmp1, tmp2);
                } else {
                    piksel = najblizi.sjencaj(scena.dajSvjetla());
                }
                
                fb[i + kamera.dajSirinu() * (kamera.dajVisinu() - 1 - j)] = piksel;
                
            }
                
        }
    }
}
