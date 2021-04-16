package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name="Perfil")
@Table(name="perfil")
@Data
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "nick")
    private String nick;
    
    @ManyToOne
    @JoinColumn(name = "perfil_grupo_id")
    private PerfilGrupo perfilGrupo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<Ejercicio> ejerciciosCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<Ejercicio> ejerciciosModificador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<Parametro> parametrosCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<Parametro> parametrosModificador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<ParametroGrupo> parametrosGrupoCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<ParametroGrupo> parametrosGrupoModificador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<ParametroLista> parametroListasCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<ParametroLista> parametroListasModificador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<ParametroSublista> parametroSublistasCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<ParametroSublista> parametroSublistasModificador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<MedidaGrupo> medidasGrupoCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<MedidaGrupo> medidasGrupoModificador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<MedidaUnidad> medidasUnidadCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<MedidaUnidad> medidasUnidadModificador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<MedidaParametroEjercicio> medidasParametroEjercicioCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<MedidaParametroEjercicio> medidasParametroEjercicioModificador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<Rutina> rutinasCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<Rutina> rutinasModificador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creador")
    private List<RutinaDia> rutinasDiaCreador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificador")
    private List<RutinaDia> rutinasDiaModificador;
    
}