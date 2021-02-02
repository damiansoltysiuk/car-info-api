package pl.dsoltysiuk.carinfoapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dsoltysiuk.carinfoapi.model.Brand;
import pl.dsoltysiuk.carinfoapi.service.BrandService;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping
    public List<Brand> getBrands() {
        return brandService.getBrands();
    }

    @GetMapping("/{id}")
    public Brand getSingleBrand(@PathVariable(name = "id") Long id) {
        return brandService.getSingleBrand(id);
    }
}
