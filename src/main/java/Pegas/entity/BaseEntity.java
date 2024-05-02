package Pegas.entity;

import java.io.Serializable;

public interface BaseEntity<I extends Serializable>{
    I getId();
    void setId(I i);
}
