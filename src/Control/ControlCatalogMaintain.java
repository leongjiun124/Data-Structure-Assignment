/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.ArrayList;
import da.CatalogMaintainDA;
import Entity.DomainCatalogMaintain;


/**
 *
 * @author User
 */
public class ControlCatalogMaintain {
    
    private CatalogMaintainDA catalogMaintainDA;
    
    public ControlCatalogMaintain()
    {
        catalogMaintainDA=new CatalogMaintainDA();
    }
    
    public void addProduct(DomainCatalogMaintain catalogMaintain)
    {
        catalogMaintainDA.addProduct(catalogMaintain);
    }
    
    public ArrayList<DomainCatalogMaintain> getAllProduct() {
        return catalogMaintainDA.getAllProduct();
    }
    
    public void updatedProduct(DomainCatalogMaintain productItem) {
        catalogMaintainDA.updateProduct(productItem);

    }
        
        public void deleteRecord(String productID) {

        catalogMaintainDA.deleteProduct(productID);

    }
        
        public DomainCatalogMaintain getRecord(String productID) {
        return catalogMaintainDA.getRecord(productID);
    }
}
