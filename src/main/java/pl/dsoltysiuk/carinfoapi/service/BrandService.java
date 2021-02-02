package pl.dsoltysiuk.carinfoapi.service;

import pl.dsoltysiuk.carinfoapi.model.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getBrands();
    Brand getSingleBrand(Long id);
}
