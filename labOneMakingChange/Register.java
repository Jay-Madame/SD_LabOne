package labOneMakingChange;


public class Register {
    public Purse makeChange(double amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }


        Purse purse = new Purse();
        Denomination[] denominations = {
                new Denomination("Hundred-Dollar Bill", 100.00, "bill", "/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/oneHundredDollarBill.png"),
                new Denomination("Fifty-Dollar Bill", 50.0, "bill", "/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/fiftyDollarBill.png"),
                new Denomination("Twenty-Dollar Bill", 20.0, "bill","/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/twentyDollarBill.png"),
                new Denomination("Ten-Dollar Bill", 10.0, "bill","/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/tenDollarBill.png"),
                new Denomination("Five-Dollar Bill", 5.0, "bill","/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/fiveDollarBill.png"),
                new Denomination("One-Dollar Bill", 1.0,"bill", "/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/oneDollarBill.png"),
                new Denomination("Quarter", 0.25,"coin","/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/quarter.png"),
                new Denomination("Dime", 0.10,"coin,","/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/dime.png"),
                new Denomination("Nickel", 0.05, "coin,","/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/nickle.png"),
                new Denomination("Penny", 0.01,"coin", "/Users/jay/Projects/SD_Spring2025/Module1/LabOne/labOneMakingChange/penny.png")
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
