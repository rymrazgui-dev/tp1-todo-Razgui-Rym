package com.sesame.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    // Liste de tâches en mémoire, avec 2 tâches de départ (id 1 et 2)
    private final List<Tache> taches = new ArrayList<>();

    // Compteur pour les identifiants suivants (le prochain sera 3)
    private long compteur = 3;

    public TacheController() {
        taches.add(new Tache(1L, "Lire le chapitre 4", false));
        taches.add(new Tache(2L, "Faire le TP Spring Boot", false));
    }

    // GET /api/taches -> 200 + la liste
    @GetMapping
    public List<Tache> lister() {
        return taches;
    }

    // GET /api/taches/{id} -> 200 + la tâche, ou 404
    @GetMapping("/{id}")
    public ResponseEntity<Tache> lire(@PathVariable Long id) {
        Tache t = chercher(id);
        if (t == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(t);
    }


    @PostMapping
    public ResponseEntity<Tache> creer(@RequestBody Tache tache) {
        tache.setId(compteur++);
        taches.add(tache);
        return ResponseEntity.status(HttpStatus.CREATED).body(tache);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tache> modifier(@PathVariable Long id, @RequestBody Tache nouvelle) {
        Tache t = chercher(id);
        if (t == null) {
            return ResponseEntity.notFound().build();
        }
        t.setTitre(nouvelle.getTitre());
        t.setTerminee(nouvelle.isTerminee());
        return ResponseEntity.ok(t);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        Tache t = chercher(id);
        if (t == null) {
            return ResponseEntity.notFound().build();
        }
        taches.remove(t);
        return ResponseEntity.noContent().build();
    }

    // Retourne la tâche correspondante ou null
    private Tache chercher(Long id) {
        for (Tache t : taches) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }
}
