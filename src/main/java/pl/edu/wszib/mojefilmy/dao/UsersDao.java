package pl.edu.wszib.mojefilmy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.mojefilmy.domain.Users;
@Repository
public interface UsersDao extends CrudRepository<Users, String> {
    boolean existsByPassword(String s);
}
