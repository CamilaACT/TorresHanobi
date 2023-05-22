import java.util.Objects;
import java.util.Stack;

public class Partida {
    private int NumUsuarioMovimientos;
    private Stack<String> torreA;
    private Stack<String> torreB;
    private Stack<String> torreC;
    private int NumDiscos;
    private double NumMovimeintos;
    private boolean pararPartida;
    //private tableManagment tb;

    public Partida(int numDiscos1) {
        this.NumDiscos = numDiscos1;
        this.NumUsuarioMovimientos=0;
        this.pararPartida=false;
        this.NumMovimeintos=calcularMovimientosMinimos(numDiscos1);
        torreA=new Stack<String>();
        torreB=new Stack<String>();
        torreC=new Stack<String>();
        //tb=new tableManagment();
        cargarTorreA();
    }
    private double calcularMovimientosMinimos(int NumDiscos){
        return Math.pow(2,NumDiscos)-1;
    }

    public int sumarMovimientos(){
        NumUsuarioMovimientos=NumUsuarioMovimientos+1;
        return NumUsuarioMovimientos;
    }
    public void restablecerPartida()
    {
        NumMovimeintos=0;
        NumUsuarioMovimientos=0;
    }

    private void cargarTorreA(){
        String datos="";
        for(int x=NumDiscos;x>=1;x--){
            datos+="#";
            torreA.add(datos);
        }
        Stack<String> pilaCopia = new Stack<>();
        while (!torreA.isEmpty()) {
            pilaCopia.add(torreA.pop());
        }
        torreA.addAll(pilaCopia);

    }

    public String[] datosTorreA()
    {
        Stack<String> pilaCopia = new Stack<>();
        pilaCopia.addAll(torreA);
        String[] datos=new String[10];
        int posicion=10-torreA.size();
        while (!pilaCopia.isEmpty()) {
            datos[posicion]=pilaCopia.pop();
            posicion++;
        }

        return datos;
    }
    public String[] datosTorreB()
    {
        Stack<String> pilaCopia = new Stack<>();
        pilaCopia.addAll(torreB);
        String[] datos=new String[10];
        int posicion=10-torreB.size();
        while (!pilaCopia.isEmpty()) {
            datos[posicion]=pilaCopia.pop();
            posicion++;
        }

        return datos;
    }
    public String[] datosTorreC()
    {
        Stack<String> pilaCopia = new Stack<>();
        pilaCopia.addAll(torreC);
        String[] datos=new String[10];
        int posicion=10-torreC.size();
        while (!pilaCopia.isEmpty()) {
            datos[posicion]=pilaCopia.pop();
            posicion++;
        }

        return datos;
    }

    public boolean deTorreAaTorreB(){
        String ficha;
        String aux;
        if(torreA.size()>0)
        {
            if(torreB.size()>0){
                aux=torreB.peek();
               if(aux.length()<torreA.peek().length()){
                   return false;
               }
               else {
                   ficha=torreA.pop();
                   torreB.add(ficha);
                   return true;
               }
            }
            else
            {
                ficha=torreA.pop();
                torreB.add(ficha);
                return true;
            }
        }
        else {
            return false;
        }
    }

    public int deTorreAaTorreC(){
        String ficha;
        String aux;
        if(torreA.size()>0)
        {
                if (torreC.size() > 0) {
                    aux = torreC.peek();
                    if (aux.length() < torreA.peek().length()) {
                        return 0;
                    } else {
                        ficha = torreA.pop();
                        torreC.add(ficha);
                        if (torreC.size()==NumDiscos) {
                            return 2;
                        }
                        return 1;
                    }
                } else {
                    ficha = torreA.pop();
                    torreC.add(ficha);
                    return 1;
                }
        }else {
            return 0;
        }

    }
    public boolean deTorreCaTorreA(){
        String ficha;
        String aux;
        if(torreC.size()>0)
        {
            if(torreA.size()>0){
                aux=torreA.peek();
                if(aux.length()<torreC.peek().length()){
                    return false;
                }
                else {
                    ficha=torreC.pop();
                    torreA.add(ficha);
                    return true;
                }
            }
            else
            {
                ficha=torreC.pop();
                torreA.add(ficha);
                return true;
            }
        }
        else {
            return false;
        }
    }
    public boolean deTorreCaTorreB(){
        String ficha;
        String aux;
        if(torreC.size()>0)
        {
            if(torreB.size()>0){
                aux=torreB.peek();
                if(aux.length()<torreC.peek().length()){
                    return false;
                }
                else {
                    ficha=torreC.pop();
                    torreB.add(ficha);
                    return true;
                }
            }
            else
            {
                ficha=torreC.pop();
                torreB.add(ficha);
                return true;
            }
        }
        else {
            return false;
        }
    }

    public int deTorreBaTorreC(){
        String ficha;
        String aux;
        if(torreB.size()>0)
        {
            if (torreC.size() > 0) {
                aux = torreC.peek();
                if (aux.length() < torreB.peek().length()) {
                    return 0;
                } else {
                    ficha = torreB.pop();
                    torreC.add(ficha);
                    if (torreC.size()==NumDiscos) {
                        return 2;
                    }
                    return 1;
                }
            } else {
                ficha = torreB.pop();
                torreC.add(ficha);
                return 1;
            }
        }else {
            return 0;
        }

    }

    public boolean deTorreBaTorreA(){
        String ficha;
        String aux;
        if(torreB.size()>0)
        {
            if(torreA.size()>0){
                aux=torreA.peek();
                if(aux.length()<torreB.peek().length()){
                    return false;
                }
                else {
                    ficha=torreB.pop();
                    torreA.add(ficha);
                    return true;
                }
            }
            else
            {
                ficha=torreB.pop();
                torreA.add(ficha);
                return true;
            }
        }
        else {
            return false;
        }
    }


    public double getNumMovimeintos() {
        return NumMovimeintos;
    }

    public int getNumUsuarioMovimientos() {
        return NumUsuarioMovimientos;
    }

    public void moverPlataforma(boolean resp,Stack<String> pilaorigen,Stack<String> piladestino){
        String aux="";
        if(resp==false){
            aux=pilaorigen.pop();
            piladestino.add(aux);
            sumarMovimientos();
        }else{
           resp=true;
        }

    }
    public boolean Recursivo(boolean res,int n,Stack<String> pilaorigen,Stack<String> pilaauxiliar,Stack<String> piladestino){

        if (n == 1) {
            moverPlataforma(res,pilaorigen,piladestino);

            return false;
        }else{
            Recursivo(res,n-1,pilaorigen,piladestino,pilaauxiliar);
            moverPlataforma(res,pilaorigen,piladestino);
            Recursivo(res,n-1,pilaauxiliar,pilaorigen,piladestino);

        }
        return true;

    }

    public void iniciarRec(boolean stop){
        if(stop==false){
            Recursivo(stop,getNumDiscos(),torreA,torreB,torreC);
        }
    }

    public int getNumDiscos() {
        return NumDiscos;
    }
}

