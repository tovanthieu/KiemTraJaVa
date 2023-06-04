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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PHONGBAN")
public class PhongBan {
    @Id
    @Column(name = "Ma_Phong")
    private String maPhong;

    @Column(name = "Ten_Phong")
    private String tenPhong;

// Constructors, getters, and setters
}