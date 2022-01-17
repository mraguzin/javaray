/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaray.math;

import java.util.Arrays;

/**
 *
 * @author mraguzin
 */
public class Matrica3 {
    private static final double EPSILON = 1.0e-8f;
    private boolean determinantaSpremna = false;
    private double determinanta;
    private double m1, m2, m3;

    private double m[][];
    
    public Matrica3()
    {
        m = new double[3][3];
    }
    
    public Matrica3(double m11, double m12, double m13, double m21, double m22,
            double m23, double m31, double m32, double m33)
    {
        m = new double[3][3];
        
        m[0][0] = m11;
        m[0][1] = m12;
        m[0][2] = m13;
        m[1][0] = m21;
        m[1][1] = m22;
        m[1][2] = m23;
        m[2][0] = m31;
        m[2][1] = m32;
        m[2][2] = m33;
    }
    
    public Matrica3(Matrica3 druga)
    {
        m = new double[3][3];
        System.arraycopy(druga.m, 0, m, 0, 9);
    }
    
    public Matrica3(Vektor3[] stupci)
    {
        m = new double[3][3];
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                m[i][j] = stupci[j].daj(i);
    }
    
    public Vektor3 mv(Vektor3 v)
    {
        double a = m[0][0] * v.daj(0) + m[0][1] * v.daj(1) + m[0][2] * v.daj(2);
        double b = m[1][0] * v.daj(0) + m[1][1] * v.daj(1) + m[1][2] * v.daj(2);
        double c = m[2][0] * v.daj(0) + m[2][1] * v.daj(1) + m[2][2] * v.daj(2);
        
        return new Vektor3(a, b, c);
    }
    
    public Matrica3 plus(Matrica3 druga)
    {
        Matrica3 n = new Matrica3();
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                n.m[i][j] = m[i][j] + druga.m[i][j];
        
        return n;
    }
    
    public Matrica3 minus(Matrica3 druga)
    {
        Matrica3 n = new Matrica3();
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                n.m[i][j] = m[i][j] - druga.m[i][j];
        
        return n;
    }
    
    public void neg()
    {
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                m[i][j] = -m[i][j];
    }
    
    public Matrica3 mm(Matrica3 druga)
    {
        Matrica3 n = new Matrica3();
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                for (int k = 0; k < 3; ++k)
                    n.m[i][j] += m[i][k] * druga.m[k][j];
        
        return n;
    }
    
    public Matrica3 skalm(double skalar)
    {
        Matrica3 n = new Matrica3();
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                n.m[i][j] = m[i][j] * skalar;
        
        return n;
    }
    
    public Matrica3 transponiraj()
    {
        Matrica3 n = new Matrica3();
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                n.m[i][j] = m[j][i];
        
        return n;
    }
    
    public Matrica3 rotirajX(float rad)
    {
        return new Matrica3(1, 0, 0, 0, Math.cos(rad), -Math.sin(rad),
        0, Math.sin(rad), Math.cos(rad));
    }
    
    public Matrica3 rotirajY(float rad)
    {
        return new Matrica3(Math.cos(rad), 0, Math.sin(rad),
        0, 1, 0, -Math.sin(rad), 0, Math.cos(rad));
    }
    
    public Matrica3 rotirajZ(float rad)
    {
        return new Matrica3(Math.cos(rad), -Math.sin(rad), 0,
        Math.sin(rad), Math.cos(rad), 0, 0, 0, 1);
    }
    
    public static Matrica3 jedinicna()
    {
        return new Matrica3(new Vektor3[]{new Vektor3(1,0,0),
                                          new Vektor3(0,1,0),
                                          new Vektor3(0,0,1)});
    }
    
    public double daj(int i, int j)
    {
        return m[i][j];
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Matrica3))
            return false;
        
        Matrica3 obj1 = (Matrica3) obj;
        
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                if (Math.abs(m[i][j] - obj1.daj(i, j)) < EPSILON)
                    return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Arrays.deepHashCode(this.m);
        return hash;
    }
}
