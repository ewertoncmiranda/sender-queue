package com.miranda.sqsfila.database;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String mensagem ;

    @CreationTimestamp
    @Column(name = "time")
    private LocalDateTime horaDaMensagem ;

}
