package fr.enzosandre.test.utilities;

import fr.enzosandre.domain.LangueInterface;
import fr.enzosandre.domain.PeriodeDeLaJournee;

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
