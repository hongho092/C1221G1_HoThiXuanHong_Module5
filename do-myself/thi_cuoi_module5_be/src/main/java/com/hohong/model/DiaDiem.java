package com.hohong.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dia_diem")
@JsonIgnoreProperties({"phuongTienList1", "phuongTienList2"})
public class DiaDiem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenDiaDiem;

    @JsonManagedReference
    @JsonBackReference(value = "")
    @OneToMany(mappedBy = "diemDi")
    private List<PhuongTien> phuongTienList1;

    @JsonManagedReference
    @JsonBackReference
    @OneToMany(mappedBy = "diemDen")
    private List<PhuongTien> phuongTienList2;
}
