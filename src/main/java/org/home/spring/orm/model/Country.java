package org.home.spring.orm.model;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import static java.util.Objects.hash;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = AUTO)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE_NAME")
    private String codeName;

    private Country() {
    }

    public Country(@Nonnull String name, @Nonnull String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }

        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        Country otherCountry = (Country) otherObject;

        return Objects.equals(codeName, otherCountry.codeName) && Objects.equals(name, otherCountry.name);
    }

    @Override
    public int hashCode() {
        return hash(name, codeName);
    }

    @Override
    public String toString() {
        return "Country [id=" + id + ", name=" + name + ", codeName=" + codeName + "]";
    }
}
