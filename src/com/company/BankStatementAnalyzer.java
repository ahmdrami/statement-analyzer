package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/resources/statement.csv";

    public void analyse(BankStatementParser bankStatementParser) throws IOException {
        Path path = Paths.get(RESOURCES);
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        BankStatemenProcessor bankStatemenProcessor = new BankStatemenProcessor(bankTransactions);

        List<BankTransaction> filterTransactions = bankStatemenProcessor.findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 3000);

        filterTransactions.stream().forEach(bankTransaction -> System.out.println(bankTransaction.getAmount()));
        System.out.println("The total for all transactions is " + bankStatemenProcessor.calculateTotalAmount());
        System.out.println("The total for the month " + bankStatemenProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total salary received is  " + bankStatemenProcessor.calculateTotalForCategory("Salary"));

    }
}
