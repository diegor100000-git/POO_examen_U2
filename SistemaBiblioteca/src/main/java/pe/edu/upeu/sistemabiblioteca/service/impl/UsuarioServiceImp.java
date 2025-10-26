package pe.edu.upeu.sistemabiblioteca.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sistemabiblioteca.modelo.Usuario;
import pe.edu.upeu.sistemabiblioteca.repository.ICrudGenericoRepository;
import pe.edu.upeu.sistemabiblioteca.repository.UsuarioRepository;
import pe.edu.upeu.sistemabiblioteca.service.IUsuarioService;

    @RequiredArgsConstructor
    @Service
    public class UsuarioServiceImp extends CrudGenericoServiceImp<Usuario, Long> implements IUsuarioService {
        private final UsuarioRepository usuarioRepository;
        @Override
        protected ICrudGenericoRepository<Usuario, Long> getRepo() {
            return usuarioRepository;
        }
}
