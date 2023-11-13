package mk.finki.ukim.mk.wp1.service;

import mk.finki.ukim.mk.wp1.model.Production;

import java.util.List;
import java.util.Optional;

public interface ProductionService {
    public List<Production> findAll();
    public Optional<Production> findById(Long id);
}
