package fr.enzosandre.test.utilities;

import fr.enzosandre.LangueAnglaise;
import fr.enzosandre.LangueFrançaise;
import fr.enzosandre.LangueInterface;
import fr.enzosandre.VérificationPalindrome;

public class VérificationPalindromeBuilder {
    private LangueInterface langue;

    public static VérificationPalindrome Default() {
        return new VérificationPalindromeBuilder().Build();
    }

    public VérificationPalindromeBuilder AyantPourLangue(LangueInterface langue){
        this.langue = langue;
        return this;
    }

    public VérificationPalindrome Build() {
        return new VérificationPalindrome(this.langue, 0);
    }
}
