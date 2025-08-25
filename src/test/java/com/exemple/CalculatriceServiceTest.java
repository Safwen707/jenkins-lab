package com.exemple;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class CalculatriceServiceTest {
    
    private CalculatriceService service;
    
    @Before
    public void setUp() {
        service = new CalculatriceService();
    }
    
    @Test
    public void testAddition() {
        double resultat = service.additionner(5, 3);
        assertEquals(8, resultat, 0.001);
    }
    
    @Test
    public void testSoustraction() {
        double resultat = service.soustraire(10, 4);
        assertEquals(6, resultat, 0.001);
    }
    
    @Test
    public void testMultiplication() {
        double resultat = service.multiplier(4, 7);
        assertEquals(28, resultat, 0.001);
    }
    
    @Test
    public void testDivision() {
        double resultat = service.diviser(15, 3);
        assertEquals(5, resultat, 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDivisionParZero() {
        service.diviser(10, 0);
    }
}