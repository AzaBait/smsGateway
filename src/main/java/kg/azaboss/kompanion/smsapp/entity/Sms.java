package kg.azaboss.kompanion.smsapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "sms_gateway")
public class Sms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String phoneNumber;
    private String message;

    @Enumerated(EnumType.STRING)
    private SmsStatus smsStatus;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}
