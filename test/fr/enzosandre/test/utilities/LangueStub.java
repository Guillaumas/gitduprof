package fr.enzosandre.test.utilities;

import fr.enzosandre.LangueInterface;
import fr.enzosandre.utilities.PeriodeDeLaJournee;

public class LangueStub implements LangueInterface {
    @Override
    public String Féliciter() {
        return "";
    }

    @Override
    public String DireBonjour() {
        return "";
    }

    @Override
    public String DireAuRevoir() {
        return "";
    }

    @Override
    public String getSalutation(PeriodeDeLaJournee periode) {
        return "";
    }

    @Override
    public String getAuRevoir(PeriodeDeLaJournee periode) {
        return "";
    }


}
