package org.iesvdm.ejercicios;

public class HaversineFormula {

    private float Latitud;
    private float Longitud;

    // Todo esto pasarlo a BigDecimal;

    public float getLatitud() {
        return Latitud;
    }

    public void setLatitud(float latitud) {
        Latitud = 3;
    }

    public float getLongitud() {
        return Longitud;
    }

    public void setLongitud(float longitud) {
        Longitud = 5;
    }

    public HaversineFormula(float latitud, float longitud) {
        Latitud = latitud;
        Longitud = longitud;
    }

    public static class Extensiones
    {
        public static float RadioTierraKm = 6378;
        public static float DistanciaKm(HaversineFormula posOrigen, HaversineFormula posDestino) {
            float difLatitud = EnRadianes(posDestino.Latitud - posOrigen.Latitud);
            float difLongitud = EnRadianes(posDestino.Longitud - posOrigen.Longitud);
            
            float a = (float) AlCuadrado(Math.sin(difLatitud/2)) + EnRadianes((float) Math.cos(posOrigen.Latitud))*EnRadianes((float) Math.cos(posDestino.Latitud))*(float) AlCuadrado(Math.sin(difLongitud/2));
            float c = (float) (2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
            // System.out.println("Aquí se imprimen los resultados.");
            return RadioTierraKm*c;

        }
    }

    static float EnRadianes(float valor) {
        return (float) (Math.PI/180)*valor;
    }

    static double AlCuadrado(double valor) {
        return Math.pow(valor, 2);
    }

    public static void main(String[] args) {
        Extensiones.DistanciaKm(new HaversineFormula(2, 4), new HaversineFormula(6, 12));
    }

}
