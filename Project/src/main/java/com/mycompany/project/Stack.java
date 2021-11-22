package com.mycompany.project;

import java.util.Iterator;

public class Stack<E> implements Iterable<E>, StackLogic<E> {

    private E[] stack;
    private int size = 0;
    private int currentCapacity;

    /**
     * Costruttore della classe Stack
     *
     * @param initialCapacity valore intero che rappresenta la capacità inziale
     * dello stack
     */
    public Stack(int initialCapacity) {
        this.stack = (E[]) new Object[initialCapacity];
        this.currentCapacity = initialCapacity;

    }

    /**
     * Costruttore della classe stack. Setta una capacità iniziale di default
     */
    public Stack() {
        int defaultCapacity = 30;
        this.stack = (E[]) new Object[defaultCapacity];
        this.currentCapacity = defaultCapacity;
    }

    /**
     * Restituisce il numero di elementi presenti nello stack
     *
     * @return un numero intero che rappresenta il numero di elementi presenti
     * nello stack
     */
    public int getSize() {
        return size;
    }

    /**
     * Restituisce l'elemento in cima allo stack
     *
     * @return un elemento in cima allo stack
     */
    @Override
    public E top() {
        return stack[size - 1];
    }

    /**
     * Inserisce un elemento in cima allo stack
     *
     * @param item rappresenta l'elemento che si vuole inserire nello stack
     */
    @Override
    public void push(E item) {

        if (isFull()) {
            realloc(currentCapacity * 2);
        }

        stack[size] = item;
        size++;

    }

    /**
     * Rialloca gli elementi dello vecchio stack in un nuovo stack con capacità
     * specificata
     *
     * @param newCapacity capacità del nuovo stack
     */
    private void realloc(int newCapacity) {
        E[] newStack = (E[]) new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
        currentCapacity = newCapacity;

    }

    /**
     * Rimuove l'elemento in cima allo stack e lo restituisce
     *
     * @return restituisce l'elemento in cima allo stack
     * @throws StackEmptyException nel caso in cui lo stack è vuoto
     */
    @Override
    public E pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        E item = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return item;

    }

    /**
     * Controlla se lo stack è pieno
     *
     * @return true nel caso lo stack è pieno, altrimenti restituisce false
     */
    private boolean isFull() {
        return size >= currentCapacity;
    }

    /**
     * Controlla se lo stack è vuoto
     *
     * @return true se lo stack è vuoto, altrimenti restituisce false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Classe che permette allo stack di essere iterato
     */
    public class StackIterator implements Iterator<E> {

        int index = 0;

        /**
         * Controlla se è presente il successivo elemento
         *
         * @return true nel caso in cui è presente l'elemento successivo,
         * altrimenti restituisce false
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * Restituisce il successivo elemento
         *
         * @return restituisce il successivo elemento
         */
        @Override
        public E next() {
            if (hasNext()) {
                E item = stack[index];
                index++;
                return item;
            }
            return null;
        }
    }

    /**
     * Restituisce l'iteratore dello stack
     *
     * @return l'iteratore dello stack
     */
    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    /**
     * Restituisce una stringa che rappresenta il contenuto dello stack
     *
     * @return una stringa che rappresenta il contenuto dello stack
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = size - 1; i >= 0; i--) {
            sb.append(stack[i]);
            sb.append("\n");
        }
        return sb.toString();

    }

    /**
     * Restituisce un elemento dello stack in una specifica posizione
     *
     * @param index valore intero che rappresenta un indice dello stack
     * @return restituisce un elemento dello stack in posizione index
     */
    public E getItem(int index) {
        return stack[index];
    }

    /**
     * Restituisce la capacità corrente dello stack
     *
     * @return un valore intero che rappresenta la capacità corrente dello stack
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

}
