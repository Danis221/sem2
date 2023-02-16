package ru.itis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itis.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
