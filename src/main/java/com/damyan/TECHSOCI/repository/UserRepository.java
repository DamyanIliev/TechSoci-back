package com.damyan.TECHSOCI.repository;

import com.damyan.TECHSOCI.dbo.CourseDBO;
import com.damyan.TECHSOCI.dbo.UserDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDBO, Long> {
    UserDBO findByAlias(String alias);

    UserDBO findByEmail(String email);

    @Query("SELECT user FROM UserDBO user WHERE user.id != ?1 ORDER BY user.alias desc")
    List<UserDBO> findAllExceptActiveUser(long id);

    @Query("SELECT c FROM CourseDBO c JOIN c.students s WHERE s = :student")
    List<CourseDBO> findAllByStudent(@Param("student") UserDBO student);

}
