package ua.accouting_of_cats.model;

import javax.persistence.*;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long catId;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ownerId")
    private Owner owner;

    public Cat() {
    }

    public Cat(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
