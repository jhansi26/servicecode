package com.ns.PostOfficeManagementApp.Repository;

import com.ns.PostOfficeManagementApp.Model.RegisteredPost;
import com.ns.PostOfficeManagementApp.Model.SpeedPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Transactional
@Service
@Repository
public interface RegisteredPostRepository extends JpaRepository<RegisteredPost,Long>{
    @Modifying
    @Query(value= "UPDATE registeredpost c SET c.status='Rejected' WHERE c.id= ?",
            nativeQuery = true)
    void  findByCustomQueryRejected(Long id);

    @Modifying
    @Query(value= "UPDATE registeredpost c SET c.status='Accepted , Will be delivered in 2 days.' WHERE c.id= ?",
            nativeQuery = true)
    void  findByCustomQueryAccepted(Long id);
}






