/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.hajo.jsfs.bb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author hannes
 */
@Named("deleteProduct")
@RequestScoped
public class DeleteProductBB extends ConversationalBase {
    
    public String delete() {
        return null;
        //Product p = new Product(id, name, price);
        //shop.getProductCalalogue().add(p);
        //return Navigation.PRODUCT_SUCCESS.toString(); //TODO
    }
    
    @Override
    protected void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
