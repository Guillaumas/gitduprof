package fr.enzosandre;

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
}