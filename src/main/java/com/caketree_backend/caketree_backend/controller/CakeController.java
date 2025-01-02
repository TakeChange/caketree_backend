package com.caketree_backend.caketree_backend.controller;

import com.caketree_backend.caketree_backend.model.AddCakeEntity;
import com.caketree_backend.caketree_backend.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cakes")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    // Get all cakes
    @GetMapping
    public ResponseEntity<List<AddCakeEntity>> getAllCakes() {
        return ResponseEntity.ok(cakeService.getAllCakes());
    }

    // Add a new cake
    @PostMapping
    public ResponseEntity<Object> addCake(@RequestBody AddCakeEntity cake) {
        // Save the cake
        AddCakeEntity savedCake = cakeService.saveCake(cake);

        // Custom response with success message and saved cake details
        CakeResponse response = new CakeResponse("Cake added successfully", savedCake);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Inner class for custom response structure
    static class CakeResponse {
        private String message;
        private AddCakeEntity cake;

        // Constructor
        public CakeResponse(String message, AddCakeEntity cake) {
            this.message = message;
            this.cake = cake;
        }

        // Getters and setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public AddCakeEntity getCake() {
            return cake;
        }

        public void setCake(AddCakeEntity cake) {
            this.cake = cake;
        }
    }
}
