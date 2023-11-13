package mk.finki.ukim.mk.wp1.repository;

import mk.finki.ukim.mk.wp1.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp1.model.Production;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductionRepository {
    public List<Production> findAll() {
        return DataHolder.productions;
    }
public Optional<Production> findById(Long Id) {
       return   DataHolder.productions.stream().filter(r->r.getId().equals(Id)).findFirst();

}

}
