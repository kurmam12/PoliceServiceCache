package com.cog.pract.police.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cog.pract.police.model.PoliceDetails;
import com.cog.pract.police.service.PoliceDetailsService;

@RestController
@RequestMapping("/policedetails")
public class PoliceServiceController {
	private static final Logger log = LoggerFactory.getLogger(PoliceServiceController.class); 
	
	
	PoliceDetailsService policeDetailsService;
	public PoliceServiceController(PoliceDetailsService policeDetailsService) {
		this.policeDetailsService=policeDetailsService;
		
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<PoliceDetails> getProductById(@PathVariable("id") Long id) {
        Optional<PoliceDetails> policeDetails = policeDetailsService.getPoliceDetilsById(id);
        return policeDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@GetMapping
    public List<PoliceDetails> getAllProducts() {
        return policeDetailsService.getAllPliceDetails();
    }

    @PostMapping
    public PoliceDetails createProduct(@RequestBody PoliceDetails policeDetails) {
        return policeDetailsService.saveProduct(policeDetails);
    }
    @GetMapping("/getPoliceDetails")
    public ResponseEntity<PoliceDetails> getPolicDetails(@RequestParam(name = "badgeId",required = false) Long badgeId) {
    	log.info("I am inside the getPoliceDetails method");
    	if(badgeId!=null) {  
    		policeDetailsService.getPoliceDetails(badgeId);
    		return new ResponseEntity<PoliceDetails>(HttpStatus.OK);
    	} else {
		return new ResponseEntity<PoliceDetails>(HttpStatus.BAD_REQUEST);
    	}    	
    	
    }
    @GetMapping("/getAcpDetails")
    public List<String> getACPDetails() {
        return policeDetailsService.getSortedNameDetails();
    }

}
