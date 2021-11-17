package e2;

import java.util.Objects;

public class Apartamentos implements Comparable<Apartamentos>{

    private final int referencias;
    private final int precioViviendas;
    private final int plazas;
    private final int tamanos;
    private final String CP;

    public Apartamentos(int referencia, int precio, int plaza, int tamano, String CPostal){

        if(referencia<=0 || tamano<=0 || precio<=0 || plaza<0 || CPostal == null){
            throw new IllegalArgumentException("Dato erróneo");
        }
        else{
            this.referencias=referencia;
            this.tamanos = tamano;
            this.precioViviendas = precio;
            this.plazas = plaza;
            this.CP = CPostal;
        }
    }

    public int getReferencias(){
        return this.referencias;
    }

    public int getPrecioViviendas(){
        return this.precioViviendas;
    }

    public int getPrecioPlazas(){
        return this.plazas*50;   // Adjudicamos para el cálculo de del precio final con plazas, 50 euros por plaza.
    }

    public int getTamanos(){
        return this.tamanos;
    }

    public String getCP(){
        return this.CP;
    }

    public int getPrecioFinal(){
        return precioViviendas+getPrecioPlazas();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if(!(o instanceof Apartamentos otroAp)){
            return false;
        }
        if(this.precioViviendas!= otroAp.precioViviendas){
            return false;
        }
        if(this.plazas!= otroAp.plazas){
            return false;
        }
        if(this.tamanos!=otroAp.tamanos){
            return false;
        }
        if(!Objects.equals(this.CP,otroAp.CP)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7; //Cogemos un número primo inicial para sacar un hashcode más "único".
        hash = 31 * hash + Objects.hashCode(this.precioViviendas);
        hash = 31 * hash + Objects.hashCode(this.plazas);
        hash = 31 * hash + Objects.hashCode(this.tamanos);
        hash = 31 * hash + Objects.hashCode(this.CP);

        return hash;
    }

    @Override
    public int compareTo(Apartamentos a) {
        int i;
        // COVERAGE BAJO EN ESTA FUNCIÓN YA QUE EL NÚMERO DE REFERENCIA SIEMPRE ES DISTINTO POR ESO AL COMPARAR POR REFERENCIA SIEMPRE SALE DISTINTO Y NO COMPARA CON LOS OTROS ATRIBUTOS.
        i = this.referencias - a.getReferencias();
        if (i != 0) return i;

        i = this.precioViviendas - a.getPrecioViviendas();
        if (i != 0) return i;

        i = (this.plazas) - a.getPrecioPlazas();
        if (i != 0) return i;

        i = this.tamanos - a.getTamanos();
        if (i != 0) return i;

        i = this.CP.compareTo(a.getCP());
        if (i != 0) return i;

        return i;
    }

    @Override
    public String toString(){
        StringBuilder apartment = new StringBuilder();
        apartment.append("Referencia: ").append(referencias).append(",").append(" PrecioBase: ").append(precioViviendas)
                .append(",").append(" Precio plazas: ").append(plazas).append(",").append(" Tamaño en m2: ").append(tamanos)
                .append(",").append(" Código Postal: ").append(CP).append(".").append("\n");
        return new String(apartment);
    }
}


