package kg.azaboss.kompanion.smsapp.service.Impl;

import kg.azaboss.kompanion.smsapp.dto.SmsDto;
import kg.azaboss.kompanion.smsapp.dto.StatusDto;
import kg.azaboss.kompanion.smsapp.entity.Sms;
import kg.azaboss.kompanion.smsapp.entity.SmsSender;
import kg.azaboss.kompanion.smsapp.entity.SmsSenderFactory;
import kg.azaboss.kompanion.smsapp.entity.SmsStatus;
import kg.azaboss.kompanion.smsapp.repository.SmsRepo;
import kg.azaboss.kompanion.smsapp.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    private SmsRepo smsRepo;
    private ModelMapper modelMapper;

    public SmsServiceImpl(SmsRepo smsRepo, ModelMapper modelMapper) {
        this.smsRepo = smsRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public SmsDto sendSms(SmsDto smsDto) {

        log.info("Send sms called for phone: {} and systemId: {}");

        Sms sms = convertToEntity(smsDto);
        sms.setSmsStatus(SmsStatus.SEND);
        smsRepo.save(sms);
        SmsSender smsSender = SmsSenderFactory.getSender("+996775263548", 1L);
        smsSender.send("+996779635847", "come on baby");
        smsRepo.updateStatus(sms.getId(), SmsStatus.DELIVERED);
        return convertToDto(sms);
    }

    @Override
    public List<SmsDto> findAll() {
        List<Sms> listOfSms = smsRepo.findAll();
        return listOfSms.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public StatusDto getStatus(Long smsId) {
        Sms sms = smsRepo.getById(smsId);
        StatusDto statusDto = new StatusDto();
        statusDto.setStatus(sms.getSmsStatus().name());
        statusDto.setSmsId(smsId);
        return statusDto;
    }

    private SmsDto convertToDto(Sms sms) {
        SmsDto smsDto = modelMapper.map(sms, SmsDto.class);
        return smsDto;
    }

    private Sms convertToEntity(SmsDto smsDto) {
        Sms sms = modelMapper.map(smsDto, Sms.class);
        return sms;
    }
}
