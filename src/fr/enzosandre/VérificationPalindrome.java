package fr.enzosandre;

public class VérificationPalindrome {
    private boolean _estFrançais;

    public VérificationPalindrome(LangueInterface langue) {
        _estFrançais = langue instanceof LangueFrançaise;
    }

    public String Vérifier(String chaîne) {
        String miroir =  new StringBuilder(chaîne)
                .reverse()
                .toString();

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(Expressions.Bonjour);
        resultBuilder.append(System.lineSeparator());
        resultBuilder.append(miroir);
        resultBuilder.append(System.lineSeparator());

        if(miroir.equals(chaîne)) {
            resultBuilder.append(this._estFrançais ? Expressions.BienDit : Expressions.WellSaid);
            resultBuilder.append(System.lineSeparator());
        }

        resultBuilder.append(Expressions.AuRevoir);
        return resultBuilder.toString();
    }
}
