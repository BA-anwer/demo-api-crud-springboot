package com.demo.user.Repository;




import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.user.Model.Child;
import com.demo.user.Model.User;

@Repository
public interface ChildRepository extends   JpaRepository<Child, Integer>{


	Set<Child> findAllByParent(User parent);

}
