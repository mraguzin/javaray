/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.renderer;

/**
 *
 * @author mraguzin
 */
public class RGB {
    private Kanal8 rgb[];
    public RGB(Kanal8 r, Kanal8 g, Kanal8 b)
    {
        rgb = new Kanal8[3];
        rgb[0] = r;
        rgb[1] = g;
        rgb[2] = b;
    }
    
    public RGB mult(RGB rgb2)
    {
        return new RGB(rgb2.rgb[0].mix(rgb[0]),
        rgb2.rgb[1].mix(rgb[1]),
        rgb2.rgb[2].mix(rgb[2]));
    }
    
    public int pakirajPiksel() // TODO: provjeri je li ovo ok za korištene
            // formate slika i framebuffera
    {
        return  (rgb[0].uCjelobrojan() << 8) | (rgb[1].uCjelobrojan() << 8)
                | rgb[2].uCjelobrojan();
    }
    
    public Kanal8 dajR()
    {
        return rgb[0];
    }
    
    public Kanal8 dajG()
    {
        return rgb[1];
    }
    
    public Kanal8 dajB()
    {
        return rgb[2];
    }
    
    public void postaviR(Kanal8 r)
    {
        rgb[0] = r;
    }
    
    public void postaviG(Kanal8 g)
    {
        rgb[1] = g;
    }
    
    public void postaviB(Kanal8 b)
    {
        rgb[2] = b;
    }
}
