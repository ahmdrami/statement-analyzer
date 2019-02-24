package com.company;

import java.time.Month;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BankStatemenProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatemenProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
    }

    public double calculateTotalInMonth(Month month) {
        return bankTransactions.stream()
                .filter(transaction -> transaction.getDate().getMonth() == month)
                .mapToDouble(BankTransaction::getAmount).sum();
    }

    public double calculateTotalForCategory(String category) {
        return bankTransactions.stream()
                .filter(transaction -> transaction.getDescription().equals(category))
                .mapToDouble(BankTransaction::getAmount).sum();
    }

    public List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter) {
        return bankTransactions.stream()
                .filter(transaction -> bankTransactionFilter.test(transaction))
                .collect(toList());
    }

}
