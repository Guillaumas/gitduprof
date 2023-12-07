package fr.enzosandre.test.utilities;

import fr.enzosandre.LangueInterface;
import fr.enzosandre.VérificationPalindrome;
import fr.enzosandre.utilities.PeriodeDeLaJournee;

public class VérificationPalindromeBuilder {
    private LangueInterface langue = new LangueStub();
    private PeriodeDeLaJournee periode = null;

    public static VérificationPalindrome Default() {
        return new VérificationPalindromeBuilder().Build();
    }

    public VérificationPalindromeBuilder AyantPourLangue(LangueInterface langue){
        this.langue = langue;
        return this;
    }

    public VérificationPalindromeBuilder AyantPourPeriode(PeriodeDeLaJournee periode){
        this.periode = periode;
        return this;
    }

    public VérificationPalindrome Build() {
        return new VérificationPalindrome(this.langue, this.periode);
    }
}