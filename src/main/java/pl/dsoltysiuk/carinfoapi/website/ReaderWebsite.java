package pl.dsoltysiuk.carinfoapi.website;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class ReaderWebsite {
    protected final String PATTERN_LINK_AD = "https://www.otomoto.pl/oferta/";
    private OtoMotoCarRepository otoMotoCarRepository;

    protected String readWebsite(String link) {
        StringBuilder page = new StringBuilder();
        try {
            URL url = new URL(link);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                page.append(inputLine).append(System.lineSeparator());
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page.toString();
    }

    protected Set<String> linkAdvertHandler(String page) {
        String[] lines = page.split(System.lineSeparator());
        Set<String> linksAdvert = new HashSet<>();
        for (String s : lines) {
            if (s.contains(PATTERN_LINK_AD)) {
                String link = s.split("\"")[1];
                if(!link.contains("#")) {
                    linksAdvert.add(link);
                }
            }
        }
        return linksAdvert;
    }

    protected OtoMotoCar dataHandlerFromAdvertOtoMoto(String page) {
        OtoMotoCar car = OtoMotoCar.builder().build();
        int indexStart = page.indexOf("GPT.targeting");
        int indexStop = page.indexOf("window.baxterEnabled");

        if(indexStart == -1 || indexStop == -1) {
            //
            return car;
        }

        String data = page.substring(indexStart, indexStop);
        String[] infoCar = data.substring(data.indexOf("{") + 1, data.indexOf("}")).trim().split(",");



        for (String s : infoCar) {
            if(s.contains("\"ad_id\"")) {
                String idAdvert = s.split(":")[1].replaceAll("\"", "");
                car.setIdAdvert(Long.parseLong(idAdvert));
            } else if (s.contains("\"make\"")) {
                String brand = trimValue(s);
                car.setBrand(brand);
            } else if (s.contains("\"model\"")) {
                String model = trimValue(s);
                car.setModel(model);
            } else if (s.contains("\"version\"")) {
                String variant = trimValue(s).replaceAll("ver-", "").replaceAll("-", " ");
                car.setVariant(variant);
            } else if (s.contains("\"year\"")) {
                String year = trimValue(s);
                car.setYearProduction(Short.parseShort(year));
            } else if (s.contains("\"engine_capacity\"")) {
                String capacity = trimValue(s);
                car.setCapacity(Short.parseShort(capacity));
            } else if (s.contains("\"fuel_type\"")) {
                String fuel = trimValue(s);
                car.setFuel(fuel);
            } else if (s.contains("\"engine_power\"")) {
                String power = trimValue(s);
                car.setPower(Short.parseShort(power));
            } else if (s.contains("\"ad_price\"")) {
                String price = trimValue(s);
                try {
                    car.setPrice(Short.parseShort(price));
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    car.setPrice(Short.valueOf("0"));
                }
            } else if (s.contains("\"registration\"")) {
                String registration = trimValue(s);
                car.setRegisterNumber(registration);
            }
        }
        otoMotoCarRepository.save(car);
        return car;
    }


    private String trimValue(String s) {
        return s.split(":")[1]
                .replaceAll("\"", "")
                .replaceAll("\\[","")
                .replaceAll("]","")
                .trim();
    }
}
