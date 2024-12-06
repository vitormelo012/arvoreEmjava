import java.util.NoSuchElementException;


public class ABB<E extends Comparable<E>> {


private No<E> raiz;


public ABB(){
    this.raiz = null;

}

public boolean vazia(){
    return this.raiz == null;
}

private E pesquisar(No<E> raizArvore, E procurado){


int comparacao;
if(raizArvore == null){
throw new NoSuchElementException("Item não encontrado");
}


comparacao = procurado.compareTo(raizArvore.getItem());

if(comparacao == 0){
return raizArvore.getItem();
}else if(comparacao < 0){
return pesquisar(raizArvore.getEsquerda(), procurado);
}

else{
    return pesquisar(raizArvore.getDireita(), procurado);
}

}


public E pesquisar(E procurado){
    return pesquisar(this.raiz, procurado);

}

protected No<E> adicionar(No<E> raizArvore, E item){

    int comparacao;

    if (raizArvore == null){
        raizArvore = new No<E>(item);
    }
     
    else{
        comparacao = item.compareTo(raizArvore.getItem());
if (comparacao < 0) {
    raizArvore.setEsquerda(adicionar(raizArvore.getEsquerda(), item));

}
else if (comparacao > 0){
    raizArvore.setDireita(adicionar(raizArvore.getDireita(), item));

    } 
    else {
        throw new RuntimeException("item ja inserido na arvore ");
    }

}
return raizArvore;
}

public void adicionar(E item){
    this.raiz = adicionar(this.raiz, item);
}


public void caminhamentoEmOrdem(){
    if(vazia())
    throw new IllegalStateException("Arvore vazia");    

    caminhamentoEmOrdem(this.raiz);
}
private void caminhamentoEmOrdem(No<E> raizArvore){
    if(raizArvore != null){
        caminhamentoEmOrdem(raizArvore.getEsquerda());
        System.out.println(raizArvore.getItem());
        caminhamentoEmOrdem(raizArvore.getDireita());
    }
}

    protected No<E> removerNoAntecessor(No<E> itemRetirar, No<E> raizArvore){
        
        if(raizArvore.getDireita() != null){
            raizArvore.setDireita(removerNoAntecessor(itemRetirar, raizArvore.getDireita()));
        }
        else {
            itemRetirar.setItem(raizArvore.getItem());
            raizArvore = raizArvore.getEsquerda();
        }
        return raizArvore;
    }


protected No<E> remover(No<E> raizArvore, E itemRemover){

    int comparacao;

    if (raizArvore == null){
throw new NoSuchElementException("Item não encontrado");
    } 
    comparacao = itemRemover.compareTo(raizArvore.getItem());

    if (comparacao == 0) {
        if (raizArvore.getDireita() == null) {
            raizArvore = raizArvore.getEsquerda();
        }
        else if(raizArvore.getEsquerda() == null){
            raizArvore = raizArvore.getDireita();
        }
        else{
            raizArvore.setEsquerda(removerNoAntecessor(raizArvore, raizArvore.getEsquerda()));
        }
    }
        else if(comparacao < 0){
            raizArvore.setEsquerda(remover(raizArvore.getEsquerda(), itemRemover));
        }
        else{
            raizArvore.setDireita(remover(raizArvore.getDireita(), itemRemover));
        }
        return raizArvore;
    
}

public void remover(E itemRemover){
    this.raiz = remover(this.raiz, itemRemover);
}
    
}