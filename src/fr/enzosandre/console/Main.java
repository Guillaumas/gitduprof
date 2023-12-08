package fr.enzosandre.console;

import fr.enzosandre.domain.LangueFrançaise;
import fr.enzosandre.domain.PeriodeDeLaJournee;
import fr.enzosandre.domain.VérificationPalindrome;

public class Main {
    public static void main(String[] args) {
        var langue = new LangueSysteme();
        var momentDeLaJournée = DetectionMomentJournee.Detecter();
        var detecteurPalindrome = new VérificationPalindrome(langue, momentDeLaJournée);

        var scanner = new java.util.Scanner(System.in);
        var resultat = detecteurPalindrome.Vérifier(scanner.nextLine());
        System.out.println(resultat);
    }
}
