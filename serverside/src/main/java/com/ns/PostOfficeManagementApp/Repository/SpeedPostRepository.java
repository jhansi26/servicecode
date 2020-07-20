package com.ns.PostOfficeManagementApp.Repository;

import com.ns.PostOfficeManagementApp.Model.SpeedPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
@Repository
public interface SpeedPostRepository extends JpaRepository<SpeedPost,Long> {
    //    public SpeedPost findBySendersEmail(String sendersEmail);
//    public List<SpeedPost> findById(Long id);
    @Modifying
    @Query(value= "UPDATE speedpost c SET c.status='Rejected' WHERE c.id= ?",
            nativeQuery = true)
    void  findByCustomQueryRejected(Long id);

    @Modifying
    @Query(value= "UPDATE speedpost c SET c.status='Accepted , Will be delivered in 2 days.' WHERE c.id= ?",
            nativeQuery = true)
    void  findByCustomQueryAccepted(Long id);
}
