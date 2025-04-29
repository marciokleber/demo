package com.github.marciokleber.demo.app.domain;

import com.github.marciokleber.demo.core.standard.domain.StandardEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;


@Entity
@Getter
@Setter
@SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_USUARIO", allocationSize = 1)
public class Usuario extends StandardEntity {

    @Comments(@Comment("CAMPO IDENTIFICADOR DO NOME DO USUÁRIO"))
    private String name;
}
