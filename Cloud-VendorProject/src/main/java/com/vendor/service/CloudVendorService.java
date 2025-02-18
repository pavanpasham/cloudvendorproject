package com.vendor.service;

import java.util.List;

import com.vendor.model.CloudVendor;

public interface CloudVendorService {

	public String createCloudVendor(CloudVendor cloudVendor);
	public String updateCloudVendor(CloudVendor cloudVendor);
	public String deleteCloudVendor(String cloudvendorId);
	public CloudVendor getCloudVendor(String cloudVendorId);
	public List<CloudVendor> getAllCloudVendors();
}
