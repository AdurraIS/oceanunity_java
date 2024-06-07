package com.oceanunity.app.Controllers;
import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Infra.Security.TokenService;
import com.oceanunity.app.Models.DTOs.AuthenticationDTO;
import com.oceanunity.app.Models.DTOs.LoginResponseDTO;
import com.oceanunity.app.Models.DTOs.UsuarioDTO;
import com.oceanunity.app.Models.Entities.Usuario;
import com.oceanunity.app.Models.Entities.UsuarioRoles;
import com.oceanunity.app.Repositories.EmpresaRepository;
import com.oceanunity.app.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Validated AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        Usuario usuario = usuarioRepository.findUsuarioByEmail(data.getEmail());
        return ResponseEntity.ok(new LoginResponseDTO(token,usuario));
    }
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@RequestBody @Validated UsuarioDTO data){
        if(this.usuarioRepository.findByEmail(data.getEmail()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getSenha());
        Usuario usuario = new Usuario();
        usuario.setNome(data.getNome());
        usuario.setEmail(data.getEmail());
        usuario.setRole(UsuarioRoles.valueOf(data.getRole()));
        usuario.setSenha(encryptedPassword);
        usuario.setEmpresa(empresaRepository.findById(data.getEmpresaId())
                .orElseThrow(()->new ObjectNotFoundException("Empresa")));
        return ResponseEntity.ok(new UsuarioDTO(usuarioRepository.save(usuario)));
    }

}
