package com.microservice.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServiceController {

	@Autowired
	private Environment env;

	@GetMapping("/techInfo/{platform}")
	public ResponseModel retrieveTechnologyInfo(@PathVariable("platform") String platform) {
		ResponseModel responseModel = new ResponseModel();

		if (platform.equalsIgnoreCase("Java")) {
			responseModel.setTittle("Technology Stack");
			responseModel.setPlatform("Java");
			responseModel.setUsedFor("Secured Web Services");
		} else if (platform.equalsIgnoreCase("python")) {
			responseModel.setTittle("Technology Stack");
			responseModel.setPlatform("python");
			responseModel.setUsedFor("Machine Learning");
		} else {
			responseModel.setTittle("Technology Stack");
			responseModel.setPlatform(platform);
			responseModel.setUsedFor("Unknown platform");
		}

		responseModel.setServerPort(Short.parseShort(env.getProperty("local.server.port")));

		return responseModel;

	}

	;
}