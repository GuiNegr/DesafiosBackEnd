package com.picpay.picpay.service;

import com.picpay.picpay.domain.entity.ContaUser;
import com.picpay.picpay.domain.entity.TipoUser;
import com.picpay.picpay.domain.entity.User;
import com.picpay.picpay.exception.FalhaTransacao;
import com.picpay.picpay.exception.NaoPermitido;
import com.picpay.picpay.exception.SemFundos;
import com.picpay.picpay.repository.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PicPayService{
    @Autowired
    ContaRepository contaRepository;


    public ContaUser transferencia(Map<String,Object> request){

        User use = new User();
        ContaUser contaPagador = contaRepository.getReferenceById((Integer)request.get("payer"));
        ContaUser contaReceptor = contaRepository.getReferenceById((Integer)request.get("payee"));

        if(contaPagador.getSaldoConta() < (Double)request.get("value")) throw new SemFundos();
        if (contaPagador.getUsuarioConta().getTipo().equals(TipoUser.LOGISTA)) throw new NaoPermitido();
        if(!okMok()) throw new FalhaTransacao();

        contaPagador.setSaldoConta(contaPagador.getSaldoConta() - (Double)request.get("value"));
        contaRepository.save(contaPagador);
        contaReceptor.setSaldoConta((Double)request.get("value") + contaReceptor.getSaldoConta());
        contaRepository.save(contaReceptor);

        return contaPagador;

    }

    public Boolean okMok(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://util.devi.tools/api/v2/authorize";
        try{
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

            if(response.getStatusCode().is2xxSuccessful()){
                System.out.println("SUCESSO NA TRANSAÇÃO");
                return  true;
            }else{
                System.out.println("FALHA NA TRANSAÇÃO");
                return false;
            }
        }catch (HttpClientErrorException.Forbidden e){
            System.err.println("ERRO COM A REQUISIÇÃO "+e.getMessage());
            return false;
        }catch (RestClientException e){
            System.err.println("ERRO COM A REST CLIENT"+e.getMessage());
            return false;
        }

    }
}
