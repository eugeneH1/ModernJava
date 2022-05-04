package Chapter6;
import Chapter5.Trader;
import Chapter5.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class ImperativeGrouping {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300, Currency.getInstance(Locale.UK)),
                new Transaction(raoul, 2012, 1000, Currency.getInstance(Locale.UK)),
                new Transaction(raoul, 2011, 400, Currency.getInstance(Locale.UK)),
                new Transaction(mario, 2012, 710, Currency.getInstance(Locale.ITALY)),
                new Transaction(mario, 2012, 700, Currency.getInstance(Locale.UK)),
                new Transaction(alan, 2012, 950, Currency.getInstance(Locale.UK))
                );

        Map<Currency, List<Transaction>> transactionsByCurrencies =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));


        Map<Currency, List<Transaction>> transactionsByCurrenciers = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrenciers.computeIfAbsent(currency, k -> new ArrayList<>());
            transactionsForCurrency.add(transaction);
        }


    }



}
