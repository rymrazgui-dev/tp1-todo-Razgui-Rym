package com.sesame.todo;

public class Tache {

    private Long id;
    private String titre;
    private boolean terminee;

    public Tache() {
    }

    public Tache(Long id, String titre, boolean terminee) {
        this.id = id;
        this.titre = titre;
        this.terminee = terminee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isTerminee() {
        return terminee;
    }

    public void setTerminee(boolean terminee) {
        this.terminee = terminee;
    }
}
