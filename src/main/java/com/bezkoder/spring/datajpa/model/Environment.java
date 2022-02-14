package com.bezkoder.spring.datajpa.model;

import com.bezkoder.spring.datajpa.model.enums.EEnvironment;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;

@Entity
@Table(name = "environment")
public class Environment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnvironment;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private EEnvironment environment;

    public Environment(){}

    public Environment(EEnvironment environment) {
        this.environment = environment;
    }

    public int getIdEnvironment() {
        return idEnvironment;
    }

    public void setIdEnvironment(int idEnvironment) {
        this.idEnvironment = idEnvironment;
    }

    public EEnvironment getEnvironment() {
        return environment;
    }

    public void setEnvironment(EEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "idEnvironment=" + idEnvironment +
                ", environment=" + environment +
                '}';
    }
}

