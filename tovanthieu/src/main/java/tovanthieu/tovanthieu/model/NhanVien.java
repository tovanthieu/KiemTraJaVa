package tovanthieu.tovanthieu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @Column(name = "Ma_NV")
    private String maNV;

    @Column(name = "Ten_NV")
    private String tenNV;

    @Column(name = "Phai")
    private String phai;

    @Column(name = "Noi_Sinh")
    private String noiSinh;

    @Column(name = "Ma_Phong")
    private String maPhong;

    @Column(name = "Luong")
    private int luong;

    // Constructors, getters, and setters
}


