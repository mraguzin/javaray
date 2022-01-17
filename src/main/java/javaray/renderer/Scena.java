/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.renderer;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author mraguzin
 */
public class Scena {
    private int brojSvjetala;
    private int brojSfera;
    private int brojModela;
    
    // generički kontejner objekata na sceni za renderirati
    private Collection<Objekt> objekti;
    private List<Svjetlo> svjetla;
    
    public void dodaj(Objekt obj)
    {
        objekti.add(obj);
    }
    
    public void dodajSvjetlo(Svjetlo svjetlo)
    {
        svjetla.add(svjetlo);
    }
    
    public List<Svjetlo> dajSvjetla()
    {
        return svjetla;
    }
    
    public Collection<Objekt> dajObjekte()
    {
        return objekti;
    }
    
    public void transformirajObjekte()
    {
        objekti.forEach(obj -> {
            obj.transformiraj();
        });
    }
}
