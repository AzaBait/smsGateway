package kg.azaboss.kompanion.smsapp.controller;

import kg.azaboss.kompanion.smsapp.dto.SmsDto;
import kg.azaboss.kompanion.smsapp.dto.StatusDto;
import kg.azaboss.kompanion.smsapp.service.SmsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    private SmsService smsService;


    public SmsController(SmsService smsService) {
        this.smsService = smsService;

    }

    @GetMapping("/list")
    public List<SmsDto> findAll() {
        List<SmsDto> listOfSms = smsService.findAll();
        return listOfSms;
    }

    @PostMapping("/send")
    public SmsDto send(@RequestBody SmsDto smsDto) {

        return smsService.sendSms(smsDto);
    }

    @GetMapping("/status/{smsId}")
    public StatusDto getStatus(@PathVariable Long smsId) {

        return smsService.getStatus(smsId);
    }
}
