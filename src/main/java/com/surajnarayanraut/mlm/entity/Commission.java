package com.surajnarayanraut.mlm.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "commission")
public class Commission {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refer_to")
    private User referTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refer_by")
    private User referBy;


    private int level;

    private Float percentage;

}
