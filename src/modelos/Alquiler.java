package modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "alquieres")
public class Alquiler implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Date de java.sql
    @Column
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "id_abonado")
    private Abonado abonado;
    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Alquiler() {
    }

    public Alquiler(int id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Abonado getAbonado() {
        return abonado;
    }

    public void setAbonado(Abonado abonado) {
        this.abonado = abonado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
