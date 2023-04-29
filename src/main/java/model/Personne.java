package model;

import java.util.Date;

public  abstract class Personne {
    protected String lastNname;
    protected String firstName;
    protected String nationalite;
    protected Date date_naisance;

    public Personne(String lastNname, String firstName, String nationalite, Date date_naisance) {
        this.lastNname = lastNname;
        this.firstName = firstName;
        this.nationalite = nationalite;
        this.date_naisance = date_naisance;
    }
    public String getLastNname() {
        return lastNname;
    }
    public void setLastNname(String lastNname) {
        this.lastNname = lastNname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Date getDate_naisance() {
        return date_naisance;
    }

    public void setDate_naisance(Date date_naisance) {
        this.date_naisance = date_naisance;
    }
}
