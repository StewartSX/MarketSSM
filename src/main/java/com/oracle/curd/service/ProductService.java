package com.oracle.curd.service;

import com.oracle.curd.bean.Product;
import com.oracle.curd.bean.ProductExample;
import com.oracle.curd.dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public List<Product> getAll(){
        return productMapper.selectByExample(null);
    }

    public Product getProductById(String proid){
        return productMapper.selectByPrimaryKey(proid);
    }

    public List<Product> getProductByExample(String protype, String proid, String pname, String supname){
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        if ((protype==null||protype.equals("")) && (proid==null || proid.equals("")) && (pname==null || pname.equals("")) && (supname==null || supname.equals(""))){
            return productMapper.selectByExample(null);
        } else {
            if (protype!=null && !protype.equals("")){
                criteria.andProtypeEqualTo(protype);
            }
            if (proid!=null && !proid.equals("")){
                criteria.andProidEqualTo(proid);
            }
            if (pname!=null && !pname.equals("")){
                criteria.andPnameEqualTo(pname);
            }
            if (supname!=null && !supname.equals("")){
                criteria.andSupnameEqualTo(supname);
            }
            return productMapper.selectByExample(example);
        }
    }

    public void addProduct(Product product){
        productMapper.insert(product);
    }

    public void removeProduct(String proid){
        productMapper.deleteByPrimaryKey(proid);
    }

    public void updateProduct(Product product){
        productMapper.updateByPrimaryKey(product);
    }


}
