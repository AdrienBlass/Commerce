package com.example.commerce.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class MathUtils {

    // Constructeur privé pour empêcher l'instanciation
    private MathUtils() {
        throw new UnsupportedOperationException("Classe utilitaire, ne peut pas être instanciée");
    }

    /**
     * Arrondit une valeur double à 2 décimales
     * @param valeur la valeur à arrondir
     * @return la valeur arrondie à 2 décimales
     */
    public static double arrondir2Decimales(double valeur) {
        return Math.round(valeur * 100.0) / 100.0;
    }

    /**
     * Arrondit une valeur double avec un nombre spécifique de décimales
     * @param valeur la valeur à arrondir
     * @param decimales le nombre de décimales
     * @return la valeur arrondie
     */
    public static double arrondir(double valeur, int decimales) {
        double multiplicateur = Math.pow(10, decimales);
        return Math.round(valeur * multiplicateur) / multiplicateur;
    }

    /**
     * Arrondit un BigDecimal à 2 décimales avec le mode HALF_UP
     * @param valeur la valeur BigDecimal à arrondir
     * @return la valeur arrondie à 2 décimales
     */
    public static BigDecimal arrondirBigDecimal(BigDecimal valeur) {
        return valeur.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Calcule le montant de TVA pour un prix HT et un taux donné
     * @param prixHt le prix hors taxes
     * @param tauxTva le taux de TVA (ex: 5.5 pour 5.5%)
     * @return le montant de TVA arrondi à 2 décimales
     */
    public static double calculerTva(double prixHt, double tauxTva) {
        double montantTva = prixHt * (tauxTva / 100);
        return arrondir2Decimales(montantTva);
    }

    /**
     * Calcule le prix TTC à partir du prix HT et du taux de TVA
     * @param prixHt le prix hors taxes
     * @param tauxTva le taux de TVA (ex: 5.5 pour 5.5%)
     * @return le prix TTC arrondi à 2 décimales
     */
    public static double calculerPrixTtc(double prixHt, double tauxTva) {
        double prixTtc = prixHt * (1 + tauxTva / 100);
        return arrondir2Decimales(prixTtc);
    }

    /**
     * Version BigDecimal pour calculer le montant de TVA
     * @param prixHt le prix hors taxes
     * @param tauxTva le taux de TVA
     * @return le montant de TVA arrondi
     */
    public static BigDecimal calculerTva(BigDecimal prixHt, BigDecimal tauxTva) {
        BigDecimal cent = new BigDecimal("100");
        BigDecimal montantTva = prixHt.multiply(tauxTva).divide(cent, 2, RoundingMode.HALF_UP);
        return arrondirBigDecimal(montantTva);
    }

    /**
     * Version BigDecimal pour calculer le prix TTC
     * @param prixHt le prix hors taxes
     * @param tauxTva le taux de TVA
     * @return le prix TTC arrondi
     */
    public static BigDecimal calculerPrixTtc(BigDecimal prixHt, BigDecimal tauxTva) {
        BigDecimal cent = new BigDecimal("100");
        BigDecimal montantTva = calculerTva(prixHt, tauxTva);
        return arrondirBigDecimal(prixHt.add(montantTva));
    }
}