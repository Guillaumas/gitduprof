package fr.enzosandre.domain;

public class LangueAnglaise implements LangueInterface {
    @Override
    public String Féliciter() {
        return Expressions.WellSaid;
    }

    @Override
    public String DireBonjour() {
        return Expressions.Hello;
    }

    @Override
    public String DireAuRevoir() {
        return Expressions.Goodbye;
    }
    @Override
    public String getSalutation(PeriodeDeLaJournee periode) {
        if (periode == null) {
            return Expressions.Hello;
        }
        switch (periode) {
            case MATIN:
                return "Good morning";
            case APRES_MIDI:
                return "Good afternoon";
            case SOIREE:
                return "Good evening";
            case NUIT:
                return "Good night";
            default:
                return Expressions.Hello;
        }
    }

    @Override
    public String getAuRevoir(PeriodeDeLaJournee periode) {
        if (periode == null) {
            return Expressions.Goodbye;
        }
        switch (periode) {
            case MATIN:
                return "Goodbye, have a good day";
            case APRES_MIDI:
                return "Goodbye, have a good afternoon";
            case SOIREE:
                return "Goodbye, have a good evening";
            case NUIT:
                return "Goodbye, good night";
            default:
                return Expressions.Goodbye;
        }
    }



}