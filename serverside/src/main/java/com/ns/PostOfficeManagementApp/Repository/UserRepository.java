package com.ns.PostOfficeManagementApp.Repository;

import com.ns.PostOfficeManagementApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  public  User findByEmail(String email);
}
