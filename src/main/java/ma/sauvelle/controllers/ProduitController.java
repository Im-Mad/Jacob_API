package ma.sauvelle.controllers;

import ma.sauvelle.models.Produit;
import ma.sauvelle.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("")
    public ResponseEntity<Object> getAllProduits(){
        return new ResponseEntity<>(produitService.findAll(), HttpStatus.OK);
    }

   @GetMapping("/search/{categoryId}")
    public ResponseEntity<Object> searchProduits(@PathVariable(value = "categoryId") int categoryId){
       return new ResponseEntity<>(produitService.findByCategorie(categoryId), HttpStatus.OK);
    }
}
