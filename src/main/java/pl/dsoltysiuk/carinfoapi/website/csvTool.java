package pl.dsoltysiuk.carinfoapi.website;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class csvTool {

    private enum Headers {
        Brand, Model, Variant, Year, Capacity, Power, Fuel, RegisterNumber
    }

    protected Set<OtoMotoCar> loadFile(String filename) {
        Set<OtoMotoCar> cars = new HashSet<>();
        try {
            Reader in = new FileReader(filename + ".csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
            for(CSVRecord record : records) {
                String brand = record.get(Headers.Brand);
                String model = record.get(Headers.Model);
                String variant = record.get(Headers.Variant);
                String year = record.get(Headers.Year);
                String capacity = record.get(Headers.Capacity);
                String power = record.get(Headers.Power);
                String fuel = record.get(Headers.Fuel);
                String registerNumber = record.get(Headers.RegisterNumber);

                OtoMotoCar car = OtoMotoCar.builder()
                        .brand(brand)
                        .model(model)
                        .yearProduction(Short.parseShort(year))
                        .variant(variant)
                        .capacity(Short.parseShort(capacity))
                        .power(Short.parseShort(power))
                        .fuel(fuel)
                        .registerNumber(registerNumber)
                        .build();

                cars.add(car);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    protected void saveFile(String filename, Set<OtoMotoCar> cars) {
        String outputFilePath = filename + ".csv";
        try {
            BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputFilePath));
            CSVPrinter csvPrinter = CSVFormat.RFC4180.withHeader(Headers.class).print(bw);
            csvPrinter.printRecords(cars);
            cars.forEach(c -> {
                try {
                    csvPrinter.printRecord(
                            c.getBrand(), c.getModel(), c.getVariant(),
                            c.getYearProduction(), c.getCapacity(), c.getPower(),
                            c.getFuel(), c.getRegisterNumber());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
