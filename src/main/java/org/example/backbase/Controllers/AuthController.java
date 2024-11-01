package org.example.backbase.Controllers;

import org.example.backbase.Entity.BuyerClient;
import org.example.backbase.Entity.SellerClient;
import org.example.backbase.Services.ClientService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/registerClient")
    public ResponseEntity<String> registerClient(@RequestBody BuyerClient buyerClient) {
        try {
            // Сохраняем пользователя
            clientService.saveClient(buyerClient.getUsername(), buyerClient.getPassword());
            return ResponseEntity.ok("Регистрация клиента прошла успешно");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Пользователь(Клиент) уже существует");
        }
    }

    @PostMapping("/registerSeller")
    public ResponseEntity<String> registerSeller(@RequestBody SellerClient sellerClient){
        try {

            clientService.saveClient(sellerClient.getUsername(),sellerClient.getPassword());
            return ResponseEntity.ok("Регистрия продавца прошла успешно");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Пользователь(Продавец) уже существует");
        }
    }

    @PostMapping
    public boolean checkClient(@RequestBody String name){
        return clientService.findByUsername(name) != null;
    }

}