package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader("testdata/loginData.csv"));
        List<Object[]> data = new ArrayList<>();
        String[] line;
        reader.readNext(); // Pular cabeçalho

        while ((line = reader.readNext()) != null) {
            data.add(line);
        }
        reader.close();
        return data.toArray(new Object[0][]);
    }

    @DataProvider(name = "checkoutData")
    public static Object[][] getCheckoutData() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader("testdata/checkoutData.csv"));
        List<Object[]> data = new ArrayList<>();
        String[] line;
        reader.readNext(); // Pula cabeçalho

        while ((line = reader.readNext()) != null) {
            data.add(line);
        }
        reader.close();
        return data.toArray(new Object[0][]);
    }


}
