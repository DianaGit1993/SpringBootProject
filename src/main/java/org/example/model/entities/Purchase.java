package org.example.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "purchase")
@Table(name = "purchase")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Purchase {
     // se recomanda sa nu se foloseasca lombok pentru clasele de genul asta pentru ca pot aparea probleme cu anotarile

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String deliveryType;
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)   // - mai multe purchase-uri apartin de un user
    @JoinColumn(name = "user_id")    // -> coloana dupa care se face join
    private User user;
}
