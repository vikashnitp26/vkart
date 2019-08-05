package com.vkart.dao;

import com.vkart.model.Address;

public interface AddressDAO {
	public Address getAddressByUserId(int userId);
	public void addAddress(Address address);
	public void deleteAddress(Address address);
}
