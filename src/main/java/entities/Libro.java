package entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited

public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private int fecha;
    private String genero;
    private int pagina;
    private String autor;

    //relacion con autor
    @JoinTable(name = "libro-autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn( name = "autor_id")
    )
    @Builder.Default
    private Set<Autor> autores = new HashSet<>();

    //relacion con persona
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_persona")
    private Persona persona;

}
