# TP1 – Mon premier service REST avec Spring Boot

**Nom :** Rym Razgui  
**Groupe :** _(à compléter)_

## Description

API REST de gestion de tâches (to-do list) développée avec Spring Boot. Les tâches sont stockées en mémoire dans une liste Java : elles disparaissent à l'arrêt de l'application. L'API permet de lister, lire, créer, modifier et supprimer des tâches.

## Lancement

```bash
./mvnw spring-boot:run
```

L'application démarre sur `http://localhost:8080`.

## Routes

| Opération  | Verbe et URL            | Corps de la requête | Succès                 | Si l'id n'existe pas |
|------------|-------------------------|---------------------|------------------------|----------------------|
| Lister     | `GET /api/taches`       | aucun               | 200 + la liste         | —                    |
| Lire       | `GET /api/taches/{id}`  | aucun               | 200 + la tâche         | 404                  |
| Créer      | `POST /api/taches`      | JSON de la tâche    | 201 + la tâche créée   | —                    |
| Modifier   | `PUT /api/taches/{id}`  | JSON de la tâche    | 200 + la tâche modifiée| 404                  |
| Supprimer  | `DELETE /api/taches/{id}` | aucun             | 204 sans contenu       | 404                  |

## Tests (captures d'écran)

**Test 1 – `GET /api/taches` → 200 + les 2 tâches de départ**
![Test 1](images/test1.png)

**Test 2 – `GET /api/taches/1` → 200 + la tâche 1**
![Test 2](images/test2.png)

**Test 3 – `GET /api/taches/99` → 404**
![Test 3](images/test3.png)

**Test 4 – `POST /api/taches` → 201 + tâche avec id = 3**
![Test 4](images/test4.png)

**Test 5 – `PUT /api/taches/3` → 200 + terminee = true**
![Test 5](images/test5.png)

**Test 6 – `PUT /api/taches/99` → 404**
![Test 6](images/test6.png)

**Test 7 – `DELETE /api/taches/3` → 204 (corps vide)**
![Test 7](images/test7.png)

**Test 8 – `DELETE /api/taches/3` (de nouveau) → 404**
![Test 8](images/test8.png)

## Ce que j'ai appris

- Créer un projet Spring Boot avec Spring Initializr et le lancer avec le Maven Wrapper.
- Écrire un contrôleur REST avec `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping` et `@DeleteMapping`.
- Renvoyer les bons codes HTTP (200, 201, 204, 404) avec `ResponseEntity`.
- Tester une API avec Postman (et penser à choisir Body > raw > JSON pour éviter l'erreur 415).
- Utiliser Git et GitHub : commits réguliers avec des messages clairs, puis `git push`.
