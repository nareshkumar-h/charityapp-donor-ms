package com.revature.charityappdonorms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.charityappdonorms.model.Donor;


@Repository
public interface DonorTranRepo extends JpaRepository<Donor, Integer> {

	

}
