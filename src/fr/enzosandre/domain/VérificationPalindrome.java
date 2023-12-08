package fr.enzosandre.domain;

public class VérificationPalindrome {
    private LangueInterface langue;
    private PeriodeDeLaJournee periode;

    public VérificationPalindrome(LangueInterface langue, PeriodeDeLaJournee periode) {
        this.langue = langue;
        this.periode = periode;
    }

    public void setLangue(LangueInterface langue) {
        this.langue = langue;
    }

    public void setPeriode(PeriodeDeLaJournee periode) {
        this.periode = periode;
    }

    public String Vérifier(String chaîne) {
        String miroir =  new StringBuilder(chaîne)
                .reverse()
                .toString();

        String salutation = langue.getSalutation(periode);
        String auRevoir = langue.getAuRevoir(periode);
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(salutation);
        resultBuilder.append(System.lineSeparator());
        resultBuilder.append(miroir);
        resultBuilder.append(System.lineSeparator());

        if(miroir.equals(chaîne)) {
            resultBuilder.append(this.langue.Féliciter());
            resultBuilder.append(System.lineSeparator());
        }

        resultBuilder.append(auRevoir);
        resultBuilder.append(System.lineSeparator());
        return resultBuilder.toString();
    }
}