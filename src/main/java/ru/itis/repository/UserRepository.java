package ru.itis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itis.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByEmail(String email);

    List<User> findAllByIdAndEmailNotNull(Integer id);

    Page<User> findAll(Pageable pageable);

    @Query(value = "select * from users u where u.name like ?1", nativeQuery = true)
    List<User> findAllByName(String name);

    @Query("select u from User u where u.email = :email")
    List<User> findAllByEmail(String email);

//    @Query(value = "select u from User u where u.name=:name and u.id = :id")
//    User findUserByNameAndId(@Pa)
}
