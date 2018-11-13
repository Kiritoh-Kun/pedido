package com.kiritoh.pedidos.converter;

import com.kiritoh.pedidos.entity.entityCategoria;
import com.kiritoh.pedidos.entity.entityProducto;
import com.kiritoh.pedidos.model.modelCategoria;
import com.kiritoh.pedidos.model.modelProductos;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;

@Component("converter")
public class converter {
    public static final org.apache.commons.logging.Log Log= LogFactory.getLog(modelCategoria.class);

    public List<modelCategoria> ModelLista(List<entityCategoria> categorias){
        List<modelCategoria> Mlista=new ArrayList<>();
        for( entityCategoria x : categorias){
            Mlista.add(new modelCategoria(x));
        }
        return Mlista;
    }
    public List<modelProductos> ModelListaP(List<entityProducto> EListP){
        Log.warn("llegamos al converter");
        if(EListP==null){
            System.out.print("lista de productos nula");
            return null;

        }else{
            Log.warn("hay lista de productos");
            List<modelProductos> MListaP = new ArrayList<>();
            for(entityProducto ep : EListP){
                Log.warn("crea la lista modelo de productos");
                MListaP.add(new modelProductos(ep));
            }
            return MListaP;
        }

    }
}
