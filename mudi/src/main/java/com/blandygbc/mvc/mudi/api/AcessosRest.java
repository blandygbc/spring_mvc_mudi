package com.blandygbc.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blandygbc.mvc.mudi.interceptor.InterceptadorDeAcessos;
import com.blandygbc.mvc.mudi.interceptor.InterceptadorDeAcessos.Acesso;

@RestController
@RequestMapping("api/acessos")
public class AcessosRest {

    @GetMapping
    public List<Acesso> getAcessos() {
        return InterceptadorDeAcessos.acessos;
    }

}
