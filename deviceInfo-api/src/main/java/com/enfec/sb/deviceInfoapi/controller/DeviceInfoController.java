package com.enfec.sb.deviceInfoapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enfec.sb.deviceInfoapi.model.DeviceInfoTable;
import com.enfec.sb.deviceInfoapi.repository.DeviceInfoRepositoryImpl;
import com.google.gson.Gson;

@RestController
public class DeviceInfoController {

	@Autowired
	DeviceInfoRepositoryImpl deviceInfoRepositoryImpl;

	@RequestMapping(value = "/organizer/search/{Organizer_ID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> getDeviceList(@PathVariable int Organizer_ID) {
			List<DeviceInfoTable> deviceList = deviceInfoRepositoryImpl
					.getOrganizerInfo(Organizer_ID);
			if (deviceList.isEmpty()) {
				return new ResponseEntity<>(
						"{\"message\" : \"No device found\"}", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						new Gson().toJson((deviceInfoRepositoryImpl
								.getOrganizerInfo(Organizer_ID))), HttpStatus.OK);
			}
	}

	@RequestMapping(value = "/registerdevice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> registerDevice(
			@RequestBody(required = true) DeviceInfoTable deviceInfoTable) {
			int affectedRow = deviceInfoRepositoryImpl
					.registerDevice(deviceInfoTable);

			if (affectedRow == 0) {
				return new ResponseEntity<>(
						"{\"message\" : \"Device not registerd\"}",
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						"{\"message\" : \"Device Registered\"}", HttpStatus.OK);
			}
	}

	@RequestMapping(value = "/updatedevice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> updateDevice(
			@RequestBody(required = true) DeviceInfoTable deviceInfoTable) {
			int affectedRow = deviceInfoRepositoryImpl
					.updateDevice(deviceInfoTable);

			if (affectedRow == 0) {
				return new ResponseEntity<>(
						"{\"message\" : \"Device not found\"}", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						"{\"message\" : \"Device updated\"}", HttpStatus.OK);
			}
	}

}
