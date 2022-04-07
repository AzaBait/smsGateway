package kg.azaboss.kompanion.smsapp.entity;


public interface SmsSender {

    public void send(String phoneNumber, String text);

}
