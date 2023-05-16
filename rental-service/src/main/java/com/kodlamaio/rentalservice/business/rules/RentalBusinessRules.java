package com.kodlamaio.rentalservice.business.rules;

import com.kodlamaio.commonpackage.utils.exceptions.BusinessException;
import com.kodlamaio.rentalservice.api.clients.CarClient;
import com.kodlamaio.rentalservice.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private final RentalRepository repository;
    private final CarClient client;

    public void checkIfRentalExists(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("MODEL_NOT_EXISTS");
        }
    }

    public void ensureCarIsAvailable(UUID carId) {
        var response = client.checkIfCarAvailable(carId);
        if (!response.isSuccess()) {
            throw new BusinessException(response.getMessage());
        }
    }

    /*ASENKRON OLDUĞU İÇİN ÇALIŞTIRAMADIK :(((
  public void ensureCarIsAvailable(UUID carId) {

        final ClientResponse[] response = new ClientResponse[1];
        final int[] flag = {5};

        TimerTask task = new TimerTask() {
            public synchronized void  run() {

                try {
                    log.info("try worked!!");
                    response[0] =client.checkIfCarAvailable(carId);
                    flag[0] =-1;


                } catch (RuntimeException e) {
                    flag[0]--;
                    if(flag[0] ==0){
                        throw e;
                    }


                }

            }
        };

        Timer timer = new Timer("Timer");
        long delay = 3000L;

        timer.schedule(task, delay, 5);

    }

 */
}
