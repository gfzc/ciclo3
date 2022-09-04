package com.udea.ciclo3.dominio;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empleado")
    private Long idEmpleado;

    @Column(name = "id_empresa")
    private Long idEmpresa;

    @Column(name = "id_perfil")
    private String idPerfil;

   @Column(name = "email", unique = true)
    private String email;

    @Column(name = "rol", length = 20)
    @Enumerated(EnumType.STRING)
    private EnumRole rol;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "id_empresa", insertable = false, updatable = false)
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado")
    private List<Transaccion>transacciones;

    @OneToOne
    @JoinColumn(name = "id_perfil", insertable = false, updatable = false)
    private Perfil perfil;





}
