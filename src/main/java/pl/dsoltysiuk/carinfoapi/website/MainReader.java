package pl.dsoltysiuk.carinfoapi.website;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

public class MainReader {
    public static void main(String[] args) throws IOException {
        new csvTool().loadFile("Suwalki-20");
//        String mainPage = "https://www.otomoto.pl/osobowe/suwalki/?search%5Border%5D=created_at%3Adesc&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=200&search%5Bcountry%5D=&page=";
//        ReaderWebsite readerWebsite = new ReaderWebsite();
////        Set<OtoMotoCar> cars = new HashSet<>();
//        BufferedWriter bw = new BufferedWriter(new FileWriter("Suwalki-200" + ".csv", true));
//        bw.write("brand,model,variant,year,capacity,fuel,power,registerNumber\n");
//        for (int i = 1; i <= 341; i++) {
//            String adverts = readerWebsite.readWebsite(mainPage + i);
//            Set<String> links = readerWebsite.linkAdvertHandler(adverts);
//            for (String link : links) {
//                String page = readerWebsite.readWebsite(link);
//                if (page.contains("\"registration\"")) {
//                    OtoMotoCar car = readerWebsite.dataHandlerFromAdvertOtoMoto(page);
//                    if (car.getRegisterNumber() != null) {
//                        StringBuilder sb = new StringBuilder();
//                        sb
//                                .append(car.getBrand() + ",")
//                                .append(car.getModel() + ",")
//                                .append(car.getVariant() + ",")
//                                .append(car.getYearProduction() + ",")
//                                .append(car.getCapacity() + ",")
//                                .append(car.getFuel() + ",")
//                                .append(car.getPower() + ",")
//                                .append(car.getRegisterNumber() + "\n");
//                        bw.write(sb.toString());
//                    }
//                }
//            }
//        }
//        bw.close();

//        saveCarsToFile(cars);
//        System.out.println(cars.size());
//        String link = "https://www.otomoto.pl/oferta/bmw-x6-krajowy-salonowy-serwisowany-mocny-silnik-zamiana-ID6Dy2Do.html#e02400bc81";
//        String website = readerWebsite.readWebsite(link);
//        OtoMotoCar car = readerWebsite.dataHandlerFromAdvertOtoMoto(website);
//        System.out.println(car);


    }


    private static void saveCarsToFile(Set<OtoMotoCar> cars) {
        String fileTitle = LocalDateTime.now().toString() + "-Suwalki-200";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTitle + ".csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("brand,model,variant,year,capacity,fuel,power,registerNumber\n");
            cars.forEach(c -> {
                sb
                        .append(c.getBrand() + ",")
                        .append(c.getModel() + ",")
                        .append(c.getVariant() + ",")
                        .append(c.getYearProduction() + ",")
                        .append(c.getCapacity() + ",")
                        .append(c.getFuel() + ",")
                        .append(c.getPower() + ",")
                        .append(c.getRegisterNumber() + "\n");
            });
            bw.write(sb.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static void saveCarToFile(OtoMotoCar car) {
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("Suwalki-200" + ".csv"));
//            StringBuilder sb = new StringBuilder();
//            sb.append("brand,model,variant,year,capacity,fuel,power,registerNumber\n");
//            cars.forEach(c -> {
//                sb
//                        .append(c.getBrand() + ",")
//                        .append(c.getModel() + ",")
//                        .append(c.getVariant() + ",")
//                        .append(c.getYearProduction() + ",")
//                        .append(c.getCapacity() + ",")
//                        .append(c.getFuel() + ",")
//                        .append(c.getPower() + ",")
//                        .append(c.getRegisterNumber() + "\n");
//            });
//            bw.write(sb.toString());
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
