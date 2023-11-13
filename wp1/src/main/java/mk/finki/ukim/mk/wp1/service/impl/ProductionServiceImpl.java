package mk.finki.ukim.mk.wp1.service.impl;

import mk.finki.ukim.mk.wp1.model.Production;
import mk.finki.ukim.mk.wp1.repository.ProductionRepository;
import mk.finki.ukim.mk.wp1.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionServiceImpl implements ProductionService {
    private final ProductionRepository productionRepository;

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public List<Production> findAll(){
        return productionRepository.findAll();
    }
    public Optional<Production> findById(Long id) {
        return productionRepository.findById(id);
    }

}
