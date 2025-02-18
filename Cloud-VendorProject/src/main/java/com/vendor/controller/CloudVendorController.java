package com.vendor.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.custresponse.ResponseHandler;
import com.vendor.model.CloudVendor;
import com.vendor.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")

public class CloudVendorController {

   CloudVendorService cloudVendorService;
   
	
	public CloudVendorController(CloudVendorService cloudVendorService) {
	
	this.cloudVendorService = cloudVendorService;
}


//Read Specfic one
	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getCloudVendordetails(@PathVariable("vendorId") String vendorId) {
//		String vendorName;
//		String vendorAddress;
//		String vendorPhoneNo;
//		return new CloudVendor(vendorId="s1", vendorName="pavan", vendorAddress="addr1", vendorPhoneNo="1234567894");
		
		String message;
		return ResponseHandler.responseBuilder(message="Requested vendor detils are given here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
		 
	}
	//Read all
	@GetMapping()
	public List<CloudVendor> getAllCloudVendordetails() {

		return cloudVendorService.getAllCloudVendors();
	}
	
	
	
	@PostMapping
	public String createVendor(@RequestBody CloudVendor cloudVendor)
	{
		//this.cloudVendorService=cloudVendor;
	   cloudVendorService.createCloudVendor(cloudVendor);
	   
		return "Cloud Vendor Created Sucessfully";
		
	}
	
	
	@PutMapping
	public String updatecloudVendor(@RequestBody CloudVendor cloudVendor) {
		//this.cloudVendorService=cloudVendor;
		
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Cloud Vendor Updated successfully";
	}
	
	@DeleteMapping("{vendorId}")
	public String deletecloudVendor( @PathVariable("vendorId") String vendorId) {
		//this.cloudVendorService=null;
		
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Cloud Vendor Deleted  successfully";
	}
}
