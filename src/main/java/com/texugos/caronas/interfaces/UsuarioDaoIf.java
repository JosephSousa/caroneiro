

package com.texugos.caronas.interfaces;

import com.texugos.caronas.classes.Usuario;
import java.util.List;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 15/07/2017 , 19:49:14
 */
public interface UsuarioDaoIf {
     
    public boolean salvar(Usuario usuario);

    public boolean remover(Usuario usuario);
    
    public boolean atualizar(Usuario usuario);
    
    public List<Usuario> buscarTodos();
    
    public Usuario autenticacao(Usuario usuario);
    
}