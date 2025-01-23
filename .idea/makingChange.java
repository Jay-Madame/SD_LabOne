import java.util.HashMap;
import java.util.Map;

class Denomination{
    public String name;
    public double totalAmount;
    public String form;
    public String imgFile;
};

public class Purse {
    Map<Denomination, Integer> purse = new HashMap<>();

    // Take in an amount and add to current total in purse
    void add(Denomination currency, double amt){
        currency.totalAmount += amt;
    }

    // Removes an amount from current total in purse
    void remove(Denomination currency, double amt){
        currency.totalAmount -= amt;
    }

    // returns total amount in purse
    double getValue(){
        return Denomination.totalAmount;
    }

    String toString() {
        int dollars = (int) getValue();
        double cents = int ((getValue()*100)/10000);
    }

}

public Purse makeChange(double amount)
{
    Purse purse = new Purse();
    return purse;
}

public Purse register(double amount)
{
    Purse purse = new Purse();
    purse = makeChange(amount);
    return purse;
}
