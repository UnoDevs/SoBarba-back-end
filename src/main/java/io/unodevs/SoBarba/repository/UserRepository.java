package io.unodevs.SoBarba.repository;

import io.unodevs.SoBarba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.username =: userName")
    User findByUsername(@Param("userName") String userName);
}
