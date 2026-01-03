package com.cog.pract.police.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cog.pract.police.model.PoliceDetails;
import com.cog.pract.police.repo.PoliceDetailsRepository;

@Service
public class PoliceDetailsService {
	@Autowired
	PoliceDetailsRepository policeDetailsRepository;
	
	@Cacheable(value="policedetails",key="#id",condition="#id !=null")
	public Optional<PoliceDetails> getPoliceDetilsById(Long id){
		return policeDetailsRepository.findById(id);
		
	}
	@CachePut(value = "policedetails", key = "#police.id")
    public PoliceDetails saveProduct(PoliceDetails policedetails) {
        return policeDetailsRepository.save(policedetails);
    }
	
	  @CacheEvict(value = "policedetails", key = "#id")
	    public void deleteProduct(Long id) {
		  policeDetailsRepository.deleteById(id);
	    }

	    public List<PoliceDetails> getAllPliceDetails() {
	        return policeDetailsRepository.findAll();
	    }
	
	
	    public Optional<PoliceDetails> getPoliceDetails(Long badgeId) {
	    	return policeDetailsRepository.findById(badgeId);
	    }
	
	    public List<PoliceDetails> getACPDetails() {
	    	List<PoliceDetails> myRole= policeDetailsRepository.findAll()
	    			.stream().
	    			filter(p -> p.getPoliceRank()!=null && p.getPoliceRank().startsWith("A")).toList();
	    	
	    	return myRole;
	    }
	    
	    public List<String> getSortedNameDetails(){
	    	List<String> sortedPoliceDetails = policeDetailsRepository.findAll()
	    			.stream().map(p->p.getFirstName().concat(p.getLastName())).toList();
	    	return sortedPoliceDetails;
	    }
}
