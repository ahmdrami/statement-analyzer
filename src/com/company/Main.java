package com.company;


public class Main {


    public static void main(String[] args) throws Exception {
        // Start from Domain object
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankStatementAnalyzer.analyse(bankStatementParser);
    }


}
