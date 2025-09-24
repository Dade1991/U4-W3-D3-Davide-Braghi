package epicode.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private long id;

    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    @Enumerated(EnumType.STRING)
    private SessoPersona sessoPersona;

    public Persona() {
    }

    public Persona(String nome,
                   String cognome,
                   String email,
                   LocalDate dataDiNascita,
                   SessoPersona sessoPersona
    ) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sessoPersona = sessoPersona;
    }

    public long getId() {
        return id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public SessoPersona getSessoPersona() {
        return sessoPersona;
    }

    public void setSessoPersona(SessoPersona sessoPersona) {
        this.sessoPersona = sessoPersona;
    }
    

    @Override
    public String toString() {
        return "Persona {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sessoPersona=" + sessoPersona +
                '}';
    }
}
