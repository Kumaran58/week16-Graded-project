package com.gradedproject.SpringBootWeek16.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradedproject.SpringBootWeek16.model.TicketModel;

public interface TicketRepository extends JpaRepository<TicketModel, Integer> {

}
