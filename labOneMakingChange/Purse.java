package labOneMakingChange;
import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    // Take in an amount and add to current total in purse
    public void add(Denomination money, int num){
        cash.put(money, cash.getOrDefault(money, 0) + num);
    }

    // Removes an amount from current total in purse
    public double remove(Denomination money, int num){
        if (money == null || num <= 0 || !cash.containsKey(money) || cash.get(money) < num) {
            return 0;
        }
        cash.put(money, cash.get(money) - num);
        if (cash.get(money) == 0) {
            cash.remove(money);
        }
        return money.amt() * num*1.00;
    }

    // returns total amount in purse
    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    //returns content of purse via String
    @Override
    public String toString() {
        if (cash.isEmpty()) {
            return "Empty Purse";
        }
        StringBuilder sb = new StringBuilder();
        cash.forEach((denomination, count) ->
                sb.append(count).append(" ").append(denomination.name()).append("\n")
        );
        sb.append("Total value: $").append(String.format("%.2f", getValue()));
        return sb.toString();
    }

}
