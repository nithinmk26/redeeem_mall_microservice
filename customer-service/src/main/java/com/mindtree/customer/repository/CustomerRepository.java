/**
 * 
 */
package com.mindtree.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.customer.entity.Customer;

/**
 * @author M1056182
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
