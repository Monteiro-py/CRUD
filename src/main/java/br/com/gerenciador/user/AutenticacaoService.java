package br.com.gerenciador.user;

import br.com.gerenciador.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    UserRepository repositorioUser;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositorioUser.findByLogin(username);
    }
}
