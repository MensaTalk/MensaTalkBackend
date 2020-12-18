package de.htw.berlin.MensaTalk.MensaTalkBackend.User.dao;

import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}