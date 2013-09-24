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
@Named("editProduct")
@RequestScoped
public class EditProductBB extends ConversationalBase {

    public String edit(){
        return null;
    }
    
    @Override
    protected void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
