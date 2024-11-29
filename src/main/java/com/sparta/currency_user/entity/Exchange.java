package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter
public class Exchange extends TimeEntity{

    public enum Status {
        NORMAL, CANCELLED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(nullable = false)
    private BigDecimal amountInKrw;

    @Column(nullable = false)
    private BigDecimal amountAfterExchange;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;


    @Builder
    public Exchange(User user, Currency currency, BigDecimal amountInKrw, BigDecimal amountAfterExchange) {
        this.user = user;
        this.currency = currency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = Status.NORMAL;
    }


    public void update_status(Status status) {
        this.status = status;
    }

    public Exchange() {
    }

}
