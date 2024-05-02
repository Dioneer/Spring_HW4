package Pegas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "company")
public class Company implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_company", nullable = false, unique = true)
    private String companyName;
    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "company_loclas", joinColumns = @JoinColumn(name="company_id"))
    @MapKeyColumn(name="lang")
    @Column(name = "description")
    private Map<String, String> locales = new HashMap<>();
}
