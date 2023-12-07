package fr.enzosandre;

import fr.enzosandre.test.utilities.VérificationPalindromeBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    @ParameterizedTest
    @ValueSource(strings = {"test", "epsi"})
    public void testMiroir(String chaîne) {
        // ETANT DONNE une chaîne n'étant pas un palindrome
        // QUAND on vérifie si c'est un palindrome
        String résultat = VérificationPalindromeBuilder.Default().Vérifier(chaîne);

        // ALORS on obtient son miroir
        String inversion = new StringBuilder(chaîne)
                .reverse()
                .toString();

        assertTrue(résultat.contains(inversion));
    }

    @Test
    public void testPalindromeFrançais(){
        // ETANT DONNE un palindrome
        String palindrome = "radar";

        // ET un utilisateur parlant français
        LangueFrançaise langue = new LangueFrançaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(palindrome);

        // ALORS la chaîne est répétée, suivie de "Bien dit !"
        String attendu = palindrome + System.lineSeparator() + Expressions.BienDit;
        assertTrue(résultat.contains(attendu));
    }

    @Test
    public void testPalindromeAnglais(){
        // ETANT DONNE un palindrome
        String palindrome = "radar";

        // ET un utilisateur parlant anglais
        LangueAnglaise langue = new LangueAnglaise();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(palindrome);

        // ALORS la chaîne est répétée, suivie de "Well said !"
        String attendu = palindrome + System.lineSeparator() + Expressions.WellSaid;
        assertTrue(résultat.contains(attendu));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testBonjour(String chaîne){
        // ETANT DONNE une chaîne
        // QUAND on vérifie si c'est un palindrome
        String résultat =  VérificationPalindromeBuilder.Default().Vérifier(chaîne);

        // ALORS toute réponse est précédée de "Bonjour"
        String[] lines = résultat.split(System.lineSeparator());
        assertEquals(Expressions.Bonjour, lines[0]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testAuRevoir(String chaîne){
        // ETANT DONNE une chaîne
        // QUAND on vérifie si c'est un palindrome
        String résultat =  VérificationPalindromeBuilder.Default().Vérifier(chaîne);

        // ALORS toute réponse est suivie de "Au Revoir"
        String[] lines = résultat.split(System.lineSeparator());
        String lastLine = lines[lines.length - 1];
        assertEquals(Expressions.AuRevoir, lastLine);
    }
}
