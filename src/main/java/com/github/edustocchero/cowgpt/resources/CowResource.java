package com.github.edustocchero.cowgpt.resources;

import com.github.edustocchero.cowgpt.cases.CowResponseCase;
import com.github.edustocchero.cowgpt.enums.CowLanguage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cows")
public class CowResource {

    private final CowResponseCase cowResponseCase;

    public CowResource(CowResponseCase cowPhraseCase) {
        this.cowResponseCase = cowPhraseCase;
    }

    @GetMapping("/{lang}")
    public ResponseEntity<CowResponse> query(
            @PathVariable("lang") CowLanguage cowLanguage,
            @RequestParam("q") String query
    ) {
        String response = cowResponseCase.handle(query, cowLanguage);

        CowResponse cowResponse = new CowResponse(response);
        return ResponseEntity.ok(cowResponse);
    }
}
