package fr.enzosandre.console;

import fr.enzosandre.domain.LangueAnglaise;
import fr.enzosandre.domain.LangueFrançaise;
import fr.enzosandre.domain.LangueInterface;
import fr.enzosandre.domain.PeriodeDeLaJournee;

public class LangueSysteme implements LangueInterface {
    private LangueInterface langueDetectee;
    public LangueSysteme() {
        var codeLangue = System.getProperty("user.language");
        if (codeLangue.equals("fr")) {
            langueDetectee = new LangueFrançaise();
        } else {
            langueDetectee = new LangueAnglaise();
        }
    }
    public String Féliciter() {
        return langueDetectee.Féliciter();
    }
    public String DireBonjour() {
        return langueDetectee.DireBonjour();
    }
    public String DireAuRevoir() {
        return langueDetectee.DireAuRevoir();
    }

    public String getSalutation(PeriodeDeLaJournee periode) {
        return langueDetectee.getSalutation(periode);
    }

    public String getAuRevoir(PeriodeDeLaJournee periode) {
        return langueDetectee.getAuRevoir(periode);
    }

}
