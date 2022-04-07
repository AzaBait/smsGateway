package kg.azaboss.kompanion.smsapp.service;

import kg.azaboss.kompanion.smsapp.dto.SmsDto;
import kg.azaboss.kompanion.smsapp.dto.StatusDto;

import java.util.List;

public interface SmsService {

     SmsDto sendSms(SmsDto smsDto);
     List<SmsDto> findAll();
     StatusDto getStatus(Long smsId);
}



