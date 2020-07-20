package com.ns.PostOfficeManagementApp.Repository;

import com.ns.PostOfficeManagementApp.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    public Admin findByAdminemail(String adminemail);
}
