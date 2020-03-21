package com.enfec.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/************************************************
*
* Author: Sylvia Zhao
* Assignment: Organizer address Rowmapper for 'Address' table
* Class: AddressRowmapper
*
************************************************/
public class AddressRowmapper implements RowMapper<Address> {

	/**
	 * Map each MySql column's content to organizer address table
	 * 
	 * @param rs: ResultSet
	 * @param rowNum
	 * @throws SQLException when column doesn't exist in database
	 * @return Address
	 */
	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address = new Address();
		address.setAddress_id(rs.getInt("Address_ID"));
		address.setStreet1((rs.getString("Street1")));
		address.setStreet2((rs.getString("Street2")));
		address.setCity((rs.getString("City")));
		address.setState((rs.getString("State")));
		address.setZipcode(rs.getString("Zipcode"));
		address.setOrganizer_id(rs.getInt("Organizer_ID"));
		return address;
	}
}
