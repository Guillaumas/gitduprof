package fr.enzosandre;

public class VérificationPalindrome {
    private LangueInterface langue;

    public VérificationPalindrome(LangueInterface langue) {
        this.langue = langue;
    }

    public void setLangue(LangueInterface langue) {
        this.langue = langue;
    }

    public String Vérifier(String chaîne) {
        String miroir =  new StringBuilder(chaîne)
                .reverse()
                .toString();

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(langue.DireBonjour());
        resultBuilder.append(System.lineSeparator());
        resultBuilder.append(miroir);
        resultBuilder.append(System.lineSeparator());

        if(miroir.equals(chaîne)) {
            resultBuilder.append(this.langue.Féliciter());
            resultBuilder.append(System.lineSeparator());
        }

        resultBuilder.append(langue.DireAuRevoir());
        return resultBuilder.toString();
    }
}