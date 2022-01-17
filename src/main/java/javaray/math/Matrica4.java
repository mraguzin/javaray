/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.math;

/**
 *
 * @author mraguzin
 */
public class Matrica4 {
    private double m[][];
    
    public Matrica4()
    {
        m = new double[4][4];
    }
    
    public Matrica4(double m11, double m12, double m13, double m14,
            double m21, double m22, double m23, double m24,
            double m31, double m32, double m33, double m34,
            double m41, double m42, double m43, double m44)
    {
        m = new double[3][3];
        
        m[0][0] = m11;
        m[0][1] = m12;
        m[0][2] = m13;
        m[0][3] = m14;
        m[1][0] = m21;
        m[1][1] = m22;
        m[1][2] = m23;
        m[1][3] = m24;
        m[2][0] = m31;
        m[2][1] = m32;
        m[2][2] = m33;
        m[2][3] = m34;
        m[3][0] = m41;
        m[3][1] = m42;
        m[3][2] = m43;
        m[3][3] = m44;
    }
    
    public Matrica4(Matrica4 druga)
    {
        m = new double[4][4];
        System.arraycopy(druga.m, 0, m, 0, 16);
    }
    
    public Matrica4 plus(Matrica4 druga)
    {
        Matrica4 n = new Matrica4();
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                n.m[i][j] = m[i][j] + druga.m[i][j];
        
        return n;
    }
    
    public Matrica4 minus(Matrica4 druga)
    {
        Matrica4 n = new Matrica4();
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                n.m[i][j] = m[i][j] - druga.m[i][j];
        
        return n;
    }
    
    public void neg()
    {
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                m[i][j] = -m[i][j];
    }
    
    public double daj(int i, int j)
    {
        return m[i][j];
    }
    
    public Matrica4 mm(Matrica4 druga)
    {
        Matrica4 n = new Matrica4();
        for(int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                for (int k = 0; k < 4; ++k)
                    n.m[i][j] = m[i][k] * druga.m[k][j];
        
        return n;
    }
    
    public Matrica4 skalm(double skalar)
    {
        Matrica4 n = new Matrica4();
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                n.m[i][j] = m[i][j] * skalar;
        
        return n;
    }
    
    public Matrica4 transponiraj()
    {
        Matrica4 n = new Matrica4();
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                n.m[i][j] = m[j][i];
        
        return n;
    }
    
    public Matrica4 skaliraj(double skalar)
    {
        return new Matrica4(skalar, 0, 0, 0,
                            0, skalar, 0, 0,
                            0, 0, skalar, 0,
                            0, 0, 0, 1);
    }
    
    public Matrica3 linearna()
    {
        return new Matrica3(m[0][0], m[0][1], m[0][2],
        m[1][0], m[1][1], m[1][2], m[2][0], m[2][1], m[2][2]);
    }
    
    public static Matrica4 jedinicna()
    {
        return new Matrica4(1, 0, 0, 0,
                            0, 1, 0, 0,
                            0, 0, 1, 0,
                            0, 0, 0, 1);
    }
    
    public Matrica4 rotirajX(double rad)
    {
        return new Matrica4(1, 0, 0, 0,
        0, Math.cos(rad), -Math.sin(rad), 0, 0,
        Math.sin(rad), Math.cos(rad), 0, 0, 0, 0, 0);
    }
    
    public Matrica4 rotirajY(double rad)
    {
        return new Matrica4(Math.cos(rad), 0, Math.sin(rad), 0,
        0, 1, 0, 0, -Math.sin(rad), 0, Math.cos(rad), 0, 0, 0, 0, 1);
    }
    
    public Matrica4 rotirajZ(double rad)
    {
        return new Matrica4(Math.cos(rad), -Math.sin(rad), 0, 0,
        Math.sin(rad), Math.cos(rad), 0, 0,
        0, 0, 1,  0,
        0, 0, 0, 1);
    }
    
    public Matrica4 translatiraj(Vektor3 vektor)
    {
        return new Matrica4(1, 0, 0, vektor.daj(0),
        0, 1, 0, vektor.daj(1),
        0, 0, 1, vektor.daj(2),
        0, 0, 0, 1);
    }
    
    
}
