package com.kiritoh.pedidos.enums;

public enum  TipoCliente {
    PERSONAFISICA(1,"persona fisica"),
    PERSONAJURIDICA(2,"persona juridica");

    private final Integer codigo;
    private final String descripcion;

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    TipoCliente(int cod, String descripcion) {
        this.codigo = cod;
        this.descripcion = descripcion;
    }

    public static TipoCliente toEnum (Integer cod){
        int b=0;
        if(cod == null){
            return null;
        }else{
            for(TipoCliente x : TipoCliente.values()){
                if(cod==x.getCodigo()){
                    b=1;
                    return x;
                }
            }
        }
        if(b==0){
            throw new IllegalArgumentException("Code invalid");
        }else{
            return null;
        }
    }

}
