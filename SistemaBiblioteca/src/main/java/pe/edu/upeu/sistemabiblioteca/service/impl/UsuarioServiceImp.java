package pe.edu.upeu.sistemabiblioteca.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sistemabiblioteca.modelo.Usuario;
import pe.edu.upeu.sistemabiblioteca.repository.UsuarioRepository;
import pe.edu.upeu.sistemabiblioteca.service.IUsuarioService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImp extends CrudGenericoServiceImp<Usuario, Long> implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired

    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Usuario loginUsuario(String nombreUsuario, String clavePlain) {
        Usuario u = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if (u == null) return null;

        // compara texto plano con hash guardado
        if (passwordEncoder.matches(clavePlain, u.getClave())) {
            return u;
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioRepository getRepo() {
        return usuarioRepository;
    }
}
