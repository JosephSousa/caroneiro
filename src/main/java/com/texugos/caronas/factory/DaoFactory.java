

package com.texugos.caronas.factory;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 15/07/2017 , 18:47:54
 */
public class DaoFactory {
    
    public static final int DAO_BD = 0;

    public static DaoFactoryIf createFactory(int factoryType) {
        if (factoryType == DAO_BD){
            return new DaoFactoryBD();
        }
        return null;
    }
}
