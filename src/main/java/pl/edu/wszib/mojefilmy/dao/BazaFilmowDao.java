package pl.edu.wszib.mojefilmy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.mojefilmy.domain.BazaFilmow;


@Repository
public interface BazaFilmowDao extends CrudRepository<BazaFilmow, String> {
}
