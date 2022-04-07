package kg.azaboss.kompanion.smsapp.dto;

import kg.azaboss.kompanion.smsapp.entity.SmsStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SmsDto {

    private Long id;
    private String phoneNumber;
    private String message;
    private SmsStatus smsStatus;
    private Date createdAt;
    private Date updatedAt;

}

