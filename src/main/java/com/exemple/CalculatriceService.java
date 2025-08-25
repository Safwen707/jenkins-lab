package com.exemple;

/**
 * Service contenant la logique de calcul
 * Séparé du servlet pour faciliter les tests
 */
public class CalculatriceService {
    
    public double additionner(double a, double b) {
        return a + b;
    }
    
    public double soustraire(double a, double b) {
        return a - b;
    }
    
    public double multiplier(double a, double b) {
        return a * b;
    }
    
    public double diviser(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division par zéro impossible");
        }
        return a / b;
    }
    
    /**
     * Méthode principale qui choisit l'opération
     */
    public double calculer(double a, double b, String operation) {
        switch (operation) {
            case "+":
                return additionner(a, b);
            case "-":
                return soustraire(a, b);
            case "*":
                return multiplier(a, b);
            case "/":
                return diviser(a, b);
            default:
                throw new IllegalArgumentException("Opération non reconnue: " + operation);
        }
    }
}