public class No<T extends Comparable<T>>{
    private T item;
    private No<T> direita;
    private No<T> esquerda;
    private int altura;



public No(){
    this.setItem(null);
    this.setDireita(null);
    this.setEsquerda(null);
    this.altura = 0;
}

public No(T item){
    this.setItem(item);
    this.setDireita(null);
    this.setEsquerda(null);
    this.altura = 0;
}

public No(T item, No<T> direita, No<T> esquerda){
    this.setItem(item);
    this.setDireita(direita);
    this.setEsquerda(esquerda);
    this.altura = 0;
}



public T getItem() {
    return item;
}



public void setItem(T item) {
    this.item = item;
}



public No<T> getDireita() {
    return direita;
}



public void setDireita(No<T> direita) {
    this.direita = direita;
}



public No<T> getEsquerda() {
    return esquerda;
}



public void setEsquerda(No<T> esquerda) {
    this.esquerda = esquerda;
}



public int getAltura() {
    return altura;
}

private int getAltura(No<T> no){
    if(no != null){
        return no.getAltura();
    }
    else{
        return -1;
    }
}


/*  
 *  Calcula a altura do nó
 *  Se o no da esquerda for maior que o da direita retornar altura da esquerda + 1
 * Se o no da direita for maior que o da esquerda retornar altura da direita + 1
 * 
 */

public void setAltura(){
    int alturaEsquerda, alturaDireita;

    alturaEsquerda = getAltura(this.getEsquerda());
    alturaDireita = getAltura(this.getDireita());

    if(alturaEsquerda > alturaDireita){
        this.altura = alturaEsquerda + 1;
    }
    else{
        this.altura = alturaDireita + 1;
    }
}

/*
 * Calcula o fator de balanceamento do nó
 * pega a altura da esquerda e da direita e subtrai
 * esquerda - direita = fator de balanceamento
 */
public int getFatorBalaceamento()
{
int alturaEsquerda, alturaDireita;

alturaEsquerda = getAltura(this.getEsquerda());
alturaDireita = getAltura(this.getDireita());

return alturaEsquerda - alturaDireita;

}




}
