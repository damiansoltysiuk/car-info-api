package pl.dsoltysiuk.carinfoapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dsoltysiuk.carinfoapi.model.Brand;
import pl.dsoltysiuk.carinfoapi.repository.BrandRepository;
import pl.dsoltysiuk.carinfoapi.service.BrandService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    public Brand getSingleBrand(Long id) {
        return brandRepository.findById(Short.parseShort(id + "")).orElseThrow();
    }
}
