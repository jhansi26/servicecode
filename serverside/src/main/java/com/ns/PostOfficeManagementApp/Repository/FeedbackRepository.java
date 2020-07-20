package com.ns.PostOfficeManagementApp.Repository;

import com.ns.PostOfficeManagementApp.Model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
}
