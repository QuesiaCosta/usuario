package com.javanauta.usuario.infrastructure.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // ISSO VAI APONTAR PARA O SPRING QUE É UMA TABELA DO BANCO DE DADOS
@Table (name = "usuario") // SEMPRE COLOCAR O NOME DA TABELA

public class Usuario implements UserDetails {

    @Id // ESSE ID É NOSSO INDENTIFICADOR UNICO
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ISSO É PARA GERAR AUTOMATICAMENTE NOSSOS ID
    private Long id;
    @Column(name = "nome", length = 100) // ESSA ANOTAÇÃO INDICA PARA NÓS QUAL O NOME DESSA COLUNA
    private String nome;
    @Column (name = "email", length = 100)
    private String email;
    @Column( name = "senha")
    private String senha;
    // AGORA VAMOS FAZER UMA TABELA DE VARIAS CARACTERISTICAS PARA O USUARIO
    @OneToMany(cascade = CascadeType.ALL)// ESSA ANOTAÇÃO É QUE O USUARIO TENHA MAIS DE UM ENDEREÇO OU TELEFONE
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")// ESSA ANOTAÇÃO É QUE BUSCA O NOME DO ONDE ESTÁ O ENDEREÇO E IDENTIFICAR QUE ESSE ENDEREÇO É DESTE USUARIO

    // AGORA VAMOS CRIAR A TABELA DE ENDEREÇO
    private List<Endereco> enderecos;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "senha";
    }

    @Override
    public String getUsername() {
        return "email";
    }
}
