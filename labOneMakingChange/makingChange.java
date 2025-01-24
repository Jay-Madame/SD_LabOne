package labOneMakingChange;

public class makingChange {
    public static void main(String[] args) {
        Denomination fiveDollar = new Denomination("Five note", 5.00, "bill", "fiveDollar.png");
        Denomination quarter = new Denomination("Quarter", 0.25, "coin", "quarter.png");
        Purse wallet = new Purse();
        wallet.add(fiveDollar, 1);
        wallet.add(quarter, 2);
        System.out.println(wallet);
        wallet.add(quarter, 1);
        wallet.remove(fiveDollar, 1);
        System.out.println(wallet);
    }
}
