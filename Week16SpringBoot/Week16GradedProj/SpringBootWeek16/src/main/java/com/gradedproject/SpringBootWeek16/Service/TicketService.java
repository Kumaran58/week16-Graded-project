package com.gradedproject.SpringBootWeek16.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import com.gradedproject.SpringBootWeek16.Repository.TicketRepository;
import com.gradedproject.SpringBootWeek16.model.TicketModel;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository t1;
	
	public void save(TicketModel tic) {
		t1.save(tic);
	}
	
	public void update(TicketModel tic) {
		t1.save(tic);
	}
	
	public void delete(TicketModel tic) {
		t1.delete(tic);
	}
	
	public List<TicketModel> showAll(){
		return t1.findAll();
	}
	
	public TicketModel fingById(int id) {
		
		if(t1.findById(id).isEmpty()) {
			return null;
		}
		return t1.findById(id).get();
	}
	
	public List<TicketModel> filterByTitle(String value){
		
		TicketModel dummy=new TicketModel();
		dummy.setTickettitle(value);
		
		ExampleMatcher match=ExampleMatcher.matching().withMatcher("tickettitle",ExampleMatcher.GenericPropertyMatchers.contains()).withIgnorePaths("id","shortdescription","content","date");
		
		Example<TicketModel> ex=Example.of(dummy,match);
		return t1.findAll(ex);
		
		
	}
	
	

}
