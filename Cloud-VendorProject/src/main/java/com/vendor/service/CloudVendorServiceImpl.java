package com.vendor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vendor.exception.CloudVendorNotFoundException;
import com.vendor.model.CloudVendor;
import com.vendor.repo.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository=cloudVendorRepository;
	}
	
	
	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		// TODO Auto-generated method stub
		
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		// TODO Auto-generated method stub
		cloudVendorRepository.save(cloudVendor);
		return "Updated";
	}

	@Override
	public String deleteCloudVendor(String cloudvendorId) {
		// TODO Auto-generated method stub
		cloudVendorRepository.deleteById(cloudvendorId);
		return "Deleted";
	}

	@Override
	
	public CloudVendor getCloudVendor(String cloudVendorId) {
		// TODO Auto-generated method stub
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		
		return cloudVendorRepository.findById(cloudVendorId).get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		// TODO Auto-generated method stub
		
		return cloudVendorRepository.findAll();
	}

}
