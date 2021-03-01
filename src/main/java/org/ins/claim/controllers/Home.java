package org.ins.claim.controllers;

import org.ins.claim.domain.Claim;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class Home {

    @RequestMapping(value = "/", produces = "application/json")
    public Claim root() {
        return new Claim(
                UUID.randomUUID().toString(),
                123456789L,
                "Sandy Henderson",
                "Vehicle");
    }
}
