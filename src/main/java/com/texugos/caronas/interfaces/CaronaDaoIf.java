

package com.texugos.caronas.interfaces;

import com.texugos.caronas.classes.Carona;
import java.util.List;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 22/07/2017 , 13:23:01
 */
public interface CaronaDaoIf {
    
    public boolean salvar(Carona carona);

    public boolean remover(Carona carona);
    
    public boolean atualizar(Carona carona);
    
    public Carona buscaPorId(Carona carona);
    
    public List<Carona> buscarTodos();
    
    public List<Carona> buscarPorLocal(Carona carona);
}
