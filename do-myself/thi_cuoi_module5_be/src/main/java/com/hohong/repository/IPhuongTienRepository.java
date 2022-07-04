package com.hohong.repository;

import com.hohong.model.PhuongTien;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPhuongTienRepository extends JpaRepository<PhuongTien, Integer> {

    List<PhuongTien> findAllByLoaiXeContaining(String search);

    // lấy tất cả giá trị BienSoXe có cbv
    List<PhuongTien> findDistinctByBienSoXe(String cbv, Sort sort);

    // lấy giá trị BienSoXe có cbv đầu tiên
    List<PhuongTien> findDistinctFirstByBienSoXe(String cbv, Sort sort);

    // lấy tất cả giá trị BienSoXe có cbv
    List<PhuongTien> findByBienSoXe(String cbv, Sort sort);

    // lấy tất cả giá trị BienSoXe không có trong list
    List<PhuongTien> findByBienSoXeNotIn(List<String> fbjhdv, Sort sort);

    // lấy tất cả giá trị BienSoXe có trong list
    List<PhuongTien> findByBienSoXeIn(List<String> fbjhdv, Sort sort);

    // lấy tất cả giá trị BienSoXe có trong giữa dhf và gdv
    List<PhuongTien> findByBienSoXeBetween(String dhf, String gdv, Sort sort);

    // lấy tất cả giá trị GioDi có trong giữa dhf và gdv
    List<PhuongTien> findByGioDiBetween(String dhf, String gdv, Sort sort);

    // lấy tất cả giá trị (GioDi có trong giữa dhf và gdv) và (GioDen có trong giữa fus và fvd)
    // có thể trống start nhưng không thể trống end
    List<PhuongTien> findByGioDiBetweenAndGioDenBetween(String dhf, String gdv, String fus, String fvd, Sort sort);
}
