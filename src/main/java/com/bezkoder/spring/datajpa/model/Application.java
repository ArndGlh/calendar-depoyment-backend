package com.bezkoder.spring.datajpa.model;

import com.bezkoder.spring.datajpa.model.enums.EApplication;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idApplication;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private EApplication application;

    public Application(){}

    public Application(EApplication application) {
        this.application = application;
    }

    public int getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(int idApplication) {
        this.idApplication = idApplication;
    }

    public EApplication getApplication() {
        return application;
    }

    public void setApplication(EApplication application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "Application{" +
                "idApplication=" + idApplication +
                ", application=" + application +
                '}';
    }
}


