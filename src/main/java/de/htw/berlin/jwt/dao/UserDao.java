package de.htw.berlin.jwt.dao;

import de.htw.berlin.jwt.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

    DAOUser findByUsername(String username);

}