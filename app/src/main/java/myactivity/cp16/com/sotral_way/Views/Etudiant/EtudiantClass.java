package myactivity.cp16.com.sotral_way.Views.Etudiant;

public class EtudiantClass {
    private String numCard;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public EtudiantClass() {
    }

    public EtudiantClass(String numCard, String name, String lastName, String email, String password) {
        this.numCard = numCard;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getNumCard() {
        return numCard;
    }

    public void setNumCard(String numCard) {
        this.numCard = numCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
