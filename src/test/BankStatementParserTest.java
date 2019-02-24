package test;

import com.company.BankStatementCSVParser;
import com.company.BankStatementParser;
import com.company.BankTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementParserTest {

    private BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        String line = "30-01-2017,-50,Tesco";
        BankTransaction result = statementParser.parseFrom(line);
        BankTransaction expect = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

        Assert.assertEquals(expect.getDate(), result.getDate());
    }
}
