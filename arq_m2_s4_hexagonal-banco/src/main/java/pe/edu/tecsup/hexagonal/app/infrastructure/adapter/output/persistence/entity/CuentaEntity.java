package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "cuenta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaEntity {

    @Id
    @Column(name = "cuenta_id")
    private String cuentaId;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    private BigDecimal saldo;

    private String estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public void retirar(BigDecimal monto){

        if(this.saldo.compareTo(monto) < 0){
            throw new RuntimeException("Saldo insuficiente");
        }

        this.saldo = this.saldo.subtract(monto);
    }

    public void depositar(BigDecimal monto){

        this.saldo = this.saldo.add(monto);
    }
}
