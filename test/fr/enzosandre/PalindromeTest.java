package fr.enzosandre;

import fr.enzosandre.domain.*;
import fr.enzosandre.test.utilities.VérificationPalindromeBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
    @ParameterizedTest
    @ValueSource(strings = {"test", "epsi"})
    public void testMiroir(String chaîne) {
        // ETANT DONNE une chaîne n'étant pas un palindrome
        // QUAND on vérifie si c'est un palindrome
        String résultat = VérificationPalindromeBuilder.Default().Vérifier(chaîne);

        // ALORS, on obtient son miroir
        String inversion = new StringBuilder(chaîne)
                .reverse()
                .toString();

        assertTrue(résultat.contains(inversion));
    }


    static Stream<Arguments> casTestSalutations() {
        return Stream.of(
                Arguments.of(new LangueAnglaise(), PeriodeDeLaJournee.MATIN, "Good morning", "Goodbye, have a good day"),
                Arguments.of(new LangueAnglaise(), PeriodeDeLaJournee.SOIREE, "Good evening", "Goodbye, have a good evening"),
                Arguments.of(new LangueFrançaise(), PeriodeDeLaJournee.MATIN, "Bonjour", "Au revoir, passez une bonne journée"),
                Arguments.of(new LangueFrançaise(), PeriodeDeLaJournee.SOIREE, "Bonsoir", "Au revoir, passez une bonne soirée")
        );
    }

    @ParameterizedTest
    @MethodSource("casTestSalutations")
    public void testSalutations(LangueInterface langue, PeriodeDeLaJournee periode, String bonjour, String auRevoir){
        // ETANT DONNE un palindrome
        String palindrome = "radar";

        // ET un utilisateur parlant une <langue> à une certaine <periode>
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourPeriode(periode)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(palindrome);

        // ALORS la chaîne est précédée de <bonjour> et suivie de <auRevoir>
        String attendu = bonjour + System.lineSeparator() + palindrome + System.lineSeparator() + auRevoir;
        String[] lines = résultat.split(System.lineSeparator());
        assertEquals(attendu, lines[0] + System.lineSeparator() + lines[1] + System.lineSeparator() + lines[lines.length - 1]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testBonjour(String chaîne){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant français
        LangueFrançaise langue = new LangueFrançaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(chaîne);

        // ALORS toute réponse est précédée de "Bonjour"
        String[] lines = résultat.split(System.lineSeparator());
        assertEquals(Expressions.Bonjour, lines[0]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testAuRevoir(String chaîne){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant français
        LangueFrançaise langue = new LangueFrançaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(chaîne);

        // ALORS toute réponse est suivie de "Au Revoir"
        String[] lines = résultat.split(System.lineSeparator());
        String lastLine = lines[lines.length - 1];
        assertEquals(Expressions.AuRevoir, lastLine);
    }
    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testHello(String chaîne){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant anglais
        LangueAnglaise langue = new LangueAnglaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(chaîne);

        // ALORS toute réponse est précédée de "Hello"
        String[] lines = résultat.split(System.lineSeparator());
        assertEquals(Expressions.Hello, lines[0]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testGoodbye(String chaîne){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant anglais
        LangueAnglaise langue = new LangueAnglaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(chaîne);

        // ALORS toute réponse est suivie de "Goodbye"
        String[] lines = résultat.split(System.lineSeparator());
        String lastLine = lines[lines.length - 1];
        assertEquals(Expressions.Goodbye, lastLine);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testSalutationMatinFrançais(String chaîne){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant français
        LangueFrançaise langue = new LangueFrançaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourPeriode(PeriodeDeLaJournee.MATIN)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(chaîne);

        // ALORS toute réponse est précédée de "Bonjour"
        String[] lines = résultat.split(System.lineSeparator());
        assertEquals("Bonjour", lines[0]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testAuRevoirSoirFrançais(String chaîne){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant français
        LangueFrançaise langue = new LangueFrançaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourPeriode(PeriodeDeLaJournee.SOIREE)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(chaîne);

        // ALORS toute réponse est suivie de "Au revoir, passez une bonne soirée"
        String[] lines = résultat.split(System.lineSeparator());
        String lastLine = lines[lines.length - 1];
        assertEquals("Au revoir, passez une bonne soirée", lastLine);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testSalutationMatinAnglais(String chaîne){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant anglais
        LangueAnglaise langue = new LangueAnglaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourPeriode(PeriodeDeLaJournee.MATIN)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(chaîne);

        // ALORS toute réponse est précédée de "Good morning"
        String[] lines = résultat.split(System.lineSeparator());
        assertEquals("Good morning", lines[0]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testAuRevoirSoirAnglais(String chaîne){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant anglais
        LangueAnglaise langue = new LangueAnglaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourPeriode(PeriodeDeLaJournee.SOIREE)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(chaîne);

        // ALORS toute réponse est suivie de "Goodbye, have a good evening"
        String[] lines = résultat.split(System.lineSeparator());
        String lastLine = lines[lines.length - 1];
        assertEquals("Goodbye, have a good evening", lastLine);
    }

    @Test
    public void sautDeLigneTerminalTest(){
        var detectteur = new VérificationPalindromeBuilder().Default();

        var resultat = detectteur.Vérifier("");

        assertTrue(resultat.endsWith(System.lineSeparator()));
    }
}
