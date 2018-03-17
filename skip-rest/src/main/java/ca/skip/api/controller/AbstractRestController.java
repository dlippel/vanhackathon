package ca.skip.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.skip.api.config.Constants;

@RequestMapping(value = Constants.REST_BASE_PATH, headers = Constants.HEADER, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public abstract class AbstractRestController {

}
