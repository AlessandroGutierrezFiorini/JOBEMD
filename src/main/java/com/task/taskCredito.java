package com.task;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pojo.Usuario;
import com.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class taskCredito {

    @Autowired
    UsuarioService usuarioService;

    private static final Logger log = LoggerFactory.getLogger(taskCredito.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 15000)
    public void reportCurrentTime() {

        Calendar calendar = Calendar.getInstance();
        Double saldo = 0.0;
        List<Usuario> usuariosList = usuarioService.findAllUsers();

        for (Usuario user: usuariosList) {

            if(user.getEstacionado()){
                saldo = user.getSaldo();
                if(user.getSaldo() < 5){
                    user.setEstacionado(false);
                    user.setEstaciono(null);
                    usuarioService.updateUsuario(user);
                }else if(sumarMinutos(user.getEstaciono(),30).before(calendar.getTime())){
                    user.setSaldo(saldo - 5);
                    user.setEstaciono(calendar.getTime());
                    usuarioService.updateUsuario(user);
                }
            }
            log.info("Usuarios " + user.getId() );
        }
    }

    public Date sumarMinutos(Date fecha, int minutos){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.SECOND, minutos);
        return calendar.getTime();
    }
}