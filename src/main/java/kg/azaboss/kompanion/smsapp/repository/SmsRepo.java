package kg.azaboss.kompanion.smsapp.repository;

import kg.azaboss.kompanion.smsapp.entity.Sms;
import kg.azaboss.kompanion.smsapp.entity.SmsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsRepo extends JpaRepository<Sms, Long> {

    @Modifying
    @Query("update Sms s set s.smsStatus = :smsStatus where s.id = :id")

    void updateStatus(@Param(value = "id") long id, @Param(value = "smsStatus") SmsStatus smsStatus);

 //   void updateStatus(Long smsId, SmsStatus smsStatus);
}
