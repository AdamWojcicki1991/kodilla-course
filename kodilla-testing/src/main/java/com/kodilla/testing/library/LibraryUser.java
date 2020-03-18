package com.kodilla.testing.library;

public class LibraryUser {
    String firstname;
    String lastname;
    String PESEL;

    public LibraryUser(String firstname, String lastname, String PESEL) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.PESEL = PESEL;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPESEL() {
        return PESEL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryUser that = (LibraryUser) o;

        if (!firstname.equals(that.firstname)) return false;
        if (!lastname.equals(that.lastname)) return false;
        return PESEL.equals(that.PESEL);
    }

    @Override
    public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + PESEL.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", PESEL='" + PESEL + '\'' +
                '}';
    }
}
