/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.hajo.jsfs.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 *
 * @author hannes
 */
@Named("delProduct")
@ConversationScoped
public class DeleteProductBB extends ConversationalBase {
    
    @Override
    protected void execute() {
        getProductCatalogue().remove(getId());
    }
    
}
