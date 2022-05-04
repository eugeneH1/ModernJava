package Chapter5;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // all transactions in 2011, sorted
        List<Transaction> sorted2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        // all unique cities in which there where traders work
        List<String> uniqueCities = transactions.stream()
                //.map(t -> t.getTrader().getCity())
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        //System.out.println(uniqueCities);
        // alternative
        Set<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());

        // all traders from Cambridge, sorted alphabeticall
        List<Trader> cambridgeTraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        // System.out.println(cambridgeTraders);


        // A String of all traders' names sorted alphabetically
        String alphaNames = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
                //.reduce((x,y) -> x.concat(", " + y));

        // System.out.println(alphaNames);


        // any traders in Milan
        Optional<Trader> tradersInMilan =
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .findAny();
       System.out.println(tradersInMilan.isPresent());
       boolean Milan = transactions.stream()
               .anyMatch(l -> l.getTrader().getCity().equals("Milan"));


       // transaction values from Cambridge
       int cambridgeTransactions = transactions.stream()
               .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
               .mapToInt(Transaction::getValue)
               .reduce(0, Integer::sum);
        // System.out.println(cambridgeTransactions);

        // highest value transaction
        Optional<Integer> highestTransaction = transactions.stream()
                .map(Transaction::getValue)
                .reduce((t1, t2) -> t1 > t2 ? t1 : t2);
        // System.out.println(highestTransaction.get());

        // lowest value transaction
        Optional<Integer> lowestTransaction = transactions.stream()
                .map(Transaction::getValue)
                .reduce((t1, t2) -> t1 > t2 ? t2 : t1);
        System.out.println(lowestTransaction.get());

        Optional<Transaction> improvedMin = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));








    }
}
