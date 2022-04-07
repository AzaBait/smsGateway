package kg.azaboss.kompanion.smsapp.entity;

import kg.azaboss.kompanion.smsapp.service.Impl.NikitaSmsSender;


public class SmsSenderFactory {

    private String phoneNumber;
    private Long systemId;

    public static SmsSender getSender(String phoneNumber, Long systemId) {
        return new NikitaSmsSender();
    }

}
