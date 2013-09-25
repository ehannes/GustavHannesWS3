package edu.chl.hajo.jsfs.bb;

import edu.chl.hajo.jsfs.mb.ShopBean;
import edu.chl.hajo.shop.core.IProductCatalogue;
import edu.chl.hajo.shop.core.Product;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Common code for delete and edit (which uses conversational scope) 
 * @author hajo
 */
public abstract class ConversationalBase implements Serializable {

    private Long id;

    @NotNull(message="{common.notEmpty}")
    @Size(min=4, max=20, message="{product.name}")
    private String name;
    
    @NotNull(message="{common.notEmpty}")
    @Min(value=0, message = "{product.price}")
    @Max(value=100000, message = "{product.price}")
    private String price;
    
    @Inject
    private transient ShopBean shop;
    
    @Inject
    private Conversation conversation;

    // Must have String???
    public void setSelected(String id) {
        Logger.getAnonymousLogger().log(Level.INFO, "setSelected id={0}", id);
        if (conversation.isTransient()) {
            conversation.begin();
        }
        Product p = shop.getProductCatalogue().find(Long.valueOf(id));
        Logger.getAnonymousLogger().log(Level.INFO, "setSelected p={0}", p);
        this.id = p.getId();
        this.name = p.getName();
        this.price = String.valueOf(p.getPrice());
    }

    @PreDestroy  // Must have for back button etc.
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
            conversation.end();
        }
    }

    public String actOnSelected() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        execute();
        return Navigation.PRODUCT_SUCCESS.toString();
    }

    // Implemented by subclasses
    protected abstract void execute();

    protected IProductCatalogue getProductCatalogue() {
        return shop.getProductCatalogue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
