package com.ns.PostOfficeManagementApp.Repository;

import com.ns.PostOfficeManagementApp.Model.StatusOfPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@Repository
public interface StatusOfPostRepository  extends JpaRepository<StatusOfPost,Long> {

    @Modifying
    @Query(value= "UPDATE statusofpost c SET c.status='granted' WHERE c.id= ?",
            nativeQuery = true)
    void  findByCustomQuery(Long id);

}
