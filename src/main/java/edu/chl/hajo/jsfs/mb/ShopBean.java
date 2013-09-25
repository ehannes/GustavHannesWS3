/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.hajo.jsfs.mb;

import edu.chl.hajo.shop.core.IProductCatalogue;
import edu.chl.hajo.shop.core.IShop;
import edu.chl.hajo.shop.core.ShopFactory;
import javax.inject.Singleton;


/**
 * Wrapper for shop
 * @author hajo
 */

@Singleton
public class ShopBean {
    private final transient IShop s;

    private ShopBean() {
        s = ShopFactory.getShop(true);
    }

    public IProductCatalogue getProductCatalogue() {
        return s.getProductCatalogue();
    }
}