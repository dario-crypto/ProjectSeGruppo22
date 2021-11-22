package com.mycompany.project;

public interface StackLogic<E> extends Iterable<E> {

    /**
     * Inserisce un elemento in cima allo stack
     *
     * @param item rappresenta l'elemento che si vuole inserire nello stack
     */
    void push(E item);

    /**
     * Rimuove l'elemento in cima allo stack e lo restituisce
     *
     * @return restituisce l'elemento in cima allo stack
     * @throws StackEmptyException nel caso in cui lo stack è vuoto
     */
    E pop() throws StackEmptyException;

    /**
     * Restituisce l'elemento in cima allo stack
     *
     * @return un elemento in cima allo stack
     */
    E top();

    /**
     * Controlla se lo stack è vuoto
     *
     * @return true se lo stack è vuoto, altrimenti restituisce false
     */
    boolean isEmpty();

   

    /**
     * Restituisce una stringa che rappresenta il contenuto dello stack
     *
     * @return una stringa che rappresenta il contenuto dello stack
     */

    @Override
    String toString();

}
