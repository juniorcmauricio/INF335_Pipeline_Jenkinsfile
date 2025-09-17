package br.unicamp.ic.inf335.beans.inf335_trabalho04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProdutoBeanTest {

    @Test
    void testCompareToValorMaior() {
        ProdutoBean produtoA = new ProdutoBean("001", "A", "", 200.0, "Novo");
        ProdutoBean produtoB = new ProdutoBean("002", "B", "", 100.0, "Novo");

        assertTrue(produtoA.compareTo(produtoB) > 0, "compareTo deveria retornar positivo se o valor for maior");
    }

    @Test
    void testCompareToValorMenor() {
        ProdutoBean produtoA = new ProdutoBean("001", "A", "", 100.0, "Novo");
        ProdutoBean produtoB = new ProdutoBean("002", "B", "", 200.0, "Novo");

        assertTrue(produtoA.compareTo(produtoB) < 0, "compareTo deveria retornar negativo se o valor for menor");
    }

    @Test
    void testCompareToValorIgual() {
        ProdutoBean produtoA = new ProdutoBean("001", "A", "", 150.0, "Novo");
        ProdutoBean produtoB = new ProdutoBean("002", "B", "", 150.0, "Novo");

        assertEquals(0, produtoA.compareTo(produtoB), "compareTo deveria retornar zero se os valores forem iguais");
    }
}