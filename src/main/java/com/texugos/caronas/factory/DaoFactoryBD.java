

package com.texugos.caronas.factory;

import com.texugos.caronas.dao.CaronaDao;
import com.texugos.caronas.dao.UsuarioDao;
import com.texugos.caronas.interfaces.CaronaDaoIf;
import com.texugos.caronas.interfaces.UsuarioDaoIf;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 15/07/2017 , 18:49:55
 */
public class DaoFactoryBD implements DaoFactoryIf{
    
     @Override
    public UsuarioDaoIf criaUsuarioDAO() {
        return new UsuarioDao();
    }

    @Override
    public CaronaDaoIf criaCaronaDAO() {
        return new CaronaDao();
    }
    
}
