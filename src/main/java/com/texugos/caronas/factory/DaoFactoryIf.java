

package com.texugos.caronas.factory;

import com.texugos.caronas.interfaces.CaronaDaoIf;
import com.texugos.caronas.interfaces.UsuarioDaoIf;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 15/07/2017 , 18:48:39
 */
public interface DaoFactoryIf {
    
    public UsuarioDaoIf criaUsuarioDAO();
    public CaronaDaoIf criaCaronaDAO();
    
}
