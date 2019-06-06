package pl.edu.wszib.mojefilmy.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.mojefilmy.domain.MojeFilmy;


@Repository
public interface MojeFilmyDao extends CrudRepository<MojeFilmy, String> {
    MojeFilmy findAllByLogin(String login);
}
