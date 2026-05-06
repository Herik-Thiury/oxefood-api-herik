package br.com.ifpe.oxefood.api.acesso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.acesso.TokenService;
import br.com.ifpe.oxefood.modelo.acesso.Usuario;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody AuthenticationRequest authRequest) {
        
        UsernamePasswordAuthenticationToken authenticationToken = 
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        return tokenService.gerarToken((Usuario) authentication.getPrincipal());
    }
}