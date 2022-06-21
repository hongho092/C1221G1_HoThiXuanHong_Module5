package com.hohong.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phuong_tien")
public class PhuongTien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bienSoXe;
    private String loaiXe;
    private String tenNhaXe;

    @ManyToOne
    @JoinColumn(name = "diem_di", referencedColumnName = "id")
    private DiaDiem diemDi;

    @ManyToOne
    @JoinColumn(name = "diem_dien", referencedColumnName = "id")
    private DiaDiem diemDen;

    private String soDienThoai;
    private String email;
    private String gioDi;
    private String gioDen;

//    id: number;
//    bienSoXe: string;
//    loaiXe: string;
//    tenNhaXe: string;
//    diemDi: DiaDiem;
//    diemDen: DiaDiem;
//    soDienThoai: string;
//    email: string;
//    gioDi: string;
//    gioDen: string;

}
