package com.genericprojectmaven.healthcheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @ResponseBody
    @GetMapping(path = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> healthCheck() { return new ResponseEntity<>(HttpStatus.OK); }

    private String checkDatabaseStatus() {
        return "It will be implemented";
    }
}
