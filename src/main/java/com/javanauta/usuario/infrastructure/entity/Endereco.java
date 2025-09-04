package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter     // AQUI EU PEGUEI TODAS AS ANOTAÇÕES DE USUARIO, AGORA SÓ MUDAR O NOME DA TABLE
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private long numero;
    @Column(name = "complemento", length = 10)
    private String complemento;
    @Column ( name = "cidade", length = 150)
    private String cidade;
    @Column (name = "estado", length = 2)
    private String estado;
    @Column (name = "cep", length = 9)
    private String cep;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")

    // AGORA VAMOS CRIAR A TABELA DE TELEFONE
    private List<Endereco> telefone;







}
