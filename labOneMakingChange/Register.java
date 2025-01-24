package labOneMakingChange;


public class Register {
    public Purse makeChange(double amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }


        Purse purse = new Purse();
        Denomination[] denominations = {
                new Denomination("Fifty Dollar Note", 50.0, "bill", "fifty.png"),
                new Denomination("Twenty Dollar Note", 20.0, "bill", "twenty.png"),
                new Denomination("Ten Dollar Note", 10.0, "bill", "ten.png"),
                new Denomination("Five Dollar Note", 5.0, "bill", "five.png"),
                new Denomination("One Dollar Note", 1.0, "bill", "one.png"),
                new Denomination("Quarter", 0.25, "coin", "quarter.png"),
                new Denomination("Dime", 0.10, "coin", "dime.png"),
                new Denomination("Nickel", 0.05, "coin", "nickel.png"),
                new Denomination("Penny", 0.01, "coin", "penny.png")
        };


        for (Denomination denom : denominations) {
            int count = (int) (amt / denom.amt());
            if (count > 0) {
                purse.add(denom, count);
                amt -= count * denom.amt();
                amt = Math.round(amt * 100.0) / 100.0;
            }
        }


        return purse;
    }
}
